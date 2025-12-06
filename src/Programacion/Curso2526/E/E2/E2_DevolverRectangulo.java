package Programacion.Curso2526.E.E2;

import java.io.IOException;

public class E2_DevolverRectangulo {
    int filas;
    double[][] rectangulo;

    public static void main(String[] args) throws IOException {
        Teclado t = new Teclado();
        E2_DevolverRectangulo obj = new E2_DevolverRectangulo();
        System.out.println("Introduce el numero de figuras:");
        int filas = t.leerInt();
        double[][] rectangulo = new double[filas][4];
        for (int i = 0; i < filas; i++) {
            System.out.println("Introduce los cuatro lados de la figura " + (i + 1) + ":");
            for (int j = 0; j < 4; j++) {
                System.out.println("Lado " + (j + 1) + ":");
                rectangulo[i][j] = t.leerDouble();
            }
        }
        double[][] resultado = obj.devolverRectangulo(rectangulo);
        System.out.println("Figuras que son rectangulos o cuadrados:");
        obj.mostrar(resultado);
    }

    double[][] devolverRectangulo(double[][] rectangulo) {
        int contador = 0;
        for (int i = 0; i < rectangulo.length; i++) {
            if (esRectangulo(rectangulo[i][0], rectangulo[i][1], rectangulo[i][2], rectangulo[i][3])) {
                contador++;
            } else if (esCuadrado(rectangulo[i][0], rectangulo[i][1], rectangulo[i][2], rectangulo[i][3])) {
                contador++;
            }
        }
        double[][] devolverRectangulo = new double[contador][4];
        for (int i = 0; i < rectangulo.length; i++) {
            if (esRectangulo(rectangulo[i][0], rectangulo[i][1], rectangulo[i][2], rectangulo[i][3])) {
                devolverRectangulo[i][0] = rectangulo[i][0];
                devolverRectangulo[i][1] = rectangulo[i][1];
                devolverRectangulo[i][2] = rectangulo[i][2];
                devolverRectangulo[i][3] = rectangulo[i][3];
            } else if (esCuadrado(rectangulo[i][0], rectangulo[i][1], rectangulo[i][2], rectangulo[i][3])) {
                devolverRectangulo[i][0] = rectangulo[i][0];
                devolverRectangulo[i][1] = rectangulo[i][1];
                devolverRectangulo[i][2] = rectangulo[i][2];
                devolverRectangulo[i][3] = rectangulo[i][3];
            }
        }
        return devolverRectangulo;
    }

    boolean esCuadrado(double lado1, double lado2, double lado3, double lado4) {
        return lado1 == lado2 && lado2 == lado3 && lado3 == lado4 && lado4 == lado1; // && = AND logico
    }

    boolean esRectangulo(double lado1, double lado2, double lado3, double lado4) {
        return (lado1 == lado3 && lado2 == lado4) || (lado1 == lado2 && lado3 == lado4) || (lado1 == lado4 && lado2 == lado3); // || = OR logico
    }

    void mostrar(double[][] rectangulo) {
        for (int i = 0; i < rectangulo.length; i++) {
            System.out.print("Figura " + (i + 1) + ": ");
            for (int j = 0; j < rectangulo[i].length; j++) {
                System.out.print(rectangulo[i][j] + " ");
            }
            System.out.println();
        }
    }
}