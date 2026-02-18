package Programacion.Curso2526.E.HundirLaFlota;

public class Jugador {
    String nombre;
    int barcos;
    int id;

    Jugador(String nombre, int id) {
        this.id = id;
        this.nombre = nombre;
        this.barcos = 1;
    }

    boolean hayBarcos() {
        if (this.barcos <= 0) {
            return true;
        }
        return false;
    }
}