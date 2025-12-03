package Programacion.Curso2526.HundirLaFlota;

import Programacion.Curso2526.A.A11.Teclado;
import java.io.IOException;

public class Tablero {
    int[][][] tablero = new int[2][10][10]; // jugador, fila, columna

    void mostrarTablero(Jugador j) {
        int jugador = j.id;
        System.out.println("Tablero del jugador " + (jugador + 1) + ":");
        for (int fila = 0; fila < tablero[jugador].length; fila++) {
            for (int columna = 0; columna < tablero[jugador][fila].length; columna++) {
                System.out.print(tablero[jugador][fila][columna] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void mostrarTableroOculto(Jugador j) {
        int jugador = j.id;
        System.out.println("Tablero de " + j.nombre );
        for (int fila = 0; fila < tablero[jugador].length; fila++) {
            for (int columna = 0; columna < tablero[jugador][fila].length; columna++) {
                int valor = tablero[jugador][fila][columna];
                if (valor == -1) {
                    System.out.print("🔴 " ); // tocado
                } else if (valor == -2) {
                    System.out.print("🔵 "); // agua disparada
                } else {
                    System.out.print("⬜ "); // oculto
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    void rellenar(int jugador) throws IOException {
        Teclado teclado = new Teclado();
        for (int fila = 0; fila < tablero[jugador].length; fila++) {
            for (int columna = 0; columna < tablero[jugador][fila].length; columna++) {
                System.out.print("Introduce 0 para agua y 1 para barco \nFila " + (fila + 1) + " columna " + (columna + 1) + ": ");
                tablero[jugador][fila][columna] = teclado.leerInt();
            }
        }
    }

    void rellenarAleatorio() {
        for (int jugador = 0; jugador < tablero.length; jugador++) {
            for (int fila = 0; fila < tablero[jugador].length; fila++) {
                for (int columna = 0; columna < tablero[jugador][fila].length; columna++) {
                    tablero[jugador][fila][columna] = (int) (Math.random() * 2); // 0 o 1
                }
            }
        }
    }

    void disparar(Jugador j, Jugador j2) throws IOException {
        int jugadorAtaque = j.id;
        int jugadorDefensa = j2.id;
        Teclado teclado = new Teclado();
        System.out.print("Introduce la fila para disparar (1-10): ");
        int fila = teclado.leerInt() - 1; // ajustar índice para estar entre 0 y 9
        System.out.print("Introduce la columna para disparar (1-10): ");
        int columna = teclado.leerInt() - 1;
        if (tablero[jugadorAtaque][fila][columna] == 1) {
            System.out.println("¡Tocado!");
            tablero[jugadorAtaque][fila][columna] = -1; // marcar como tocado
            System.out.println("Jugador rival ¿se ha hundido un barco? (No = 0 / Si = 1): ");
            int respuesta = teclado.leerInt();
            if (respuesta == 1) {
                System.out.println("¡Barco hundido!");
                j.barcos -= 1;
            } else {
                System.out.println("Sigue intentando.");
            }
        } else if (tablero[jugadorAtaque][fila][columna] == 0) {
            System.out.println("Agua.");
            tablero[jugadorAtaque][fila][columna] = -2; // marcar como agua disparada
        } else {
            System.out.println("Ya has disparado aquí.");
        }
    }
}