package Programacion.Curso2526.J.J0;

import java.util.Vector;

public class ClienteNormal extends Usuario {
    Vector<Producto> compras;
    Vector<Producto> carrito;

    public ClienteNormal(String nombre, String contrasena) {
        super(nombre, contrasena);
        this.compras = new Vector<>(5, 5);
        this.carrito = new Vector<>(5, 5);
    }
}