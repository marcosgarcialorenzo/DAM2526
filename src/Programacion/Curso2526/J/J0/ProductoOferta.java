package Programacion.Curso2526.J.J0;

import java.time.LocalDateTime;

public class ProductoOferta extends Producto {
    double precioOferta;
    LocalDateTime fechaFinOferta;

    public ProductoOferta(String nombre, double precioOferta, int cantidad, LocalDateTime fechaFinOferta) {
        super(nombre, 0, cantidad);
        this.precioOferta = precioOferta;
        this.fechaFinOferta = fechaFinOferta;
    }
}
