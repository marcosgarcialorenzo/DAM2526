package Programacion.Curso2526.E.E7;

public class Vehiculo {
    static String matricula;
    long tiempoDePaso; // en segundos desde 1970

    public static String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public long getTiempoDePaso() {
        return tiempoDePaso;
    }

    public void setTiempoDePaso(long tiempoDePaso) {
        this.tiempoDePaso = tiempoDePaso;
    }
}