package Programacion.Curso2526.C.C6;

import java.util.Scanner;

public class C6_Base10ABinario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número decimal: ");
        int numeroDecimal = sc.nextInt();
        C6_Base10ABinario conversor = new C6_Base10ABinario();
        long resultadoBinario = conversor.base10ABinario(numeroDecimal);
        System.out.println("El número decimal " + numeroDecimal + " en binario es: " + resultadoBinario);
        sc.close();
    }

    long base10ABinario(int decimal) {
        long resultado = 0;
        int potencia = 0;
        int d = Math.abs(decimal);

        if (d == 0) {
            return 0;
        }

        while (d > 0) {
            int residuo = d % 2;
            resultado += residuo * Math.pow(10, potencia);
            potencia++;
            d /= 2;
        }
        return resultado;
    }
}