package Programacion.Curso2526.E.E7;

public class Vehiculo {
    String matricula;
    long tiempoDePaso; // en segundos desde 1970

    public String getMatricula() {
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

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }
}