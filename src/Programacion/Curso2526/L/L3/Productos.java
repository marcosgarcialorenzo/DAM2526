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
        obj.mostrarProductosDeMasDe50EurosDeMayorAMenor(productos);
        obj.mostrar5ProductosMasCaros(productos);
    }

    @Override
    public String toString() {
        return "id = " + id + ", nombre = " + nombre + ", precio = " + precio + ", cantidad = " + cantidad;
    }

    void mostrarProductoDeMayorPrecio(Vector<Productos> productos) {
        productos.stream()
                .max(Comparator.comparingDouble(p -> p.precio)) // busca el máximo precio de cada p
                .ifPresent(p -> System.out.println("Producto de mayor precio: " + p)); // si p esta presente, lo imprime
    }

    void mostrarProductosDeMasDe50EurosDeMayorAMenor(Vector<Productos> productos) {
        System.out.println("Productos de mas de 50 euros de mayor a menor precio:");
        productos.stream()
                .filter(p -> p.precio > 50) // filtra solo productos con precio mayor a 50 (mira si cada p cumple la condición(p.precio > 50))
                .sorted(Comparator.comparingDouble(p -> - p.precio)) // ordena de mayor a menor (el - invierte el orden)
                .forEach(System.out::println); // imprime cada producto usando method reference
    }

    void mostrar5ProductosMasCaros(Vector<Productos> productos) {
        System.out.println("Los 5 productos mas caros:");
        productos.stream()
                .sorted(Comparator.comparingDouble(p -> - p.precio))
                .limit(5)
                .forEach(System.out::println);
    }

    private void cargarFichero(File txt, Vector<Productos> productos) {
        try (BufferedReader br = new BufferedReader(new FileReader(txt))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                double precio = Double.parseDouble(datos[2]);
                int cantidad = Integer.parseInt(datos[3]);
                productos.add(new Productos(id, nombre, precio, cantidad));
            }
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}