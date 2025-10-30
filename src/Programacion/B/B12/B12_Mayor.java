package Programacion.B.B12;

import java.io.IOException;

public class B12_Mayor {

    int mayor() throws IOException {
        Teclado t = new Teclado();
        int num1, num2;
        int contador = 0;

        do {
            System.out.println("Introduce el primer numero:");
            num1 = t.leerInt();
            System.out.println("Introduce el segundo numero");
            num2 = t.leerInt();
            if (num1 < 0 || num2 < 0) {
                System.out.println("ERROR:      El numero es negativo.");
                continue;
            }
            contador++;
        } while (num1 < num2);
        return contador;
    }
    int mayor2() throws IOException {
        Teclado t = new Teclado();
        int num1 = 0;
        int num2 = 0;
        int contador = 0;
        boolean primerNumero = false;
        boolean terminado = false;

        while (!primerNumero) {
            System.out.println("Introduce un numero entero (positivo):");
            num1 = t.leerInt();
            if (num1 < 0) {
                System.out.println("ERROR:      El numero es negativo.");
                continue;
            }
            contador = 0;
            primerNumero = true;
            num2 = num1;
        }

        while (!terminado) {
            System.out.println("Introduce otro numero entero:");
            num2 = t.leerInt();
            if (num2 < 0) {
                System.out.println("ERROR:      El numero es negativo.");
                continue;
            }
            if (num2 < num1) {
                terminado = true;
            } else {
                contador++;
                num1 = num2;
            }
        }
        return contador;
    }

    public static void main(String[] args) throws IOException {
        B12_Mayor programa = new B12_Mayor();
        int resultado = programa.mayor2();
        System.out.println("Se han introducido " + resultado + " numeros menores o iguales que el primero.");
    }
}