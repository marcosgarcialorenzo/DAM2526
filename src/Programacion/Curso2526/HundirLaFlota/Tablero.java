package Programacion.Curso2526.HundirLaFlota;

import Programacion.Curso2526.A.A11.Teclado;

import java.io.IOException;
import java.sql.SQLOutput;

public class Tablero {
    int[][][] tablero = new int[2][10][10]; // jugador, fila, columna

    void mostrarTablero(int jugador) {
        System.out.println("Tablero del jugador " + (jugador + 1) + ":");
        for (int fila = 0; fila < tablero[jugador].length; fila++) {
            for (int columna = 0; columna < tablero[jugador][fila].length; columna++) {
                System.out.print(tablero[jugador][fila][columna] + " ");
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

    public static void main(String[] args) {

    }
}