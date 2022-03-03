import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SamochodGUI extends Thread{
    private JComboBox comboBox1;
    private JButton dodajNowyButton;
    private JButton usuńButton;
    private JPanel Mapa;
    private JPanel PanelMain;
    private JButton włączButton;
    private JButton wyłączButton;
    private JTextField ModelTX;
    private JTextField nrREJTX;
    private JTextField WagaCarTX;
    private JTextField PrędkośćTX;
    private JTextField NazwaSilnikTX;
    private JTextField CenaSilnikTX;
    private JButton zwiekszBiegButton;
    private JTextField WagaSilnikTX;
    private JTextField ObrotyTX;
    private JButton DodajGazuButton;
    private JButton UjmijGazuButton;
    private JTextField NazwaBiegiTX;
    private JTextField CenaBiegiTX;
    private JTextField WagaBiegiTX;
    private JTextField AktBiegTX;
    private JTextField NazwaSprzegloTX;
    private JButton WcisnijSprzegloButton;
    private JTextField CenaSprzegloTX;
    private JTextField WagaSprzegloTX;
    private JTextField StanSprzegloTX;
    private JButton ZwolnijSprzegloTX;
    private JButton zmniejszBiegButton;
    private JLabel autoIcon;
    private JPanel Parametry;
    private JPanel WlaczPanel;
    private JPanel GazPanel;
    private JPanel BiegiPanel;
    private JPanel SprzegloPanel;

    private Samochod samochod;

    public SamochodGUI() {

        Sprzeglo sprzeglo = new Sprzeglo("Sprzęgło nowoczesne",15, 500);
        SkrzyniaBiegow biegi5 =new SkrzyniaBiegow("5-biegowa", 85, 800, 5, sprzeglo);
        Silnik diesel = new Silnik("Diesel", 400, 2200, 4000);
        Pozycja pozycja_start = new Pozycja(10, 20);
        Samochod samochod1 = new Samochod(biegi5, diesel, pozycja_start, "TBU 82MK", "Citroen C4", 220);
        comboBox1.addItem(samochod1);
        this.samochod=samochod1;

        włączButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.wlacz();
                refresh();
            }
        });
        wyłączButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.wylacz();
                refresh();
            }
        });
        DodajGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.getSilnik().ZwiekszObroty();
                refresh();
            }
        });
        UjmijGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.getSilnik().ZmniejszObroty();
                refresh();
            }
        });
        zwiekszBiegButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    samochod.getSkrzynia().ZwiekszBieg();
                    refresh();
                }
            });
        zmniejszBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.getSkrzynia().ZmniejszBieg();
                refresh();
            }
        });
        WcisnijSprzegloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.getSkrzynia().getSprzeglo().Wcisnij();
                refresh();
            }
        });
        ZwolnijSprzegloTX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.getSkrzynia().getSprzeglo().Zwolnij();
                refresh();
            }
        });
        Mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                samochod.jedzDo(new Pozycja(e.getX(), e.getY()));
                refresh();
            }
        });
        dodajNowyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new NowySamochodGUI(comboBox1);
                f.pack();
                f.setVisible(true);
            }
        });
        usuńButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.interrupt();
                comboBox1.removeItem(samochod);
                refresh();
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod = (Samochod) comboBox1.getSelectedItem();
            }
        });

        this.start();

    }
    private void refresh(){

        if(samochod==null){
            ModelTX.setText("");
            nrREJTX.setText("");
            WagaCarTX.setText("");
            PrędkośćTX.setText("");

            NazwaSilnikTX.setText("");
            CenaSilnikTX.setText("");
            WagaSilnikTX.setText("");
            ObrotyTX.setText("");

            NazwaBiegiTX.setText("");
            CenaBiegiTX.setText("");
            WagaBiegiTX.setText("");
            AktBiegTX.setText("");

            NazwaSprzegloTX.setText("");
            CenaSprzegloTX.setText("");
            WagaSprzegloTX.setText("");
            StanSprzegloTX.setText("");

            autoIcon.setVisible(false);

        }
        else {
            ModelTX.setText(samochod.getModel());
            nrREJTX.setText(samochod.getNrRejestracyjny());
            WagaCarTX.setText(String.valueOf(samochod.getWaga()) + " kg");
            PrędkośćTX.setText(String.valueOf(Math.round(samochod.getAktPredkosc())) + " km/h");

            NazwaSilnikTX.setText(samochod.getSilnik().getNazwa());
            CenaSilnikTX.setText(String.valueOf(samochod.getSilnik().getCena()) + " PLN");
            WagaSilnikTX.setText(String.valueOf(samochod.getSilnik().getWaga()) + " kg");
            ObrotyTX.setText(String.valueOf(samochod.getSilnik().getObroty()) + " obr/min");

            NazwaBiegiTX.setText(samochod.getSkrzynia().getNazwa());
            CenaBiegiTX.setText(String.valueOf(samochod.getSkrzynia().getCena()) + " PLN");
            WagaBiegiTX.setText(String.valueOf(samochod.getSkrzynia().getWaga()) + " kg");
            AktBiegTX.setText(String.valueOf(samochod.getSkrzynia().getAktualnyBieg()));

            NazwaSprzegloTX.setText(samochod.getSkrzynia().getSprzeglo().getNazwa());
            CenaSprzegloTX.setText(String.valueOf(samochod.getSkrzynia().getSprzeglo().getCena()) + " PLN");
            WagaSprzegloTX.setText(String.valueOf(samochod.getSkrzynia().getSprzeglo().getWaga()) + " kg");
            StanSprzegloTX.setText(samochod.getSkrzynia().getSprzeglo().getStan());

            autoIcon.setVisible(true);
            autoIcon.setLocation((int) samochod.getAktualna_pozycja().getX(), (int) samochod.getAktualna_pozycja().getY()); }
    }

    @Override
    public void run() {
        while(true){
            refresh();
            try {
                Thread.sleep(200);
            }
            catch(InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SamochodGUI");
        frame.setContentPane(new SamochodGUI().PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
