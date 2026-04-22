package Programacion.Curso2526.M.M3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
        try (Connection con = conexion.getConexionBD()) {
            System.out.println("Conexion BD establecida");
            DAOPersonaImpl dao = new DAOPersonaImpl(con);
            ejecutarMenu(dao);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void ejecutarMenu(DAOPersonaImpl dao) throws IOException {
        Teclado teclado = new Teclado();
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Elige opcion: ");
            opcion = teclado.leerInt();

            switch (opcion) {
                case 1:
                    altaPersona(dao, teclado);
                    break;
                case 2:
                    bajaPersona(dao, teclado);
                    break;
                case 3:
                    modificarEdad(dao, teclado);
                    break;
                case 4:
                    listarPersonas(dao);
                    break;
                case 5:
                    mostrarMediaEdad(dao);
                    break;
                case 6:
                    listarPorRangoEdad(dao, teclado);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENU PERSONAS ---");
        System.out.println("1. Dar de alta personas");
        System.out.println("2. Dar de baja una persona");
        System.out.println("3. Modificar edad de una persona");
        System.out.println("4. Listado de todas las personas");
        System.out.println("5. Media de edad");
        System.out.println("6. Listar personas por rango de edad");
        System.out.println("0. Salir");
    }

    private static void altaPersona(DAOPersonaImpl dao, Teclado teclado) throws IOException {
        System.out.print("Nombre: ");
        String nombre = teclado.leerString();
        System.out.print("Edad: ");
        int edad = teclado.leerInt();

        boolean ok = dao.anadirPersona(new Persona(0, nombre, edad));
        System.out.println(ok ? "Persona anadida correctamente." : "No se pudo anadir la persona.");
    }

    private static void bajaPersona(DAOPersonaImpl dao, Teclado teclado) throws IOException {
        System.out.print("ID de la persona a borrar: ");
        int id = teclado.leerInt();

        boolean ok = dao.borrarPersona(id);
        System.out.println(ok ? "Persona borrada correctamente." : "No se pudo borrar la persona.");
    }

    private static void modificarEdad(DAOPersonaImpl dao, Teclado teclado) throws IOException {
        System.out.print("ID de la persona a modificar: ");
        int id = teclado.leerInt();

        Persona persona = dao.buscarPersona(id);
        if (persona == null) {
            System.out.println("No existe una persona con ese ID.");
            return;
        }

        System.out.print("Nueva edad: ");
        int nuevaEdad = teclado.leerInt();

        Persona actualizada = new Persona(persona.getId(), persona.getNombre(), nuevaEdad);
        boolean ok = dao.modificarPersona(id, actualizada);
        System.out.println(ok ? "Edad modificada correctamente." : "No se pudo modificar la edad.");
    }

    private static void listarPersonas(DAOPersonaImpl dao) {
        List<Persona> personas = dao.obtenerTodasPersonas();
        if (personas.isEmpty()) {
            System.out.println("No hay personas almacenadas.");
            return;
        }
        personas.forEach(System.out::println);
    }

    private static void mostrarMediaEdad(DAOPersonaImpl dao) {
        List<Persona> personas = dao.obtenerTodasPersonas();
        if (personas.isEmpty()) {
            System.out.println("No hay personas para calcular la media.");
            return;
        }

        double media = personas.stream().mapToInt(Persona::getEdad).average().orElse(0);
        System.out.println("Media de edad: " + media);
    }

    private static void listarPorRangoEdad(DAOPersonaImpl dao, Teclado teclado) throws IOException {
        System.out.print("Edad minima: ");
        int edadMin = teclado.leerInt();
        System.out.print("Edad maxima: ");
        int edadMax = teclado.leerInt();

        if (edadMin > edadMax) {
            System.out.println("El rango no es valido (minima mayor que maxima).");
            return;
        }

        List<Persona> personas = dao.obtenerPersonasPorRangoEdad(edadMin, edadMax);
        if (personas.isEmpty()) {
            System.out.println("No hay personas en ese rango de edad.");
            return;
        }
        personas.forEach(System.out::println);
    }
}