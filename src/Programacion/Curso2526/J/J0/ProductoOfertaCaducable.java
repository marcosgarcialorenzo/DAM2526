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

    @Override
    void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio oferta: " + precio + "€");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Fecha fin oferta: " + fechaFinOferta);
        System.out.println("Fecha caducidad: " + fechaCaducidad);
        System.out.println();
    }

    @Override
    boolean estaPorCaducar() {
        return fechaCaducidad.isBefore(LocalDateTime.now().plusDays(7));
    }
}