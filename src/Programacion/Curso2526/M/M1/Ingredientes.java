package Programacion.Curso2526.M.M1;

import java.util.Objects;

public class Ingredientes {
    private String nombre;
    private double precio;

    public Ingredientes(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredientes that)) return false;
        return Double.compare(that.precio, precio) == 0
                && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio);
    }

    @Override
    public String toString() {
        return nombre + " (" + precio + " EUR)";
    }
}