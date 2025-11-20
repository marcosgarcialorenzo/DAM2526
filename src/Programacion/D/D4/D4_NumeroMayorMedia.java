package Programacion.D.D4;

import java.io.IOException;

public class D4_NumeroMayorMedia {
    public static void main(String[] args) throws IOException {
        Teclado t = new Teclado();
        int[] numeros = new int[10];
        System.out.println("Introduce 10 numeros enteros:");
        int total = 0;
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            numeros[i] = t.leerInt();
            total += numeros[i];
        }

        double media = total / numeros.length; // se puede sustituir por 10

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > media) {
                System.out.println(numeros[i]);
            }
        }
    }
}