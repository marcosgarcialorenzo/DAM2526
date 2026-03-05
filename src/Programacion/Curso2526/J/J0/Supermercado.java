package Programacion.Curso2526.J.J0;

import Programacion.Curso2526.E.E4.Teclado;

import java.io.IOException;
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
                    case 1 -> altaLibros();
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