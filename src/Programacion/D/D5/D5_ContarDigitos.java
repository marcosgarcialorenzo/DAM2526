package Programacion.D.D5;

import java.io.IOException;

public class D5_ContarDigitos {
    public static void main(String[] args) throws IOException {
        Teclado t = new Teclado();
        int[] numeros;
        boolean fin = false;
        while (!fin) {
            System.out.println("introduce numeros del 0 al 9");
            numeros = new int[11]; // 10 numeros del 0 al 9 y uno para introducir el -1 y terminar

            for (int i = 0; i < numeros.length; i++) {
                int numeroleido;
                System.out.println("Numero " + (i + 1) + ": ");
                numeroleido = t.leerInt();
                if (numeroleido >= 0 && numeroleido <= 9) {
                    numeros[i] = numeroleido;
                } else if (numeroleido < 0) {
                    for (int j = 0; i < numeros.length; i++) {
                        int cuenta = 0;
                        for (int n = 0; n < numeros.length; n++) {
                            if (numeros[n] == numeros[j]) {
                                cuenta++;
                            }
                        }
                        System.out.println("El  " + numeros[j] + " se ha introducido  " + cuenta + " veces");
                    }
                    fin = true;
                } else {
                    System.out.println("Numero no valido");
                }
            }
        }
    }
}