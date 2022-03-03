import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NowySamochodGUI extends JFrame{
    private JTextField NowyPredMaxTX;
    private JTextField NowyNrRejTX;
    private JTextField NowyNazwaTX;
    private JRadioButton s5BiegowaRadioButton;
    private JRadioButton s6BiegowaRadioButton;
    private JRadioButton dieselRadioButton;
    private JRadioButton benzynaRadioButton;
    private JPanel panel;
    private JButton dodajButton;
    private JButton anulujButton;

    private String nazwa;
    private String nrRej;
    private int pred_max;
    private SkrzyniaBiegow biegi;
    private Silnik silnik;

    public NowySamochodGUI(JComboBox lista){
        setContentPane(panel);

        Pozycja pozycja_start = new Pozycja(10, 20);
        Sprzeglo sprzeglo = new Sprzeglo("Sprzęgło nowoczesne",15, 500);
        SkrzyniaBiegow biegi5 =new SkrzyniaBiegow("5-biegowa", 85, 800, 5, sprzeglo);
        SkrzyniaBiegow biegi6 =new SkrzyniaBiegow("6-biegowa", 120, 1500, 6, sprzeglo);
        Silnik benzyna = new Silnik("Benzyna", 450, 4000, 8000);
        Silnik diesel = new Silnik("Diesel", 400, 2200, 6000);

        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(benzynaRadioButton.isSelected()){ silnik=benzyna; }
                else if(dieselRadioButton.isSelected()){ silnik=diesel; }
                if(s5BiegowaRadioButton.isSelected()){ biegi=biegi5; }
                else if(s6BiegowaRadioButton.isSelected()){ biegi=biegi6; }
                nazwa = NowyNazwaTX.getText();
                nrRej = NowyNrRejTX.getText();
                pred_max=Integer.parseInt(NowyPredMaxTX.getText());
                Samochod samochod = new Samochod(biegi, silnik, pozycja_start, nrRej,  nazwa, pred_max);
                lista.addItem(samochod);
                dispose();
            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
