package Programacion.Curso2526.J.J0;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Vector;

public class Supermercado {
    String nombre;
    Vector<ClienteNormal> clientes;
    Vector<Producto> productos;

    public Supermercado(String nombre) {
        this.nombre = nombre;
        this.clientes = new Vector<>(5, 5);
        this.productos = new Vector<>(5, 5);
    }

    public static void main(String[] args) throws IOException {
        Supermercado supermercado = new Supermercado("Supermercado XYZ");
        Usuario admin = new ClienteNormal("admin", "admin123");
        supermercado.menu();
    }

    void anadirProducto() throws IOException {
        Teclado t = new Teclado();
        String nombre, oferta, caducable;
        double precio, precioOferta = 0;
        LocalDateTime fechaCaducidad = null, fechaFinOferta = null;
        System.out.println("Introduce el nombre del producto:");
        nombre = t.leerString();
        System.out.println("Introduce el precio del producto:");
        precio = t.leerDouble();
        System.out.println("Introduce la cantidad del producto:");
        int cantidad = t.leerInt();
        System.out.println("¿El producto tiene oferta? (s/n)");
        oferta = t.leerString();
        if (oferta.equalsIgnoreCase("s")) {
            System.out.println("Introduce el precio de la oferta:");
            precioOferta = t.leerDouble();
            System.out.println("Introduce la fecha de fin de la oferta (YYYY-MM-DDTHH:MM):");
            String fechaFinOfertaStr = t.leerString();
            fechaFinOferta = LocalDateTime.parse(fechaFinOfertaStr);
        }
        System.out.println("¿El producto es caducable? (s/n)");
        caducable = t.leerString();
        if (caducable.equalsIgnoreCase("s")) {
            System.out.println("Introduce la fecha de caducidad (YYYY-MM-DD):");
            String fechaCaducidadStr = t.leerString();
            fechaCaducidad = LocalDateTime.parse(fechaCaducidadStr);
        }
        if (oferta.equalsIgnoreCase("s") && caducable.equalsIgnoreCase("s")) { //oferta y caducable
            productos.add(new ProductoOfertaCaducable(nombre, precioOferta, cantidad, fechaFinOferta, fechaCaducidad));
        }
        if (oferta.equalsIgnoreCase("s") && caducable.equalsIgnoreCase("n")) { //solo oferta
            productos.add(new ProductoOferta(nombre, precioOferta, cantidad, fechaFinOferta));
        }
        if (oferta.equalsIgnoreCase("n") && caducable.equalsIgnoreCase("s")) { //solo caducable
            productos.add(new ProductoCaducable(nombre, precio, cantidad, fechaCaducidad));
        }
        if (oferta.equalsIgnoreCase("n") && caducable.equalsIgnoreCase("n")) { //normal
            productos.add(new Producto(nombre, precio, cantidad));
    }

    void listarProductos() {
        for (Producto producto : productos) {
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

    void listarProductosAPuntoDeCaducar() {
        for (Producto producto : productos) {
            if (producto.caducable && producto.fechaCaducidad.isBefore(LocalDate.now().plusDays(7))) {
                System.out.println("Nombre: " + producto.nombre);
                if (producto.precioOferta < producto.precio) {
                    System.out.println("Precio en oferta: " + producto.precioOferta);
                    System.out.println("Fin de la oferta: " + producto.finOferta);
                } else {
                    System.out.println("Precio: " + producto.precio);
                }
                System.out.println("Cantidad: " + producto.cantidad);
                System.out.println("Fecha de caducidad: " + producto.fechaCaducidad);
                System.out.println();
            }
        }
    }

    void listarProductosConMenosDe5EnStock() {
        for (Producto producto : productos) {
            if (producto.cantidad < 5) {
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
        for (ClienteNormal cliente : clientes) {
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
                    case 3 -> listarProductosAPuntoDeCaducar();
                    case 4 -> listarProductosConMenosDe5EnStock();
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
                    case 1 -> System.out.println("Funcionalidad no implementada.");
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida.");
                }
            } while (opcion != 0);
        }
    }
}