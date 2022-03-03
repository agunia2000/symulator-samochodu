public class SkrzyniaBiegow extends Komponent {

    private final int iloscBiegow;
    private int aktualnyBieg;
    private double akutalnePrzelozenie;
    private Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String nazwa, int waga, int cena, int iloscBiegow, Sprzeglo sprzeglo){
        super(nazwa, waga+ sprzeglo.getWaga(), cena);
        this.iloscBiegow=iloscBiegow;
        this.sprzeglo=sprzeglo;
        this.aktualnyBieg=0;
    }

    public void ZwiekszBieg(){
        if(sprzeglo.getStanSprzegla()==true) {
            if (aktualnyBieg < iloscBiegow) {
                aktualnyBieg = aktualnyBieg + 1;
            }
            if (aktualnyBieg >= iloscBiegow) {
                aktualnyBieg = iloscBiegow;
                System.out.println("Osiagnieto maksymalny bieg");
            }
        }
        else if(sprzeglo.getStanSprzegla()==false){
            System.out.println("Wciśnij sprzeglo!");
        }
    }

    public void ZmniejszBieg(){
        if(sprzeglo.getStanSprzegla()==true) {
            if (aktualnyBieg > 0) {
                aktualnyBieg = aktualnyBieg - 1;
            }
            if (aktualnyBieg<=0) {
                aktualnyBieg = 0;
                System.out.println("Osiagnieto minimlany bieg (luz)");
            }
        }
        else if(sprzeglo.getStanSprzegla()==false){
            System.out.println("Wciśnij sprzeglo!");
        }
    }

    public int getAktualnyBieg(){
        return aktualnyBieg;
    }

    public double getAkutalnePrzelozenie() {
        akutalnePrzelozenie=aktualnyBieg+aktualnyBieg*0.2;
        return akutalnePrzelozenie;
    }

    public Sprzeglo getSprzeglo() {
        return sprzeglo;
    }
}
