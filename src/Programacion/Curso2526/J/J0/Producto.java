package Programacion.Curso2526.J.J0;

import javax.sound.midi.SoundbankResource;

public class Producto {
    String nombre;
    double precio;
    int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio + "€");
        System.out.println("Cantidad: " + cantidad);
        System.out.println();
    }
}