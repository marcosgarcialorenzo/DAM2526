package Programacion.Curso2526.ExamenesMGL.Evaluacion2.Simulacro.Ej1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/Programacion/Curso2526/ExamenesMGL/Evaluacion2/Simulacro/Ej1/productos.txt"))) {
            String linea;
            Productos[] productos = new Productos[1000];
            int contador = 0;
            int numeroLinea = 0;
            boolean errorA = false;
            boolean errorB = false;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                String[] partes = linea.split(";");
                errorA = false;
                errorB = false;
                int codigo = - 1;
                try {
                    codigo = Integer.parseInt(partes[0]);
                } catch (NumberFormatException e) {
                    errorB = true;
                }
                boolean hayPrecioValido = false;
                double[] preciosTemp = new double[partes.length - 1];
                int contPrecios = 0;
                for (int i = 1; i < partes.length; i++) {
                    try {
                        double precio = Double.parseDouble(partes[i]);
                        preciosTemp[contPrecios] = precio;
                        contPrecios++;
                        hayPrecioValido = true;
                    } catch (NumberFormatException e) {
                        errorB = true;
                    }
                }
                if (! hayPrecioValido) {
                    errorA = true;
                }
                if (! errorA || ! errorB) {
                    System.out.print("línea " + numeroLinea + ":");
                    if (errorB) {
                        System.out.print("Error B ");
                    }
                    if (errorA) {
                        System.out.print("Error A ");
                    }
                    System.out.println("->" + linea);
                } else {
                    Productos p = new Productos(codigo, preciosTemp, contPrecios);
                    productos[contador] = p;
                    contador++;
                }
            }
            for (int i = 0; i < contador; i++) {
                System.out.println("Productos: " + productos[i].getCodigo() + " " + productos[i].getPrecioMedio());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}