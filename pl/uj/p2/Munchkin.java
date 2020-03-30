//Piotr Grabowski
package pl.uj.p2;

import pl.uj.p2.uzbrojenie.Bron;
import pl.uj.p2.uzbrojenie.Srebrny;
import pl.uj.p2.uzbrojenie.Stalowy;
import pl.uj.p2.wyjatki.NiedozwolonaKlasa;
import pl.uj.p2.wyjatki.NiedozwolonaRasa;
import pl.uj.p2.wyjatki.NiedozwoloneUzbrojenie;

public class Munchkin implements InterfejsMunchkina {
    private Bron bron;
    private Klasa klasa;
    private int poziom;
    private Rasa rasa;

    public Munchkin() {
        this.bron = null;
        this.klasa = null;
        this.poziom = 1;
        this.rasa = null;
    }

    public Munchkin(int poziom) {
        this.poziom = poziom;
        if (this.poziom < 0) this.poziom = 0;
        this.bron = null;
        this.klasa = null;
        this.rasa = null;
    }

    public Bron pobierzBron() {
        return this.bron;
    }

    public Rasa pobierzRasa() {
        return this.rasa;
    }

    public Klasa pobierzKlasa() {
        return this.klasa;
    }

    public void zmniejszSamPoziom(int delta) {
        this.poziom -= delta;
        if (this.poziom < 0) this.poziom = 0;
    }

    public void zwiekszSamPoziom(int delta) {
        this.poziom += delta;
        if (this.poziom < 0) this.poziom = 0;
    }

    public void przyjmijKlase(Klasa klasa) throws NiedozwolonaKlasa, NiedozwoloneUzbrojenie {
        if (this.rasa == null) {
            this.klasa = klasa;
            if (this.bron != null && !this.bron.czyMoznaUzbroicMunchkina(this)) {
                this.bron = null;
                throw new NiedozwoloneUzbrojenie("Niedozwolone Uzbrojenie");
            }
        } else {
            if (!this.rasa.czyKlasaAkceptowalna(klasa))
                throw new NiedozwolonaKlasa("Niedozozwolona rasa");
            else {
                this.klasa = klasa;
                if (this.bron != null && !this.bron.czyMoznaUzbroicMunchkina(this)) {
                    this.bron = null;
                    throw new NiedozwoloneUzbrojenie("Niedozwolone Uzbrojenie");
                }
            }
        }
    }

    @Override
    public void przyjmijRase(Rasa rasa) throws NiedozwoloneUzbrojenie, NiedozwolonaRasa {
        if (this.klasa == null) {
            this.rasa = rasa;
            if (this.bron != null && !this.bron.czyMoznaUzbroicMunchkina(this)) {
                this.bron = null;
                throw new NiedozwoloneUzbrojenie("Niedozwolone Uzbrojenie");
            }
        } else {
            if (!this.klasa.czyRasaAkceptowalna(rasa))
                throw new NiedozwolonaRasa("Niedozozwolona rasa");
            else {
                this.rasa = rasa;
                if (this.bron != null && !this.bron.czyMoznaUzbroicMunchkina(this)) {
                    this.bron = null;
                    throw new NiedozwoloneUzbrojenie("Niedozwolone Uzbrojenie");
                }
            }
        }
    }

    @Override
    public void przyjmijBron(Bron bron) throws NiedozwoloneUzbrojenie {
        if (bron == null)
            this.bron = null;
        else {
            if (bron.czyMoznaUzbroicMunchkina(this))
                this.bron = bron;
            else
                throw new NiedozwoloneUzbrojenie("Niedozwolone Uzbrojenie");
        }
    }

    @Override
    public int policzCalkowityPoziom() {
        int suma = this.poziom;
        if (this.rasa != null)
            suma += this.rasa.pobierzPremie();
        if (this.klasa != null)
            suma += this.klasa.pobierzPremie();
        if (this.bron != null)
            suma += this.bron.policzPremie(this);
        if (this.bron != null) {
            if (this.rasa == Rasa.Ork && this.bron instanceof Stalowy)
                suma += 20;
            if (this.klasa == Klasa.Palladyn && this.bron instanceof Srebrny)
                suma += 25;
        }
        return suma;
    }

    @Override
    public int pobierzSamPoziom() {
        return this.poziom;
    }
}
