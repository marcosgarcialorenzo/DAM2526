package Programacion.C.C1;

import java.util.Scanner;

public class C1_BinarioABase10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número binario: ");
        long numeroBinario = sc.nextLong();
        C1_BinarioABase10 conversor = new C1_BinarioABase10();
        int resultadoDecimal = conversor.binarioABase10(numeroBinario);
        System.out.println("El número binario " + numeroBinario + " en base 10 es: " + resultadoDecimal);
        sc.close();
    }

    int binarioABase10(long binario) {
        int resultado = 0;
        int potencia = 0;
        long b = Math.abs(binario);

        if (b == 0) {
            return 0;
        }

        while (b > 0) {
            int digito = (int) (b % 10);
            if (digito != 0 && digito != 1) {
                System.out.println("ERROR:      El número contiene dígitos distintos de 0 y 1");
            }
            if (digito == 1) {
                resultado += (Math.pow(2, potencia));
            }
            potencia++;
            b /= 10;
        }
        return resultado;
    }
}