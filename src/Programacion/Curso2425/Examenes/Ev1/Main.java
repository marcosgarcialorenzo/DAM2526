package Programacion.Curso2425.Examenes.Ev1;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2 = 0;
        int sumaMayores = 0;
        int sumaMenores = 0;
        int contNums = 0;
        do {
            System.out.println("Introduce el número 1 ");
            n1 = sc.nextInt();
            if (n1 != -1) {
                System.out.println("Introduce el número 2 ");
                n2 = sc.nextInt();
                if (n2 != -1) {
                    contNums++;
                    if (n1 > n2) {
                        sumaMayores += n1;
                        sumaMenores += n2;
                    } else {
                        sumaMayores += n2;
                        sumaMenores += n1;
                    }
                }
            }
        } while (n1 != -1 && n2 != -1);
        System.out.println("La suma de los mayores es " + sumaMayores);
        System.out.println("La media de los menores es " + ((double) sumaMenores / contNums));
    }
}