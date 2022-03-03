public class Pozycja {

    private double x;
    private double y;

    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void przemiesc(double V, double time, Pozycja cel) {

        V=V/10; //zmniejszenie predkosci aby na mapie samochod poruszał się wolniej - lepszy efekt wizualny

        if (this.y != cel.y || this.x != cel.x) {
            double dx = (V * time * ((cel.x - x) / (Math.sqrt(Math.pow((cel.x - x), 2) + (Math.pow((cel.y - y), 2))))));
            double dy = (V * time * ((cel.y - y) / (Math.sqrt(Math.pow((cel.x - x), 2) + (Math.pow((cel.y - y), 2))))));

            this.x = this.x + dx;
            this.y = this.y + dy;

            if (dx > Math.abs(this.x - cel.x) || dy > Math.abs(this.y - cel.y)) {
                if (dy > Math.abs(this.y - cel.y)) {
                    this.y = cel.y;
                }
                if (dx > Math.abs(this.x - cel.x)) {
                    this.x = cel.x;
                }
                if (this.y == cel.y && this.x == cel.x) {
                    System.out.println("Dojechałeś do celu!");
                }
            }
        } else System.out.println("Jesteś u celu!");
    }
}
