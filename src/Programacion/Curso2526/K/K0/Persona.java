package Programacion.Curso2526.K.K0;

import java.util.Objects;

public class Persona {
    int edad;
    String nombre;

    Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + ", " + edad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Persona persona = (Persona) o;
        return this.nombre.equals(persona.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}