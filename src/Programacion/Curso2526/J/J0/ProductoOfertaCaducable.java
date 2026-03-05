package Programacion.Curso2526.J.J0;

import java.time.LocalDateTime;

public class ProductoOfertaCaducable extends Producto {
    double precioOferta;
    LocalDateTime fechafinOferta;
    LocalDateTime fechaCaducidad;

    public ProductoOfertaCaducable(String nombre, double precioOferta, int cantidad, LocalDateTime fechafinOferta, LocalDateTime fechaCaducidad) {
        super(nombre, 0, cantidad);
        this.precioOferta = precioOferta;
        this.fechafinOferta = fechafinOferta;
        this.fechaCaducidad = fechaCaducidad;
    }
}