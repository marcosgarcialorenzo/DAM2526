package Programacion.Curso2526.ExamenesMGL.Evaluacion2.Ej2;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Teatro { //clase teatro
    Persona butacas[][];

    public Teatro(int numeroFilas, int numeroColumnas) {
        butacas = new Persona[numeroFilas][numeroColumnas];
    }

    void colocarPersonas(String nombre, int numeroPersonas, int fila, int columna) throws Exception {
        if (numeroPersonas == 1) {
            Persona persona = new Persona(nombre);
            if (butacas[fila][columna] == null) {
                butacas[fila][columna] = persona;
            } else {
                throw new Exception("no se pueden colocar a todas las personas");
            }
        }
        if (numeroPersonas > 1) {
            colocarPersonas(nombre, numeroPersonas - 1, fila + 1, columna + 1);
        }
    }

    void mostrarOcupacion() {
        System.out.println("Estado de las reservas:");
        for (int i = 0; i < butacas.length; i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            for (int j = 0; j < butacas[i].length; j++) {
                if (butacas[i][j] == null) {
                    System.out.print("[0] ");
                } else {
                    System.out.print("[X] ");
                }
            }
            System.out.println();
        }
    }

    void guardarEnFichero(int filas, int columnas) {
        String ruta = "E:\\DAM2526\\src\\Programacion\\Curso2526\\ExamenesMGL\\Evaluacion2\\Ej2\\teatro.txt"; //comprobar ruta siempre
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write(filas + "#" + columnas);
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (butacas[i] != null) {
                        bw.write(i + "#" + j + "#" + butacas[i][j].nombre);
                        bw.newLine();
                    } else {
                        bw.write(i + "#" + j + "#LIBRE");
                        bw.newLine();
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        int filas = 10;
        int columnas = 10;
        Teatro teatro = new Teatro(filas, columnas);
        teatro.colocarPersonas("Marcos",1,1,1);
        teatro.colocarPersonas("Juan",3,2,4);
        teatro.mostrarOcupacion();
        teatro.guardarEnFichero(filas, columnas);
    }
}