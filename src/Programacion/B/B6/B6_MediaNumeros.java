package Programacion.B.B6;

import java.io.IOException;

public class B6_MediaNumeros {

    public static void main(String[] args) throws IOException {
        System.out.println("Introduce números enteros (un número negativo para terminar):");
        int suma = 0;
        int contador = 0;
        Teclado teclado = new Teclado();

        while (true) {
            int n = teclado.leerInt();
            if (n < 0) {
                break;
            }
            suma += n;
            contador++;
        }

        if (contador == 0) {
            System.out.println("No se han introducido números válidos.");
        } else {
            double media = (double) suma / contador;
            System.out.printf("Media=%.2f%n", media);
        }
    }
}