//Piotr Grabowski
package pl.uj.p2.uzbrojenie;

import pl.uj.p2.InterfejsMunchkina;

import static pl.uj.p2.Klasa.Len;
import static pl.uj.p2.Klasa.Osilek;

public class WypasionySrebrnyLuk extends Luk implements Srebrny {
    public WypasionySrebrnyLuk() {
    }

    public boolean czyMoznaUzbroicMunchkina(InterfejsMunchkina munchkin) {
        if(!super.czyMoznaUzbroicMunchkina(munchkin))//warunek z Luku
            return false;
        if(munchkin.pobierzKlasa() == null) return true;
        else if(munchkin.pobierzKlasa().toString().equals(Len.toString()) || munchkin.pobierzKlasa().toString().equals(Osilek.toString()))
            return false;
        return true;
    }

    public int policzPremie(InterfejsMunchkina munchkin) {
        if(munchkin.pobierzRasa() == null)
            return super.policzPremie(munchkin);
        return super.policzPremie(munchkin) * munchkin.pobierzRasa().pobierzPremie();
    }
}
