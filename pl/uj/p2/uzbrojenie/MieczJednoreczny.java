//Piotr Grabowski
package pl.uj.p2.uzbrojenie;

import pl.uj.p2.InterfejsMunchkina;
import pl.uj.p2.Rasa;

public class MieczJednoreczny extends Miecz{
    public MieczJednoreczny(){}

    public int policzPremie(InterfejsMunchkina munchkin){
        if(munchkin.pobierzRasa() == null) return 2;
        Rasa tmp = munchkin.pobierzRasa();
        return tmp.pobierzPremie() * 2;
    }

}
