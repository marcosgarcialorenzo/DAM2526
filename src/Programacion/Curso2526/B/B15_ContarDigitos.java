package Programacion.Curso2526.B;

public class B15_ContarDigitos {

    static int contarDigitos(int n) {
        if (n == 0) {
            return 1;
        }
        int x = n;
        if (x < 0) {
            x = -x;
        }
        int contador = 0;
        while (x > 0) {
            x /= 10;
            contador++;
        }
        return contador;
    }

    public static void main(String[] args) {
        System.out.println("El numero 569 tiene " + contarDigitos(569) + " digitos."); // 3
        System.out.println("El numero -569 tiene " + contarDigitos(-569) + " digitos."); // 3
        System.out.println("El numero 0 tiene " + contarDigitos(0) + " digitos."); // 1
        System.out.println("El numero 1000 tiene " + contarDigitos(1000) + " digitos."); // 4
    }
}