package Programacion.Curso2526.K.K0;

import java.io.IOException;
import java.util.Vector;

public class Empresa {
    Vector<Persona> empleados;

    Empresa() {
        empleados = new Vector<>(30);
    }

    static void main() throws IOException {
        Empresa e = new Empresa();
        e.menu();
    }

    void anadirEmpleado() throws IOException {
        boolean existe = false;
        Teclado t = new Teclado();
        System.out.println("Introducir nombre: ");
        String nombre = t.leerString();
        System.out.println("Introducir edad: ");
        int edad = t.leerInt();
        Persona p = new Persona(nombre, edad);
        if (empleados.contains(p)) {
            System.out.println();
            System.out.println("El empleado ya existe");
            System.out.println();
            existe = true;
        }
        if (! existe) { // si es false
            empleados.add(p);
            System.out.println();
            System.out.println("Empleado añadido");
            System.out.println();
        }
    }

    void eliminarEmpleado() throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introducir nombre: ");
        String nombre = t.leerString();
        System.out.println("Introducir edad: ");
        int edad = t.leerInt();
        Persona p = new Persona(nombre, edad);
        while (empleados.contains(p)) {
            empleados.remove(p);
        }
        System.out.println();
        System.out.println("Empleado eliminado");
        System.out.println();
    }

    void modificarEdad() throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introducir nombre: ");
        String nombre = t.leerString();
        System.out.println("Introducir la edad antigua: ");
        int edadAntigua = t.leerInt();
        System.out.println("Introducir la nueva edad: ");
        int edadNueva = t.leerInt();
        Persona pBuscar = new Persona(nombre, edadAntigua);
        int indice = empleados.indexOf(pBuscar); //devuelve -1 si no lo encuentra
        if (indice != - 1) {
            empleados.get(indice).edad = edadNueva;
            System.out.println();
            System.out.println("Edad modificada");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("El empleado no existe");
            System.out.println();
        }
    }

    void modificarNombre() throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introducir nombre antiguo: ");
        String nombreAntiguo = t.leerString();
        System.out.println("Introducir nombre nuevo: ");
        String nombreNuevo = t.leerString();
        System.out.println("Introducir la antigua edad: ");
        int edad = t.leerInt();
        Persona pAntigua = new Persona(nombreAntiguo, edad);
        Persona pNueva = new Persona(nombreNuevo, edad);
        if (empleados.contains(pAntigua)) {
            empleados.remove(pAntigua);
            empleados.add(pNueva);
            System.out.println();
            System.out.println("Nombre modificado");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("El empleado no existe");
            System.out.println();
        }
    }

    void listarEmpleados() {
        /*for (int i = 0; i < empleados.size(); i++) {
            System.out.println(empleados.elementAt(i));
        }*/
        System.out.println("Listado de empleados:");
        for (Persona persona : empleados) {
            System.out.println(persona);
        }
    }

    void listarEmpleadosPorEdad() {
        System.out.println("Listado de empleados:"); // de menor a mayor edad
        empleados.sort((p1, p2) -> Integer.compare(p1.edad, p2.edad)); //expresión lambda (parámetros) → {cuerpo}
        for (Persona persona : empleados) {
            System.out.println(persona);
        }
    }

    void listarEmpleadosPorNombre() {
        System.out.println("Listado de empleados:");
        empleados.sort((p1, p2) -> p1.nombre.compareTo(p2.nombre)); //expresión lambda (parámetros) → {cuerpo}
        for (Persona persona : empleados) {
            System.out.println(persona);
        }
    }

    void menu() throws IOException {
        Teclado t = new Teclado();
        int opc;
        System.out.println("1-Añadir empleado");
        System.out.println("2-Eliminar empleado");
        System.out.println("3-Modificar edad");
        System.out.println("4-Modificar Nombre");
        System.out.println("5-Listar empleados");
        System.out.println("6-listar ordenado por edad");
        System.out.println("7-listar ordenado por nombre");
        System.out.println("0-Salir");
        do {
            System.out.print("Dar opción: ");
            opc = t.leerInt();
            switch (opc) {
                case 1 -> anadirEmpleado();
                case 2 -> eliminarEmpleado();
                case 3 -> modificarEdad();
                case 4 -> modificarNombre();
                case 5 -> listarEmpleados();
                case 6 -> listarEmpleadosPorEdad();
                case 7 -> listarEmpleadosPorNombre();
            }
        } while (opc != 0);
    }
}