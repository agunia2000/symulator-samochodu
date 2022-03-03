import java.util.HashMap;

public class Samochod extends Thread{

    private boolean stanWlaczenia;
    private String nrRejestracyjny;
    private String model;
    private double predkosc_max;
    private SkrzyniaBiegow skrzynia;
    private Silnik silnik;
    private Pozycja aktualna_pozycja;
    private Pozycja docelowa_pozycja;

    private HashMap<Integer, Integer> mapa= new HashMap();


    public Samochod(SkrzyniaBiegow skrzynia, Silnik silnik, Pozycja aktualna_pozycja, String nrRejestracyjny, String model, double predkosc_max) {
        this.skrzynia=skrzynia;
        this.silnik=silnik;
        this.aktualna_pozycja=aktualna_pozycja;
        this.docelowa_pozycja=aktualna_pozycja;
        this.nrRejestracyjny = nrRejestracyjny;
        this.model = model;
        this.predkosc_max = predkosc_max;
        this.start();
    }

    public String getNrRejestracyjny(){
        return nrRejestracyjny;
    }

    public String getModel(){
        return model;
    }

    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }

    public Silnik getSilnik() {
        return silnik;
    }

    public void wlacz() {
        if (stanWlaczenia==true) {
            System.out.println("Samochod " + model + " o numerze rej: " + nrRejestracyjny + " jest juz wlaczony");
        }
        else if(stanWlaczenia==false) {
            System.out.println("Samochod " + model + " o numerze rej: " + nrRejestracyjny + " zostal wlasnie wlaczony");
            stanWlaczenia=true;
            silnik.uruchom();
        }
    }

    public void wylacz() {
        if (stanWlaczenia==false) {
            System.out.println("Samochod " + model + " o numerze rej: " + nrRejestracyjny + " jest juz wylaczony");
        }
        else if(stanWlaczenia==true) {
            System.out.println("Samochod " + model + " o numerze rej: " + nrRejestracyjny + " zostal wlasnie wylaczony");
            stanWlaczenia=false;
            silnik.zatrzymaj();
        }
    }

    public int getWaga(){
        return silnik.getWaga()+skrzynia.getWaga()+1000;
    }

    public double getAktPredkosc(){ // zmieniony, dziwny wzor na predkosc aby miala realne wartosci
        double V=((silnik.getObroty()*0.6)*skrzynia.getAkutalnePrzelozenie()*2*3.14*0.381/150);
        if(V>predkosc_max){
            return predkosc_max;
        }
        return V;
    }

    public Pozycja getAktualna_pozycja() {
        return aktualna_pozycja;
    }

    public void jedzDo(Pozycja cel){
        this.docelowa_pozycja=cel;
        System.out.println(this.model + " " +this.nrRejestracyjny + " jedzie z punktu: "+ this.aktualna_pozycja.getX() + ", " + this.aktualna_pozycja.getY() +" do punktu " +this.docelowa_pozycja.getX() + ", " + this.docelowa_pozycja.getY());
    }

    public void run() {
        while(true){
            aktualna_pozycja.przemiesc(this.getAktPredkosc(), 0.2, docelowa_pozycja);
            System.out.println(this.model+" "+ this.nrRejestracyjny + ": "+ aktualna_pozycja.getX() + ", " + aktualna_pozycja.getY());
            try {
                Thread.sleep(200);
            }
            catch(InterruptedException e) {
                //e.printStackTrace();
                return;
            }
        }
    }

    @Override
    public String toString() {
        return model + " " + nrRejestracyjny;
    }


    public static void main(String[] args){
        Sprzeglo sprzeglo1 = new Sprzeglo("sprzeglo1",15, 500);
        Sprzeglo sprzeglo2 = new Sprzeglo("sprzeglo2", 20, 420);
        SkrzyniaBiegow biegi1 =new SkrzyniaBiegow("5-biegowa", 85, 800, 5, sprzeglo1);
        SkrzyniaBiegow biegi2 = new SkrzyniaBiegow("6 biegowa", 95, 1200, 6, sprzeglo2);
        Silnik silnik1 = new Silnik("Diesel", 400, 800, 5000);
        Silnik silnik2 = new Silnik("Gas", 500, 3500, 4200);
        Pozycja pozycja1 = new Pozycja(0, 0);
        Pozycja pozycja2 = new Pozycja(50, 50);
        Pozycja pozycja3 = new Pozycja(150, 400);
        Pozycja pozycja4 = new Pozycja(145, 70);
        Pozycja pozycja5 = new Pozycja(15, 40);
        Pozycja pozycja6 = new Pozycja(90, 35);
        Samochod auto1 = new Samochod(biegi1, silnik1, pozycja1, "TBU082K", "Toyota", 140);
        Samochod auto2 = new Samochod(biegi2, silnik2, pozycja2, "KR 19OK7", "Peugot", 200);

    }
}
