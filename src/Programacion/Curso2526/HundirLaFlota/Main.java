package Programacion.Curso2526.HundirLaFlota;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Jugador 1", 0);
        Jugador jugador2 = new Jugador("Jugador 2", 1);
        /*tablero.rellenar(0); //jugador 0 = primer jugador jugador 1 = segundo jugador
        tablero.rellenar(1);*/
        tablero.rellenarAleatorio(); // rellena aleatoriamente los dos tableros

        tablero.mostrarTablero(jugador1);
        tablero.mostrarTablero(jugador2);
        tablero.mostrarTableroOculto(jugador2); // el jugador 1 dispara al jugador 2
        tablero.disparar(jugador2); //se pone el jugador al que se le dispara
        tablero.mostrarTableroOculto(jugador2);
        tablero.disparar(jugador2);

       /* boolean finJuego = false;
        while (!finJuego) { // aqui preguntar si algun jugador ha perdido todos sus barcos, despues de cada disparo se pregunta si se ha hundido un barco
            tablero.mostrarTableroOculto(1); // el jugador 0 dispara al jugador 1
            tablero.disparar(jugador1);
        }*/
    }
}