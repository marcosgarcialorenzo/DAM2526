package Programacion.Curso2526.J.J0;

import java.time.LocalDateTime;

public class ProductoCaducable extends Producto {
    LocalDateTime fechaCaducidad;

    public ProductoCaducable(String nombre, double precio, int cantidad, LocalDateTime fechaCaducidad) {
        super(nombre, precio, cantidad);
        this.fechaCaducidad = fechaCaducidad;
    }
}