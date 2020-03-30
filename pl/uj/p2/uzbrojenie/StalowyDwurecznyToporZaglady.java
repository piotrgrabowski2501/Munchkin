//Piotr Grabowski
package pl.uj.p2.uzbrojenie;

import pl.uj.p2.InterfejsMunchkina;

import static pl.uj.p2.Klasa.Osilek;
import static pl.uj.p2.Rasa.Ork;

public class StalowyDwurecznyToporZaglady extends Topor implements Stalowy{
    public StalowyDwurecznyToporZaglady(){}

    public boolean czyMoznaUzbroicMunchkina(InterfejsMunchkina munchkin){
        if(munchkin.pobierzRasa() == Ork || munchkin.pobierzKlasa() == Osilek)
            return true;
        return false;
    }

    public int policzPremie(InterfejsMunchkina munchkin){
        if(munchkin.pobierzKlasa() == Osilek)
            return 10 * munchkin.pobierzSamPoziom();
        return 5 * munchkin.pobierzSamPoziom(); //jesli to ork, bo tylko dla osilka jest 10 za topor
    }
}
