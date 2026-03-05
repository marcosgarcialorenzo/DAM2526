package Programacion.Curso2526.J.J0;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Vector;

public class Supermercado {
    String nombre;
    Vector<Clientes> clientes;
    Vector<Productos> productos;

    public Supermercado(String nombre) {
        this.nombre = nombre;
        this.clientes = new Vector<>(5, 5);
        this.productos = new Vector<>(5, 5);
    }

    public static void main(String[] args) throws IOException {
        Supermercado supermercado = new Supermercado("Supermercado XYZ");
        Clientes admin = new Clientes("admin", "admin123", false);
        supermercado.menu();
    }

    void añadirProducto() throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introduce el nombre del producto:");
        String nombre = t.leerString();
        System.out.println("Introduce el precio del producto:");
        double precio = t.leerDouble();// el precio normal y el de oferta son iguales al añadir el producto
        System.out.println("Introduce la cantidad del producto:");
        int cantidad = t.leerInt();
        System.out.println("¿Es un producto caducable? (s/n)");
        boolean caducable = t.leerString().equalsIgnoreCase("s");
        if (caducable) {
            System.out.println("Introduce la fecha de caducidad del producto (YYYY-MM-DD):");
            String fechaCaducidadStr = t.leerString();
            LocalDate fechaCaducidad = LocalDate.parse(fechaCaducidadStr);
            Productos producto = new Productos(nombre, precio, precio, null, cantidad, true, fechaCaducidad);
            productos.add(producto);
        } else {
            Productos producto = new Productos(nombre, precio, precio, null, cantidad, false, null);
            productos.add(producto);
        }
    }

    void listarProductos() throws IOException {
        for (Productos producto : productos) {
            System.out.println("Nombre: " + producto.nombre);
            if (producto.precioOferta < producto.precio) {
                System.out.println("Precio en oferta: " + producto.precioOferta);
                System.out.println("Fin de la oferta: " + producto.finOferta);
            } else {
                System.out.println("Precio: " + producto.precio);
            }
            System.out.println("Cantidad: " + producto.cantidad);
            if (producto.caducable) {
                System.out.println("Fecha de caducidad: " + producto.fechaCaducidad);
            }
            System.out.println();
        }
    }

    void menu() throws IOException {
        Teclado t = new Teclado();
        int opcion;
        boolean admin = false;
        boolean encontrado = false;
        System.out.println("Introduce un nombre de usuario:");
        String nombre = t.leerString();
        System.out.println("Introduce una contraseña:");
        String contraseña = t.leerString();
        for (Clientes cliente : clientes) {
            if (cliente.nombre.equals(nombre) && cliente.contraseña.equals(contraseña)) {
                if (cliente.nombre.equals("admin") && cliente.contraseña.equals("admin123")) {
                    admin = true;
                }
                encontrado = true;
            }
        }
        if (admin) { //si es admin
            do {
                System.out.println("1. Añadir producto");
                System.out.println("2. Listado de productos");
                System.out.println("3. Listado de productos con menos de una semana para caducar");
                System.out.println("3. Listado de productos con menos 5 unidades en stock");
                System.out.println("5. Poner un producto en oferta");
                System.out.println("0. Salir");
                System.out.println("Elige una opción:");
                opcion = t.leerInt();
                switch (opcion) {
                    case 1 -> añadirProducto();
                    case 2 -> listarProductos();
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida.");
                }
            } while (opcion != 0);
        }
        if (encontrado) { //si es user normal
            do {
                System.out.println("1. Añadir producto al carrito");
                System.out.println("2. Listar productos en el carrito");
                System.out.println("3. Comprar productos del carrito");
                System.out.println("4. Listar compras realizadas");
                System.out.println("5. Listar productos");
                System.out.println("0. Salir");
                System.out.println("Elige una opción:");
                opcion = t.leerInt();
                switch (opcion) {
                    case 1 -> altaLibros();
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida.");
                }
            } while (opcion != 0);
        }
    }
}