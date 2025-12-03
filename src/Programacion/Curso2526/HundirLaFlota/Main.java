package Programacion.Curso2526.HundirLaFlota;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Tablero tablero = new Tablero();
        tablero.rellenar(0); //jugador 0 = primer jugador jugador 1 = segundo jugador
        tablero.rellenar(1);
        tablero.mostrarTablero(0);
        tablero.mostrarTablero(1);
    }
}
