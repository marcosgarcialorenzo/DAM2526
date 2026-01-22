package Programacion.Curso2526.H;

public class H1_SerieFibonacci {

    public int calcularFibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return calcularFibonacci(n - 1) + calcularFibonacci(n - 2); // n = la suma de los dos anteriores
            // vuelve a llamar al método hasta que n sea 0 o 1 y va sumando los resultados
        }
    }

    public static void main(String[] args) {
        H1_SerieFibonacci fibonacci = new H1_SerieFibonacci();
        int n = 4; // Cambia este valor para calcular otro número en la serie
        System.out.println("El número Fibonacci en la posición " + n + " es: " + fibonacci.calcularFibonacci(n));
    }
}