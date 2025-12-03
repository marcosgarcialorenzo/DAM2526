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
        boolean finJuego = false;
        if (this.barcos <= 0) {
            finJuego = true;
        }
        return finJuego;
    }
}