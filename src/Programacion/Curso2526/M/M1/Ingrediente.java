package Programacion.Curso2526.M.M1;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Ingrediente {
    private String nombre;
    private double precio;

    public Ingrediente(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingrediente that)) return false;
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