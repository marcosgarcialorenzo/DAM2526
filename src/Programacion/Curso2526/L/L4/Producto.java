package Programacion.Curso2526.L.L4;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    int id;
    String nombre;
    double precio;
    int cantidad;

    public static void main(String[] args) {
        Producto obj = new Producto();
        File txt = new File("C:\\Users\\marco\\IdeaProjects\\DAM2526\\src\\Programacion\\Curso2526\\L\\L4\\Productos.txt");
        Vector<Producto> productos = new Vector<>(5, 3);
        obj.cargarFichero(txt, productos);
        obj.mostrarTercerProductoMasCaro(productos);
        System.out.println("Lista de productos con precio menor a 10 " + obj.productosConPrecioMenorA10(productos));
        System.out.println("Lista de productos con nombre de mas de 10 caracteres y cantidad menor a 10 " + obj.productosCon10CaracteresYMenosDe10DeCantidad(productos));
    }

    @Override
    public String toString() {
        return "id = " + id + ", nombre = " + nombre + ", precio = " + precio + ", cantidad = " + cantidad;
    }

    void cargarFichero(File txt, Vector<Producto> productos) {
        try (BufferedReader br = new BufferedReader(new FileReader(txt))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                double precio = Double.parseDouble(datos[2]);
                int cantidad = Integer.parseInt(datos[3]);
                productos.add(new Producto(id, nombre, precio, cantidad));
            }
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    void mostrarTercerProductoMasCaro(Vector<Producto> productos) {
        System.out.println("El tercer producto mas caro es:");
        productos.stream()
                .sorted(Comparator.comparingDouble(p -> - p.precio)) // ordena de mayor a menor (el - invierte el orden)
                .skip(2) // salta los primeros 2 elementos del stream
                .findFirst() // obtiene el primer elemento del stream resultante (el tercer producto más caro)
                .ifPresent(System.out::println); // si el producto esta presente, lo imprime
    }

    List<String> productosConPrecioMenorA10(Vector<Producto> productos) {
        return productos.stream()
                .filter(p -> p.precio < 10) // filtra solo productos con precio menor a 10 (mira si cada p cumple la condición(p.precio < 10))
                .map(p -> p.nombre)
                .toList(); // convierte el stream resultante en una lista
    }

    List<String> productosCon10CaracteresYMenosDe10DeCantidad(Vector<Producto> productos) {
        return productos.stream()
                .filter(p -> p.cantidad < 10) // primero filtra productos con cantidad menor a 10
                .map(p -> p.nombre) // mapea a String (transforma un Producto a un String)
                .filter(nombre -> nombre.length() > 10) // ahora filtra por longitud == 10 (lambda recibe String)
                .toList(); // convierte el stream resultante en una lista de Strings
    }
}