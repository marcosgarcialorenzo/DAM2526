package Programacion.Curso2526.J.J0;

import java.util.Vector;

public class Cliente {
    String nombre;
    String contrasena;
    Vector<Producto> compras;
    Vector<Producto> carrito;

    public Cliente(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.compras = new Vector<>(5, 5);
        this.carrito = new Vector<>(5, 5);
    }

    boolean esClientePreferente() {
        return false;
    }

    void mostrar() {
        System.out.println("Nombre de usuario: " + this.nombre);
        System.out.println("Contraseña: " + this.contrasena);
        System.out.println("No es cliente preferente");
        System.out.println();
    }
}