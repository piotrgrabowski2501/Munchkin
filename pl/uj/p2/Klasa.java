//Piotr Grabowski
package pl.uj.p2;

public enum Klasa {
    Len(new String[]{}, -1),
    Mag(new String[]{"Ork","Gnom"},4),
    Osilek(new String[]{"Gnom"}, 5),
    Palladyn(new String[]{"Elf"}, 2),
    Szpieg(new String[]{"Ork", "Krasnolud"}, 2);

    private String[] nieakceptowalneRasy;
    private int	premiaDoPoziomu;

    private Klasa(String[] nieakceptowalneRasy, int premiaDoPoziomu){
        this.nieakceptowalneRasy = nieakceptowalneRasy;
        this.premiaDoPoziomu = premiaDoPoziomu;
    }

    public String toString(){
        switch(this){
            case Len :
                return "Len";
            case Mag :
                return "Mag";
            case Osilek :
                return "Osilek";
            case Palladyn :
                return "Palladyn";
            case Szpieg :
                return "Szpieg";
        }
        return null;
    }

    public int pobierzPremie(){
        return this.premiaDoPoziomu;
    }

    public boolean czyRasaAkceptowalna(Rasa rasa){
        if(rasa == null)
            return true;
        else {
            for(int i = 0; i < nieakceptowalneRasy.length; i++)
                if(rasa.toString().equals(this.nieakceptowalneRasy[i]))
                    return false;
            return true;
        }
    }

}
