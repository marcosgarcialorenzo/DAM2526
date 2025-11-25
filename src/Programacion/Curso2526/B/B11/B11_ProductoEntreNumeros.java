package Programacion.Curso2526.B.B11;

import java.io.IOException;

public class B11_ProductoEntreNumeros {
    public static double productoEntre(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        double producto = 1;
        for (int i = min + 1; i <= max - 1; i++) {
            producto *= i;
        }
        return producto;
    }

    public static void main(String[] args) throws IOException {
        Teclado t = new Teclado();
        System.out.print("Introduce primer número: ");
        int a = t.leerInt();
        System.out.print("Introduce segundo número: ");
        int b = t.leerInt();
        double resultado = productoEntre(a, b);
        System.out.println(resultado);
    }
}