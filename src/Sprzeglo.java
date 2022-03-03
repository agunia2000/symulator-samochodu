public class Sprzeglo extends Komponent {

    private boolean stanSprzegla;

    public Sprzeglo(String nazwa, int waga, int cena){
        super(nazwa, waga, cena);
        this.stanSprzegla=false;
    }

    public boolean getStanSprzegla() {
        return stanSprzegla;
    }

    public void Wcisnij(){
        stanSprzegla=true;
    }

    public void Zwolnij(){
        stanSprzegla=false;
    }

    public String getStan(){
        if(stanSprzegla){
            return "Wciśnięte";
        }
        return "Puszczone";
    }
}
