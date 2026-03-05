package Programacion.Curso2526.J.J0;

import java.time.LocalDateTime;

public class ProductoCaducable extends Producto {
    LocalDateTime fechaCaducidad;

    public ProductoCaducable(String nombre, double precio, int cantidad, LocalDateTime fechaCaducidad) {
        super(nombre, precio, cantidad);
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio + "€");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Fecha caducidad: " + fechaCaducidad);
        System.out.println();
    }

    @Override
    boolean estaPorCaducar() {
        return fechaCaducidad.isBefore(LocalDateTime.now().plusDays(7));
    }

    @Override
    boolean caducable() {
        return true;
    }
}