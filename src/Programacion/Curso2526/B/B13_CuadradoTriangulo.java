package Programacion.Curso2526.B;

public class B13_CuadradoTriangulo {

    public static void main(String[] args) {
        B13_CuadradoTriangulo programa = new B13_CuadradoTriangulo();
        int N = 5;
        System.out.println("Cuadrado:");
        programa.cuadrado(N);
        System.out.println("Triángulo:");
        programa.triangulo(N);
    }

    void cuadrado(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(j);
                if (j < N) {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    void triangulo(int N) {
        for (int i = 1; i <= N; i++) {
            int estrellas = N - i;
            for (int s = 0; s < estrellas; s++){
                System.out.print('*');
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}