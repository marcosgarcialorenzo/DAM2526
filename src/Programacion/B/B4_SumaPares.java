package Programacion.B;

import java.util.Scanner;

public class B4_SumaPares {
    public static void main(String[] args) {
        int sumaPares = 0;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Introduce enteros (0 para terminar):");
            while (true) {
                int n = sc.nextInt();
                if (n == 0) break;
                if (n % 2 == 0) sumaPares += n;
            }
        } catch (Exception e) {
            System.err.println("Entrada no válida.");
            return;
        }
        System.out.println("Suma de los números pares: " + sumaPares);
    }
}
