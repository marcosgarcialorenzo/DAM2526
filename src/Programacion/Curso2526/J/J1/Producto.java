package Programacion.Curso2526.J.J1;

public class Producto {
    String nombre;
    double precio;
    int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio + "€");
        System.out.println("Cantidad: " + cantidad);
        System.out.println();
    }

    boolean estaPorCaducar() {
        return false;
    }

    boolean caducable() {
        return false;
    }

    boolean enOferta() {
        return false;
    }
}