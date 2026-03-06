package Programacion.Curso2526.J.J0;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Vector;

public class Supermercado {
    String nombre;
    Vector<Cliente> clientes;
    Vector<Producto> productos;

    public Supermercado(String nombre) {
        this.nombre = nombre;
        this.clientes = new Vector<>(5, 5);
        this.productos = new Vector<>(5, 5);
    }

    public static void main(String[] args) throws IOException {
        Supermercado supermercado = new Supermercado("Supermercado XYZ");
        Cliente admin = new Cliente("admin", "admin123");
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
            if (producto.nombre.equals(nombre)) {
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
    }

    void anadirProductoAlCarrito(Cliente cliente) throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introduce el nombre del producto que quieres añadir al carrito:");
        String nombre = t.leerString();
        for (Producto producto : productos) {
            if (producto.nombre.equals(nombre)) {
                System.out.println("Introduce la cantidad que quieres añadir al carrito:");
                int cantidad = t.leerInt();
                if (cantidad > producto.cantidad) {
                    System.out.println("No hay suficiente stock.");
                } else {
                    if (producto.caducable() && producto.enOferta()) {
                        cliente.carrito.add(new ProductoOfertaCaducable(producto.nombre, producto.precio, cantidad, ((ProductoOfertaCaducable) producto).fechaFinOferta, ((ProductoOfertaCaducable) producto).fechaCaducidad));
                    }
                    if (producto.caducable() && ! producto.enOferta()) {
                        cliente.carrito.add(new ProductoCaducable(producto.nombre, producto.precio, cantidad, ((ProductoCaducable) producto).fechaCaducidad));
                    }
                    if (! producto.caducable() && producto.enOferta()) {
                        cliente.carrito.add(new ProductoOferta(producto.nombre, producto.precio, cantidad, ((ProductoOferta) producto).fechaFinOferta));
                    } else {
                        cliente.carrito.add(new Producto(producto.nombre, producto.precio, cantidad));
                    }
                }
            }
        }
    }

    void listarProductosCarrito(Cliente cliente) {
        for (Producto producto : cliente.carrito) {
            producto.mostrar();
        }
    }

    void comprarProductosCarrito(Cliente cliente) {
        cliente.compras.addAll(cliente.carrito);
        for (Producto productoCarrito : cliente.carrito) {
            for (Producto producto : productos) {
                if (producto.nombre.equals(productoCarrito.nombre)) {
                    producto.cantidad -= productoCarrito.cantidad;
                }
            }
        }
        cliente.carrito.clear();
    }

    void listarComprasRealizadas(Cliente cliente) {
        for (Producto producto : cliente.compras) {
            producto.mostrar();
        }
    }

    void anadirCliente() throws IOException {
        Teclado t = new Teclado();
        boolean existe = false;
        System.out.println("Introduce el nombre del nuevo cliente:");
        String nombre = t.leerString();
        System.out.println("Introduce la contraseña del nuevo cliente:");
        String contrasena = t.leerString();
        for (Cliente cliente : clientes) {
            if (cliente.nombre.equals(nombre)) {
                System.out.println("El nombre de usuario ya existe. Inténtalo de nuevo.");
                return;
            } else {
                existe = true;
            }
        }
        if (existe) {
            System.out.println("¿El cliente es preferente? (s/n)");
            String preferente = t.leerString();
            if (preferente.equalsIgnoreCase("s")) {
                clientes.add(new ClientePreferente(nombre, contrasena));
            } else {
                clientes.add(new Cliente(nombre, contrasena));
            }
        }
    }

    void listarClientes() {
        for (Cliente cliente : clientes) {
            cliente.mostrar();
        }
    }

    void menu() throws IOException {
        Teclado t = new Teclado();
        int opcion, opcion2;
        boolean admin = false;
        boolean encontrado = false;
        Cliente cliente = null;
        do {
            System.out.println("1. Administrador");
            System.out.println("2. Cliente");
            System.out.println("0. Salir");
            System.out.println("Elige una opción:");
            opcion2 = t.leerInt();
            switch (opcion2) {
                case 1 -> { //si es admin
                    System.out.println("Introduce un nombre de usuario de un administrador:");
                    String nombreAdmin = t.leerString(); //admin
                    System.out.println("Introduce la contraseña:");
                    String contrasenaAdmin = t.leerString(); //admin123
                    for (Cliente user : clientes) {
                        if (user.nombre.equals(nombreAdmin) && user.contrasena.equals(contrasenaAdmin)) {
                            admin = true;
                        } else {
                            System.out.println("Usuario no encontrado. Inténtalo de nuevo.");
                        }
                    }
                    if (admin) {
                        System.out.println("Acceso concedido. Bienvenido, " + nombreAdmin + ".");
                        do {
                            System.out.println("1. Añadir producto");
                            System.out.println("2. Listado de productos");
                            System.out.println("3. Listado de productos con menos de una semana para caducar");
                            System.out.println("3. Listado de productos con menos 5 unidades en stock");
                            System.out.println("5. Poner un producto en oferta");
                            System.out.println("6. Añadir cliente");
                            System.out.println("7. Listar clientes");
                            System.out.println("0. Salir");
                            System.out.println("Elige una opción:");
                            opcion = t.leerInt();
                            switch (opcion) {
                                case 1 -> anadirProducto();
                                case 2 -> listarProductos();
                                case 3 -> listarProductosAPuntoDeCaducar();
                                case 4 -> listarProductosConMenosDe5EnStock();
                                case 5 -> ponerProductoEnOferta();
                                case 6 -> anadirCliente();
                                case 7 -> listarClientes();
                                case 0 -> System.out.println("Saliendo...");
                                default -> System.out.println("Opción no válida.");
                            }
                        } while (opcion != 0);
                    }
                }
                case 2 -> { //si es user normal y no es admin
                    System.out.println("Introduce un nombre de usuario:");
                    String nombre = t.leerString();
                    System.out.println("Introduce la contraseña:");
                    String contrasena = t.leerString();
                    for (Cliente user : clientes) {
                        if (user.nombre.equals(nombre) && user.contrasena.equals(contrasena)) {
                            encontrado = true;
                            if (user.esClientePreferente()) {
                                cliente = new ClientePreferente(user.nombre, contrasena);
                                cliente.compras.addAll(user.compras);
                                cliente.carrito.addAll(user.carrito);
                                clientes.set(clientes.indexOf(user), cliente);

                            } else {
                                cliente = new Cliente(user.nombre, contrasena);
                                cliente.compras.addAll(user.compras);
                                cliente.carrito.addAll(user.carrito);
                                clientes.set(clientes.indexOf(user), cliente);
                            }
                        } else {
                            System.out.println("Usuario no encontrado. Inténtalo de nuevo.");
                        }
                    }
                    if (encontrado) {
                        System.out.println("Acceso concedido. Bienvenido, " + nombre + ".");
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
                                case 1 -> anadirProductoAlCarrito(cliente);
                                case 2 -> listarProductosCarrito(cliente);
                                case 3 -> comprarProductosCarrito(cliente);
                                case 4 -> listarComprasRealizadas(cliente);
                                case 5 -> listarProductos();
                                case 0 -> System.out.println("Saliendo...");
                                default -> System.out.println("Opción no válida.");
                            }
                        } while (opcion != 0);
                    }
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion2 != 0);
    }
}