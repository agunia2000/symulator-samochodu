public class Silnik extends Komponent {

    private final int max_obroty;
    private int obroty;
    private boolean stanSilnika;

    public Silnik(String nazwa, int waga, int cena, int max_obroty) {
        super(nazwa, waga, cena);
        this.max_obroty=max_obroty;
        this.stanSilnika=false;
    }

    public void uruchom(){
        if (stanSilnika == true) {
            System.out.println("Silnik jest juz wlaczony");
        }
        else if(stanSilnika == false) {
            System.out.println("Silnik zostal wlasnie wlaczony");
            stanSilnika=true;
            obroty=1000;
        }
    }

    public void zatrzymaj(){
        if (stanSilnika == false) {
            System.out.println("Silnik jest juz wylaczony");
        }
        else if(stanSilnika == true) {
            System.out.println("Silnik zostal wlasnie wylaczony");
            stanSilnika=false;
            obroty=0;
        }
    }

    public void ZwiekszObroty(){
        if(stanSilnika == true){
            if (obroty < max_obroty) {
                obroty=obroty+100;
            }
            else if(obroty >= max_obroty) {
                obroty=max_obroty;
            }
        }
    }

    public void ZmniejszObroty(){
        if(stanSilnika == true) {
            if (obroty > 800) {
                obroty = obroty - 100;
            } else if (obroty <= 800) {
                obroty = 800;
            }
        }
    }

    public int getObroty() {
        return obroty;
    }
}
