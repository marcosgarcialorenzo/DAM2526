package Programacion.Curso2526.M.M2.servivcio;

import Programacion.Curso2526.M.M2.DAO.DAOCoche;
import Programacion.Curso2526.M.M2.DAO.DAOCocheImpl;
import Programacion.Curso2526.M.M2.modelo.Coche;
import Programacion.Curso2526.M.M3.DAOPersonaImpl;
import Programacion.Curso2526.M.M3.Teclado;

import javax.sound.midi.SoundbankResource;
import java.io.IOException;

public class servicios {
    static void mostrarMenu() {
        System.out.println("\n--- MENU PERSONAS ---");
        System.out.println("1. Insertar coches");
        System.out.println("2. Borrar coches");
        System.out.println("3. Incrementar el precio de todos los coches en un porcentaje dado por teclado");
        System.out.println("4. Listar coches");
        System.out.println("5. Sumar el precio de todos los coches que están en la BD con una determinada antigüedad");
        System.out.println("6. Listar las matrículas de los coches de una determinada marca");
        System.out.println("0. Salir");
    }

    public static void ejecutarMenu(DAOCocheImpl dao) throws IOException {
        Teclado t = new Teclado();
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            opcion = t.leerInt();
            switch (opcion) {
                case 0 -> {
                    System.out.println("Saliendo...");
                }
                case 1 -> {
                    crearCoche(dao);
                }
                case 2 -> {
                    pedirMatricula(dao);
                }
                case 3 -> {
                    crearCoche(dao);
                }
                case 4 -> {
                    crearCoche(dao);
                }
                case 5 -> {
                    crearCoche(dao);
                }
                case 6 -> {
                    crearCoche(dao);
                }
                default -> {
                    System.out.println("Opción no valida.");
                }
            }
        } while (opcion != 0);
    }

    private static void crearCoche(DAOCocheImpl dao) throws IOException {
        Teclado t = new Teclado();
        System.out.println("\n--- CREAR COCHE ---");
        System.out.println("Introduce la matrícula del coche:");
        String matricula = t.leerString();
        System.out.println("Introduce el modelo del coche: (E.g TOYOTA-YARIS)");
        String modelo = t.leerString();
        System.out.println("Introduce la antigüedad del coche:");
        int antiguedad = t.leerInt();
        System.out.println("Introduce el precio del coche:");
        double precio = t.leerDouble();
        Coche c1 = new Coche(matricula, modelo, antiguedad, precio);
        boolean ok = dao.insertarCoche(c1);
        System.out.println(ok ? "Coche añadido correctamente." : "No se pudo añadir el coche.");
    }

    private static void pedirMatricula(DAOCocheImpl dao) throws IOException {
        Teclado t = new Teclado();
        System.out.println("\n--- ELIMINAR COCHE ---");
        System.out.println("Introduce la matrícula del coche a eliminar:");
        String matricula = t.leerString();
        boolean ok = dao.eliminarCoche(matricula);
        System.out.println(ok ? "Coche eliminado correctamente." : "No se pudo eliminar el coche");
    }

    private static void pedirIncremento(DAOCocheImpl dao) throws IOException {
        Teclado t = new Teclado();
        System.out.println("\n--- INCREMENTAR PRECIO ---");
        System.out.println("Introduce el porcentaje de incremento (E.g 20%):");
        int porcentaje = t.leerInt();
        double incremento = 1 + (porcentaje / 100.0);
        boolean ok = dao.actualizarPreciosCoches(incremento);
        System.out.println(ok ? "Precios actualizados correctamente." : "No se pudieron actualizar los precios.");
    }
}