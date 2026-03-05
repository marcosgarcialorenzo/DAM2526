package Programacion.Curso2526.J.J0;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductoOferta extends Producto {
    double precioOferta;
    LocalDateTime fechafinOferta;

    public ProductoOferta(String nombre, double precioOferta, LocalDateTime fechafinOferta, int cantidad) {
        super(nombre,0, cantidad);
        this.precioOferta = precioOferta;
        this.fechafinOferta = fechafinOferta;
    }
}
