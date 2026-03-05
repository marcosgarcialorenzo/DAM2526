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

    @Override
    void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio oferta: " + precio + "€");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Fecha fin oferta: " + fechaFinOferta);
        System.out.println();
    }

    @Override
    boolean enOferta() {
        return true;
    }
}