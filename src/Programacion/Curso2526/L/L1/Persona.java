package Programacion.Curso2526.L.L1;

import java.util.Vector;

public class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public static void main(String[] args) {
        Vector<Persona> personas = new Vector<>(5, 3);
        personas.add(new Persona("Juanito", 18));
        personas.add(new Persona("Juan", 30));
        personas.add(new Persona("Maria", 25));
        personas.add(new Persona("Ana", 22));
        personas.add(new Persona("Pedro", 28));
        Persona obj = new Persona(null, 0);
        System.out.println("Orden original");
        obj.mostrar(personas);
        System.out.println("Ordenado por orden alfabético");
        obj.ordenarAlfabeticamenteAscendente(personas);
        obj.mostrar(personas);
        System.out.println("Ordenado por orden alfabético descendente");
        obj.ordenarAlfabeticamenteDescendente(personas);
        obj.mostrar(personas);
        System.out.println("Ordenado por edad");
        obj.ordenarPorEdadAscendente(personas);
        obj.mostrar(personas);
        System.out.println("Ordenado por edad descendente");
        obj.ordenarPorEdadDescendente(personas);
        obj.mostrar(personas);
    }

    void ordenarAlfabeticamenteAscendente(Vector<Persona> personas) {
        personas.sort((p1, p2) -> p1.nombre.compareTo(p2.nombre));
    }

    void mostrar(Vector<Persona> personas) {
        for (Persona p : personas) {
            System.out.println(p.nombre + " - " + p.edad);
        }
    }

    void ordenarAlfabeticamenteDescendente(Vector<Persona> personas) {
        personas.sort((p1, p2) -> p2.nombre.compareTo(p1.nombre));
    }

    void ordenarPorEdadAscendente(Vector<Persona> personas) {
        personas.sort((p1, p2) -> Integer.compare(p1.edad, p2.edad));
    }

    void ordenarPorEdadDescendente(Vector<Persona> personas) {
        personas.sort((p1, p2) -> Integer.compare(p2.edad, p1.edad));
    }
}