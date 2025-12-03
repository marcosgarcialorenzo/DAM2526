package Programacion.Curso2526.HundirLaFlota;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Tablero tablero = new Tablero();
        Teclado teclado = new Teclado();
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

        int opcion;
        System.out.println("Menú de juego:");
        System.out.println("1. Rellenar tablero de manera aleatoria");
        System.out.println("2. Rellenar tablero de manera manual");
        System.out.println("Elige una opción (1 o 2):");
        opcion = teclado.leerInt();


        do {
            switch (opcion) {
                case 1 -> {
                    System.out.println("Rellenando tableros de ambos jugadores de manera aleatoria...");
                    tablero.rellenarAleatorio();
                }
                case 2 -> {
                    System.out.println("Rellenar tablero del Jugador 1:");
                    tablero.rellenar(0);
                    System.out.println("Rellenar tablero del Jugador 2:");
                    tablero.rellenar(1);
                }
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (tablero.hayBarcos(jugador1) && tablero.hayBarcos(jugador2));
    }
}