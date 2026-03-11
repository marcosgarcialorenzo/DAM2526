package Programacion.Curso2526.L.L3;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Vector;

@AllArgsConstructor
@NoArgsConstructor
public class Productos {
    int id;
    String nombre;
    double precio;
    int cantidad;

    public static void main(String[] args) {
        Productos obj = new Productos();
        File txt = new File("C:\\Users\\marco\\IdeaProjects\\DAM2526\\src\\Programacion\\Curso2526\\L\\L3\\Productos.txt");
        Vector<Productos> productos = new Vector<>(5, 3);
        obj.cargarFichero(txt, productos);
        obj.mostrarProductoDeMayorPrecio(productos);
    }

    @Override
    public String toString() {
        return "id = " + id + ", nombre = " + nombre + ", precio = " + precio + ", cantidad = " + cantidad;
    }

    void mostrarProductoDeMayorPrecio(Vector<Productos> productos) {
        productos.stream()
                .max(Comparator.comparingDouble(p -> p.precio))
                .ifPresent(p -> System.out.println("Producto de mayor precio: " + p));
    }

    private void cargarFichero(File txt, Vector<Productos> productos) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(txt));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                double precio = Double.parseDouble(datos[2]);
                int cantidad = Integer.parseInt(datos[3]);
                productos.add(new Productos(id, nombre, precio, cantidad));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}