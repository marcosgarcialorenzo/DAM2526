package Programacion.Curso2526.E.E9;

public class Bebidas {
    String nombre;
    double precio;
    int cantidad;

    public Bebidas(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void mostrar() {
        System.out.println("Bebida: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad);
    }
}