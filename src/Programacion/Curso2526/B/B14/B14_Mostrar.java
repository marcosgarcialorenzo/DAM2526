package Programacion.Curso2526.B.B14;

import java.io.IOException;

public class B14_Mostrar {
    public static boolean tieneDigito(int numero, int digito) {
        boolean encontrado = false;
        if (numero == 0) {
            return digito == 0;
        }
        numero = Math.abs(numero);
        while (numero > 0) {
            if (numero % 10 == digito) {
                encontrado = true;
                return encontrado;
            }
            numero /= 10;
        }
        return encontrado;
    }

    public static void main(String[] args) throws IOException {
        Teclado sc = new Teclado();
        System.out.print("Introduce un dígito (0-9): ");
        int digito = sc.leerInt();

        if (digito < 0 || digito > 9) {
            System.out.println("El dígito debe estar entre 0 y 9.");
        }

        boolean primero = true;
        for (int i = 1000; i <= 3000; i++) {
            if (tieneDigito(i, digito)) {
                if (primero) {
                    System.out.print(i);
                    primero = false;
                } else {
                    System.out.print(", " + i);
                }
            }
        }
        System.out.println();
    }
}