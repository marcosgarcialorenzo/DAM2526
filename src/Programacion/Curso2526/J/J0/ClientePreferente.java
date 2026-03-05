package Programacion.Curso2526.J.J0;

import java.util.Vector;

public class ClientePreferente extends Usuario {
    Vector<Integer> descuentos;
    Vector<Producto> compras;
    Vector<Producto> carrito;

    public ClientePreferente(String nombre, String contrasena) {
        super(nombre, contrasena);
        this.compras = new Vector<>(5, 5);
        this.carrito = new Vector<>(5, 5);
        this.descuentos = new Vector<>(5, 5);
    }
}