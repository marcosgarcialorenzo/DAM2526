package Programacion.Curso2526.J.J0;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductoOfertaCaducable extends Producto {
    double precioOferta;
    LocalDateTime finOferta;
    LocalDate fechaCaducidad;

    public ProductoOfertaCaducable(String nombre, double precioOferta, int cantidad, LocalDateTime finOferta, LocalDate fechaCaducidad) {
        super(nombre, 0, cantidad);
        this.precioOferta = precioOferta;
        this.finOferta = finOferta;
        this.fechaCaducidad = fechaCaducidad;
    }
}