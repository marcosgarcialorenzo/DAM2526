package Programacion.Curso2526.J.J0;

import java.util.Vector;

public class Clientes {
    String nombre;
    String contraseña;
    boolean preferente;
    Vector<Productos> compras;
    Vector<Productos> carrito;

    public Clientes(String nombre, String contraseña, boolean preferente) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.preferente = preferente;
        this.compras = new Vector<>(5,5);
        this.carrito = new Vector<>(5,5);
    }
}