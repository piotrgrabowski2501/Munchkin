//Piotr Grabowski
package pl.uj.p2;

public enum Rasa {
    Czlowiek(new String[]{}, 4),
    Elf(new String[]{"Palladyn"}, 3),
    Gnom(new String[]{"Osilek"}, 5),
    Krasnolud(new String[]{"Szpieg"}, 2),
    Ork(new String[]{"Szpieg", "Mag"}, 1);

    private String[] nieakceptowalneKlasy;
    private int	premiaDoPoziomu;

    private Rasa(String[] nieakceptowalneKlasy, int premiaDoPoziomu){
        this.nieakceptowalneKlasy = nieakceptowalneKlasy;
        this.premiaDoPoziomu = premiaDoPoziomu;
    }

    public String toString(){
        switch(this){
            case Czlowiek :
                return "Czlowiek";
            case Elf :
                return "Elf";
            case Gnom :
                return "Gnom";
            case Krasnolud :
                return "Krasnolud";
            case Ork :
                return "Ork";
        }
        return null;
    }

    public int pobierzPremie(){
        return this.premiaDoPoziomu;
    }

    public boolean czyKlasaAkceptowalna(Klasa klasa){
        if(klasa == null)
            return true;
        else {
            for(int i = 0; i < nieakceptowalneKlasy.length; i++)
                if(klasa.toString().equals(this.nieakceptowalneKlasy[i]))
                    return false;
            return true;
        }
    }
}
