package Programacion.Curso2526.D;

import java.util.Scanner;

public class D6_NumerosNoIntroducidos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] vistos = new boolean[101]; // índices 0..100

        System.out.println("Introduce enteros entre 0 y 100. Introduce un negativo para terminar.");

        while (true) {
            System.out.print("Número: ");
            if (!sc.hasNextInt()) {
                System.out.println("Entrada no válida, intenta de nuevo.");
                sc.next(); // descartar token no entero
                continue;
            }
            int n = sc.nextInt();
            if (n < 0) break;
            if (n <= 100) {
                vistos[n] = true;
            } else {
                System.out.println("Número fuera de rango (0-100), ignorado.");
            }
        }

        System.out.println("Números no introducidos:");
        boolean alguno = false;
        for (int i = 0; i <= 100; i++) {
            if (!vistos[i]) {
                System.out.println(i);
                alguno = true;
            }
        }
        if (!alguno) {
            System.out.println("Todos los números entre 0 y 100 han sido introducidos.");
        }

        sc.close();
    }
}