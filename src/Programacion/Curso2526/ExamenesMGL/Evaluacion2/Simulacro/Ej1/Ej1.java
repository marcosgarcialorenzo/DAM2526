package Programacion.Curso2526.ExamenesMGL.Evaluacion2.Simulacro.Ej1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ej1 {
    public static void main(String[] args) {
        int contador = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\marco\\IdeaProjects\\DAM2526\\src\\Programacion\\Curso2526\\ExamenesMGL\\Evaluacion2\\Simulacro\\productos.txt"))) { // para saber cuantas lineas tiene el .txt
            while (reader.readLine() != null) {
                contador++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Productos[] productos = new Productos[contador];
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\marco\\IdeaProjects\\DAM2526\\src\\Programacion\\Curso2526\\ExamenesMGL\\Evaluacion2\\Simulacro\\productos.txt"))) {
            String linea;
            int contadorProductos = 0;
            int numeroLinea = 1;
            while ((linea = br.readLine()) != null) {
                boolean errorB = false;
                boolean errorA = false;
                double precioMedioAdquisicion = 0;
                String[] partes = linea.split(";");
                try {
                    Integer.parseInt(partes[0]); //valida el código del producto
                    if (partes.length <= 1) { //valida el precio del producto
                        errorA = true;
                    } else {
                        for (int i = 1; i < partes.length; i++) {
                            Double.parseDouble(partes[i]);
                        }
                    }
                } catch (Exception e) {
                    errorB = true;
                }
                if (errorA || errorB) {
                    String mensaje = "línea " + numeroLinea + ":";
                    if (errorB) {
                        mensaje += " Error B";
                    }
                    if (errorA) {
                        mensaje += " Error A";
                    }
                    System.out.println(mensaje + " -> " + linea);
                } else {
                    /*la parte de meter el producto en el array se puede saltar, simplemente
                    double suma = 0;
                    for (int i = 1; i < partes.length; i++) {
                    suma += Double.parseDouble(partes[i]);
                    precioMedioAdquisicion = suma / precios.length;
                    }
                    System.out.println("Producto:" + partes[0] + " " + precioMedioAdquisicion);
                    */
                    int codigo = Integer.parseInt(partes[0]);
                    double[] precios = new double[partes.length - 1];
                    double suma = 0;
                    for (int i = 1; i < partes.length; i++) {
                        precios[i - 1] = Double.parseDouble(partes[i]);
                        suma += precios[i - 1];
                    }
                    Productos producto = new Productos(codigo, precios);
                    productos[contadorProductos] = producto;
                    precioMedioAdquisicion = suma / precios.length;
                    System.out.println("Producto:" + producto.codigo + " " + precioMedioAdquisicion);
                    contadorProductos++;
                }
                numeroLinea++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}