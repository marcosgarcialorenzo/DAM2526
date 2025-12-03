package Programacion.Curso2526.HundirLaFlota;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Tablero tablero = new Tablero();
        /*tablero.rellenar(0); //jugador 0 = primer jugador jugador 1 = segundo jugador
        tablero.rellenar(1);*/
        tablero.rellenarAleatorio(); // rellena aleatoriamente los dos tableros

        tablero.mostrarTablero(0);
        tablero.mostrarTablero(1);
        tablero.mostrarTableroOculto(1); // el jugador 0 dispara al jugador 1
        tablero.disparar(1);
        tablero.mostrarTableroOculto(1);
        tablero.mostrarTableroOculto(1); // el jugador 0 dispara al jugador 1
        tablero.disparar(1);
        tablero.mostrarTableroOculto(1);

        boolean finJuego = false;
        while (!finJuego) { // aqui preguntar si algun jugador ha perdido todos sus barcos, despues de cada disparo se pregunta si se ha hundido un barco
            tablero.mostrarTableroOculto(1); // el jugador 0 dispara al jugador 1
            tablero.disparar(1);
        }
    }
}