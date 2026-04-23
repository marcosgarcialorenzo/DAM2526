package Programacion.Curso2526.M.M2.servivcio;

import Programacion.Curso2526.M.M2.DAO.DAOCocheImpl;
import Programacion.Curso2526.M.M2.modelo.Coche;
import Programacion.Curso2526.M.M3.DAOPersonaImpl;
import Programacion.Curso2526.M.M3.Teclado;

import java.io.IOException;

public class servicios {
    public static void mostrarMenu() {
        System.out.println("\n--- MENU PERSONAS ---");
        System.out.println("1. Insertar coches");
        System.out.println("2. Borrar coches");
        System.out.println("3. Incrementar el precio de todos los coches en un porcentaje dado por teclado");
        System.out.println("4. Listar coches");
        System.out.println("5. Sumar el precio de todos los coches que están en la BD con una determinada antigüedad");
        System.out.println("6. Listar las matrículas de los coches de una determinada marca");
        System.out.println("0. Salir");
    }

    private static void ejecutarMenu(DAOPersonaImpl dao) throws IOException {
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

                }
                default -> {
                    System.out.println("Opción no valida.");
                }
            }
        } while (opcion != 0);
    }

    private static void crearCoche(DAOCocheImpl dao) throws IOException {
        Teclado t = new Teclado();
        System.out.println("\n--- INSERTAR COCHE ---");
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
}