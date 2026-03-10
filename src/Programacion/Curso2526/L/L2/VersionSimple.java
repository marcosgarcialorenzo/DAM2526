package Programacion.Curso2526.L.L2;

import java.util.Arrays;
import java.util.List;

public class VersionSimple {

    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1, 22, 3, 44, 15, 6, 27, 28, 19, 10);
        System.out.println("Mostrando lista");
        VersionSimple obj = new VersionSimple();
        obj.mostrar(lista);
        System.out.println("Mostrando números pares:");
        obj.mostrarPares(lista);
        System.out.println("Mostrando números pares ordenados:");
        obj.mostrarParesOrdenados(lista);
        System.out.println("Suma de números de 2 dígitos:");
        obj.sumarNumerosCon2Digitos(lista);
        System.out.println("Conteo de números de 2 dígitos: ");
        obj.contarNumerosCon2Digitos(lista);
    }

    void mostrar(List<Integer> lista) {
        for (Integer num : lista) {
            System.out.println(num);
        }
    }

    void mostrarPares(List<Integer> lista) {
        for (Integer num : lista) {
            if (num % 2 == 0) {
                System.out.println(num);
            }
        }
    }

    void mostrarParesOrdenados(List<Integer> lista) {
        lista.sort((num1, num2) -> Integer.compare(num1, num2));
        for (Integer num : lista) {
            if (num % 2 == 0) {
                System.out.println(num);
            }
        }
    }

    void sumarNumerosCon2Digitos(List<Integer> lista) {
        int suma = 0;
        for (Integer num : lista) {
            if (num >= 10 && num <= 99) {
                suma += num;
            }
        }
        System.out.println(suma);
    }

    void contarNumerosCon2Digitos(List<Integer> lista) {
        int total = 0;
        for (Integer num : lista) {
            if (num >= 10 && num <= 99) {
                total++;
            }
        }
        System.out.println(total);
    }
}