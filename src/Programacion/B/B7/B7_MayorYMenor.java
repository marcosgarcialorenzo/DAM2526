package Programacion.B.B7;

import java.io.IOException;

public class B7_MayorYMenor {

    public static void main(String[] args) throws IOException {
        Teclado t = new Teclado();
        int numero;
        int mayor = 0;
        int menor = 0;
        boolean hayNumeros = false;
        while (true) {
            System.out.println("Introduce un numero entero (0 para terminar):");
            numero = t.leerInt();
            if (numero < 0) {
                System.out.println("ERROR:    El numero es negativo.");
            }
            if (numero == 0) {
                System.out.println("Fin del programa.");
                break;
            }
            if (!hayNumeros) {
                mayor = numero;
                menor = numero;
                hayNumeros = true;
            } else {
                if (numero > mayor) {
                    mayor = numero;
                }
                if (numero < menor) {
                    menor = numero;
                }
            }
        }
        if (hayNumeros) {
            System.out.println("Mayor: " + mayor);
            System.out.println("Menor: " + menor);
        } else {
            System.out.println("No se introdujeron numeros positivos.");
        }
    }
}