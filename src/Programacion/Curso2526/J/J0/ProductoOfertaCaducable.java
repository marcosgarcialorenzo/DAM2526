package Programacion.Curso2526.J.J0;

import java.time.LocalDateTime;

public class ProductoOfertaCaducable extends Producto {
    double precioOferta;
    LocalDateTime fechaFinOferta;
    LocalDateTime fechaCaducidad;

    public ProductoOfertaCaducable(String nombre, double precioOferta, int cantidad, LocalDateTime fechaFinOferta, LocalDateTime fechaCaducidad) {
        super(nombre, 0, cantidad);
        this.precioOferta = precioOferta;
        this.fechaFinOferta = fechaFinOferta;
        this.fechaCaducidad = fechaCaducidad;
    }
}