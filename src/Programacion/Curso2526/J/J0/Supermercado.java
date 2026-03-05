package Programacion.Curso2526.J.J0;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Vector;

public class Supermercado {
    String nombre;
    Vector<Usuario> clientes;
    Vector<Producto> productos;

    public Supermercado(String nombre) {
        this.nombre = nombre;
        this.clientes = new Vector<>(5, 5);
        this.productos = new Vector<>(5, 5);
    }

    public static void main(String[] args) throws IOException {
        Supermercado supermercado = new Supermercado("Supermercado XYZ");
        Usuario admin = new ClienteNormal("admin", "admin123");
        supermercado.clientes.add(admin);
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
    }

    void listarProductos() {
        for (Producto producto : productos) {
            producto.mostrar();
        }
    }

    void listarProductosAPuntoDeCaducar() {
        for (Producto producto : productos) {
            if (producto.estaPorCaducar()) {
                producto.mostrar();
            }
        }
    }

    void listarProductosConMenosDe5EnStock() {
        for (Producto producto : productos) {
            if (producto.cantidad < 5) {
                producto.mostrar();
            }
        }
    }

    void ponerProductoEnOferta() throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introduce el nombre del producto que quieres poner en oferta:");
        String nombre = t.leerString();
        for (Producto producto : productos) {
            if (producto.enOferta()) {
                System.out.println("El producto ya está en oferta.");
                return;
            } else {
                if (producto.caducable()) { // ProductoCaducable o ProductoOfertaCaducable
                    System.out.println("Introduce el precio de la oferta:");
                    double precioOferta = t.leerDouble();
                    System.out.println("Introduce la fecha de fin de la oferta (YYYY-MM-DDTHH:MM):");
                    String fechaFinOfertaStr = t.leerString();
                    LocalDateTime fechaFinOferta = LocalDateTime.parse(fechaFinOfertaStr);
                    productos.set(productos.indexOf(producto), new ProductoOfertaCaducable(producto.nombre, precioOferta, producto.cantidad, fechaFinOferta, ((ProductoCaducable) producto).fechaCaducidad));
                } else { // Producto a ProductoOferta
                    System.out.println("Introduce el precio de la oferta:");
                    double precioOferta = t.leerDouble();
                    System.out.println("Introduce la fecha de fin de la oferta (YYYY-MM-DDTHH:MM):");
                    String fechaFinOfertaStr = t.leerString();
                    LocalDateTime fechaFinOferta = LocalDateTime.parse(fechaFinOfertaStr);
                    productos.set(productos.indexOf(producto), new ProductoOferta(producto.nombre, precioOferta, producto.cantidad, fechaFinOferta));
                }
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
        String contrasena = t.leerString();
        for (Usuario user : clientes) {
            if (user.nombre.equals(nombre) && user.contrasena.equals(contrasena)) {
                if (user.nombre.equals("admin") && user.contrasena.equals("admin123")) {
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
                    case 1 -> anadirProducto();
                    case 2 -> listarProductos();
                    case 3 -> listarProductosAPuntoDeCaducar();
                    case 4 -> listarProductosConMenosDe5EnStock();
                    case 5 -> ponerProductoEnOferta();
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
                    case 2 -> System.out.println("Funcionalidad no implementada.");
                    case 3 -> System.out.println("Funcionalidad no implementada.");
                    case 4 -> System.out.println("Funcionalidad no implementada.");
                    case 5 -> listarProductos();
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida.");
                }
            } while (opcion != 0);
        }
    }
}