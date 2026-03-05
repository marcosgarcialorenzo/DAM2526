package Programacion.Curso2526.J.J0;

import java.time.LocalDate;

public class ProductoCaducable extends  Producto {
    LocalDate fechaCaducidad;

    public ProductoCaducable(String nombre, double precio, int cantidad, LocalDate fechaCaducidad) {
        super(nombre, precio, cantidad);
        this.fechaCaducidad = fechaCaducidad;
    }
}