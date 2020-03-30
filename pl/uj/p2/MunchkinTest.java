package pl.uj.p2;

import pl.uj.p2.uzbrojenie.Miecz;
import pl.uj.p2.uzbrojenie.StalowyDwurecznyToporZaglady;
import pl.uj.p2.uzbrojenie.WypasionySrebrnyLuk;
import pl.uj.p2.wyjatki.WyjatekMunchkina;

public class MunchkinTest {

    public static void main(String [] args) {
        Munchkin m = new Munchkin();
        System.out.println(m.pobierzSamPoziom());
        System.out.println(m.pobierzKlasa());
        System.out.println(m.pobierzRasa());
        System.out.println(m.pobierzBron());
        System.out.println(m.policzCalkowityPoziom());

        try {
            m.przyjmijRase(Rasa.Gnom);
            System.out.println(m.pobierzRasa());
            System.out.println("Aktualny poziom: " + m.policzCalkowityPoziom());
        } catch (WyjatekMunchkina e) {
            System.out.println("Nie można przyjąć rasy Gnoma");
        }

        try {
            m.przyjmijKlase(Klasa.Osilek);
            System.out.println(m.pobierzRasa());
            System.out.println("Aktualny poziom: " + m.policzCalkowityPoziom());
        } catch (WyjatekMunchkina e) {
            System.out.println("Nie można przyjąć klasy Osiłek");
        }

        try {
            m.przyjmijBron(new Miecz());
            System.out.println(m.pobierzBron() != null);
            System.out.println("Aktualny poziom: " + m.policzCalkowityPoziom());
        } catch (WyjatekMunchkina e) {
            System.out.println("Nie można uzbroić Munchkina w miecz");
        }

        try {
            m.przyjmijBron(new StalowyDwurecznyToporZaglady());
            System.out.println(m.pobierzBron() != null);
            System.out.println("Aktualny poziom: " + m.policzCalkowityPoziom());
        } catch (WyjatekMunchkina e) {
            System.out.println("Nie można uzbroić Munchkina w Stalowy Dwureczny Topor Zaglady");
        }

        try {
            m.przyjmijBron(new WypasionySrebrnyLuk());
            System.out.println(m.pobierzBron() != null);
            System.out.println("Aktualny poziom: " + m.policzCalkowityPoziom());
        } catch (WyjatekMunchkina e) {
            System.out.println("Nie można uzbroić Munchkina w Wypasiony Srebrny Luk");
        }
    }

}