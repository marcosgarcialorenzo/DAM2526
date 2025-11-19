package Programacion.D.D2;

import java.io.IOException;

public class D2_LeerNumeros {
    public static void main(String[] args) throws IOException {
        Teclado teclado = new Teclado();
        int[] numeros = new int[10];

        System.out.println("Introduce 10 números enteros:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = teclado.leerInt();
        }

        System.out.println("\nMenú: introduce un número y se indicará cuántas veces aparece en el array.");
        System.out.println("Pulsa 0 para salir.");

        boolean fin = false;

        while (!fin) {
            System.out.println("Número a buscar (0 para salir): ");
            int buscado = teclado.leerInt();
            if (buscado == 0) {
                System.out.println("Saliendo...");
                fin = true;
            }

            int contador = 0;
            for (int i = 0; i < numeros.length; i++) {
                if (numeros[i] == buscado) {
                    contador++;
                }
            }
            System.out.println("El número " + buscado + " aparece " + contador + " ve" + (contador == 1 ? "z" : "ces") + " en el array.");
        }
    }
}