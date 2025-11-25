package Programacion.Curso2526.B.B8;

import java.io.IOException;

public class B8_ProductoSumas {
    public static void main(String[] args) throws IOException {
        Teclado t = new Teclado();
        int a, b;

        System.out.println("Introduce el primer entero positivo:");
        a = t.leerInt();
        if (a < 0) {
            System.out.println("ERROR:  Número negativo.");
        }
        System.out.println("Introduce el segundo entero positivo:");
        b = t.leerInt();
        if (b < 0) {
            System.out.println("ERROR:  Número negativo.");
        }
        if (a == 0 || b == 0) {
            System.out.println("Producto: 0");
            System.out.println("Sumas realizadas: 0");
            return;
        }

        int multiplicador = Math.min(a, b); // se usa el menor como contador de sumas
        int sumando = Math.max(a, b); // se suma el mayor cada vez
        int resultado = 0;
        int sumasRealizadas = 0;

        /*// Bucle principal: descomposición binaria del multiplicador
        while (multiplicador > 0) {
            // Si el bit menos significativo de multiplicador es 1,
            // debemos añadir el sumando actual al resultado
            if ((multiplicador & 1) == 1) {
                resultado += sumando; // una suma para añadir al resultado
                sumasRealizadas++;    // contabilizamos esa suma
            }

            // Desplazamos el multiplicador a la derecha (dividir entre 2)
            multiplicador >>= 1;

            // Si aún quedan bits por procesar, duplicamos el sumando
            // (equivale a multiplicarlo por 2) para la siguiente posición de bit.
            // Esta duplicación se realiza sumando sumando + sumando,
            // por lo que también cuenta como una suma.
            if (multiplicador > 0) {
                sumando += sumando; // duplicar sumando -> una suma
                sumasRealizadas++;
            }
        }*/

        for (int i = 0; i < multiplicador; i++) {
            resultado += sumando;
            sumasRealizadas++;
        }
        System.out.println("Producto: " + resultado);
        System.out.println("Sumas realizadas: " + sumasRealizadas);
    }
}