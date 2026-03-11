package Programacion.Curso2526.L.L4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
        obj.mostrarProducto3MasCaro(productos);
        System.out.println("Lista de productos con precio menor a 10 " + obj.buscarProductoPrecioMenor10(productos));
        System.out.println("Lista de productos con nombre de mas de 10 caracteres y cantidad menor a 10 " + obj.buscarProductoCantidadMenor10Y10Caracteres(productos));
        obj.incrementarPrecio10Porciento(productos);
        System.out.println("Producto que empieza por A y tiene menos de 10 de cantidad " + obj.buscarProductoEmpiezaConAYCantidadMenor10(productos));
        System.out.println("¿Hay algún producto con cantidad 0? " + obj.buscarProductoCantidad0(productos));
        System.out.println("¿Todos los productos tienen cantidad mayor a 0? " + obj.buscarProductoCantidadMayor0(productos));
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

    void mostrarProducto3MasCaro(Vector<Producto> productos) {
        System.out.println("El tercer producto mas caro es:");
        productos.stream()
                .sorted(Comparator.comparingDouble(p -> - p.precio)) // ordena de mayor a menor (el - invierte el orden)
                .skip(2) // salta los primeros 2 elementos del stream
                .findFirst() // obtiene el primer elemento del stream resultante (el tercer producto más caro)
                .ifPresent(System.out::println); // si el producto esta presente, lo imprime
    }

    List<String> buscarProductoPrecioMenor10(Vector<Producto> productos) {
        return productos.stream()
                .filter(p -> p.precio < 10) // filtra solo productos con precio menor a 10 (mira si cada p cumple la condición(p.precio < 10))
                .map(p -> p.nombre) // mapea a String (transforma un Producto a un String)
                .toList(); // convierte el stream resultante en una lista
    }

    List<String> buscarProductoCantidadMenor10Y10Caracteres(Vector<Producto> productos) {
        return productos.stream()
                .filter(p -> p.cantidad < 10) // primero filtra productos con cantidad menor a 10
                .map(p -> p.nombre) // mapea a String (transforma un Producto a un String)
                .filter(nombre -> nombre.length() > 10) // ahora filtra por longitud == 10 (lambda recibe String)
                .toList(); // convierte el stream resultante en una lista de Strings
    }

    void incrementarPrecio10Porciento(Vector<Producto> productos) {
        productos.forEach(p -> p.precio *= 1.10); // incrementa el precio de cada producto en un 10% (precio = precio * 1.10)
    }

    Producto buscarProductoEmpiezaConAYCantidadMenor10(Vector<Producto> productos) {
        return productos.stream()
                .filter(p -> p.getNombre().toLowerCase().startsWith("a") && p.getCantidad() < 10) // filtra productos que empiezan con "A" (ignora mayúsculas) y tienen cantidad menor a 10
                .findFirst() // devuelve el primer producto que cumple la condición del filter
                .orElse(new Producto(- 1, "NADA", 0.0, 0)); // devuelve esto si no se cumple la condición del filter
    }

    boolean buscarProductoCantidad0(Vector<Producto> productos) {
        return productos.stream()
                .anyMatch(p -> p.getCantidad() == 0); // devuelve true si al menos un producto tiene cantidad igual a 0 y false en caso contrario
    }

    boolean buscarProductoCantidadMayor0(Vector<Producto> productos) {
        return productos.stream()
                .allMatch(p -> p.getCantidad() > 0);
    }
}