//Piotr Grabowski
package pl.uj.p2.uzbrojenie;

import pl.uj.p2.InterfejsMunchkina;

public class StalowyMieczJednoreczny extends MieczJednoreczny implements Stalowy {
    public StalowyMieczJednoreczny() {
    }

    public int policzPremie(InterfejsMunchkina munchkin) {
        if (munchkin.pobierzKlasa() == null)
            return super.policzPremie(munchkin);
        return munchkin.pobierzKlasa().pobierzPremie() * super.policzPremie(munchkin);
    }
}
