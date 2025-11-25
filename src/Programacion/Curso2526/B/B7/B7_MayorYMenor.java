package Programacion.Curso2526.B.B7;

import java.io.IOException;

public class B7_MayorYMenor {

    public static void main(String[] args) throws IOException {
        Teclado t = new Teclado();
        int numero;
        int mayor = 0;
        int menor = 0;
        boolean hayNumeros = false;
        do {
            System.out.println("Introduce un numero entero (0 para terminar):");
            numero = t.leerInt();

            /*if (numero == 0) {
                // no procesar el 0, sirve solo para terminar
                break;
            }*/
            if (numero < 0) {
                System.out.println("ERROR:    El numero es negativo.");
            }
            if (!hayNumeros) {
                mayor = numero;
                menor = numero;
                hayNumeros = true;
            } else {
                if (numero > mayor) {
                    mayor = numero;
                }
                if (numero < menor && numero != 0) {
                    menor = numero;
                }
            }

        } while (numero != 0);

        if (hayNumeros) {
            System.out.println("Mayor: " + mayor);
            System.out.println("Menor: " + menor);
        } else {
            System.out.println("No se introdujeron numeros positivos.");
        }
    }
}