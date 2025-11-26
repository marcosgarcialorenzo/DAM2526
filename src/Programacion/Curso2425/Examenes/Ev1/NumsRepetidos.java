package Programacion.Curso2425.Examenes.Ev1;

import java.util.Scanner;

public class NumsRepetidos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dar un número");
        int n = sc.nextInt();
        if (n < 0)
            n = n * -1;
        if (n <= 9) {
            for (int i = 0; i < n; i++)
                System.out.print(n);
            System.out.println();
        } else
            System.out.println("Solo se admiten números de 1 dígito");
    }
}