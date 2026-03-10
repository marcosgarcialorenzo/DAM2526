package Programacion.Curso2526.L.L2;

import java.util.Arrays;
import java.util.List;

public class VersionLambda {

    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1, 22, 3, 44, 15, 6, 27, 28, 19, 10);
        System.out.println("Mostrando lista");
        VersionLambda obj = new VersionLambda();
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
        lista.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    void mostrarPares(List<Integer> lista) {
        lista.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    void mostrarParesOrdenados(List<Integer> lista) {
        lista.stream()
                .filter(n -> n % 2 == 0)
                .sorted()
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    void sumarNumerosCon2Digitos(List<Integer> lista) {
        int suma = lista.stream()
                .filter(n -> n >= 10 && n <= 99) //solo tiene en cuenta los números de 2 dígitos positivos
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(suma);
    }

    void contarNumerosCon2Digitos(List<Integer> lista) {
        int total = (int) lista.stream()
                .filter(n -> n >= 10 && n <= 99) //solo tiene en cuenta los números de 2 dígitos positivos
                .count();
        System.out.println(total);
    }
}