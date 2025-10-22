package A.A9;

public class Arma {
    String nombre;
    double aumentoFuerza;

    public Arma(String nombre, double aumentoFuerza) {
        this.nombre = nombre;
        this.aumentoFuerza = aumentoFuerza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAumentoFuerza() {
        return aumentoFuerza;
    }

    public void setAumentoFuerza(double aumentoFuerza) {
        this.aumentoFuerza = aumentoFuerza;
    }
}