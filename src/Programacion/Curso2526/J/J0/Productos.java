package Programacion.Curso2526.J.J0;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Productos {
    double precio;
    double precioOferta;
    LocalDateTime finOferta;
    int cantidad;
    boolean caducable;
    LocalDate fechaCaducidad;

    public Productos(double precio, double precioOferta, LocalDateTime finOferta, int cantidad, boolean caducable, LocalDate fechaCaducidad) {
        if (caducable) {
            this.precio = precio;
            this.precioOferta = precioOferta;
            this.finOferta = finOferta;
            this.cantidad = cantidad;
            this.caducable = caducable;
            this.fechaCaducidad = fechaCaducidad;
        }
        else  {
            this.precio = precio;
            this.precioOferta = precioOferta;
            this.finOferta = finOferta;
            this.cantidad = cantidad;
        }
    }
}