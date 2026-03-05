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
}