package Programacion.Curso2526.K.K1;

import java.io.IOException;
import java.util.Vector;

public class Empresa {
    Vector<Persona> empleados;

    Empresa() {
        empleados = new Vector<Persona>(30);
    }

    public static void main(String[] args) throws IOException {
        Empresa e = new Empresa();
        e.menu();
        Persona p1 = new Persona("Juan", 25);
        Persona p2 = new Persona("Pedro", 26);
        if (p1.equals(p2)) {
            System.out.println("Son iguales");
        }
    }

    void anadirEmpleado() throws IOException {
        boolean existe = false;
        Teclado t = new Teclado();
        System.out.println("Introducir nombre");
        String nombre = t.leerString();
        System.out.println("Introducir edad");
        int edad = t.leerInt();
        Persona p = new Persona(nombre, edad);
        if (empleados.contains(p)) {
            System.out.println("El empleado ya existe");
            existe = true;
        }
        if (existe) {
            empleados.add(p);
            System.out.println("Empleado añadido");
        }
    }

    void eliminarEmpleado() throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introducir nombre");
        String nombre = t.leerString();
        System.out.println("Introducir edad");
        int edad = t.leerInt();
        Persona p = new Persona(nombre, edad);
        while (empleados.contains(p)) {
            empleados.remove(p);
        }
        System.out.println("Empleado eliminado");
    }

    void modificarEdad() throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introducir nombre");
        String nombre = t.leerString();
        System.out.println("Introducir la edad antigua");
        int edadAntigua = t.leerInt();
        System.out.println("Introducir la nueva edad");
        int edadNueva = t.leerInt();
        Persona pBuscar = new Persona(nombre, edadAntigua);
        int indice = empleados.indexOf(pBuscar); //devuelve -1 si no lo encuentra
        if (indice != - 1) {
            empleados.get(indice).edad = edadNueva;
            System.out.println("Edad modificada");
        } else {
            System.out.println("El empleado no existe");
        }
    }

    void modificarNombre() throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introducir nombre antiguo");
        String nombreAntiguo = t.leerString();
        System.out.println("Introducir nombre nuevo");
        String nombreNuevo = t.leerString();
        System.out.println("Introducir la antigua edad");
        int edad = t.leerInt();
        Persona pAntigua = new Persona(nombreAntiguo, edad);
        Persona pNueva = new Persona(nombreNuevo, edad);
        if (empleados.contains(pAntigua)) {
            empleados.remove(pAntigua);
            empleados.add(pNueva);
            System.out.println("Nombre modificado");
        } else {
            System.out.println("El empleado no existe");
        }
    }

    void listarEmpleados() {
   /*     for(int i=0; i<empleados.size(); i++)
            System.out.println(empleados.elementAt(i));*/
        for (Persona miPers : empleados) {
            System.out.println(miPers);
        }
    }

    void menu() throws IOException {
        Teclado t = new Teclado();
        int opc = 0;
        System.out.println("1-Añadir empleado");
        System.out.println("2-Eliminar empleado");
        System.out.println("3-Modificar edad");
        System.out.println("4-Modificar Nombre");
        System.out.println("5-Listar empleados");
        System.out.println("6-listar ordenado por edad");
        do {
            System.out.println("Dar opc ");
            opc = t.leerInt();
            switch (opc) {
                case 1 -> anadirEmpleado();
                case 2 -> eliminarEmpleado();
                case 3 -> modificarEdad();
                case 4 -> modificarNombre();
                case 5 -> listarEmpleados();
                case 6 -> System.out.println("Falta implementar");
            }
        } while (opc != 0);
    }
}