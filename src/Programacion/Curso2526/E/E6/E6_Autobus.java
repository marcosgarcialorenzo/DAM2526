package Programacion.Curso2526.E.E6;

import Programacion.Curso2526.E.E4.Teclado;
import java.io.IOException;

public class E6_Autobus {
    Cliente asientos[][];

    public E6_Autobus() {
        asientos = new Cliente[14][4];
    }

    void reservarAsiento() throws IOException {
        System.out.println("Escriba el nombre del cliente:");
        Teclado t = new Teclado();
        String nombre = t.leerString();
        Cliente cliente = new Cliente(nombre);
        System.out.println("Escriba la fila del asiento (1-14):");
        int fila = t.leerInt() - 1;
        System.out.println("Escriba la columna del asiento (1-4):");
        int columna = t.leerInt() - 1;
        if (asientos[fila][columna] == null) {
            asientos[fila][columna] = cliente;
            System.out.println("Asiento reservado para " + nombre);
        } else {
            System.out.println("El asiento ya está reservado.");
        }
    }

    void reservar2Asientos() throws IOException {
        System.out.println("Escriba el nombre del cliente:");
        Teclado t = new Teclado();
        String nombre = t.leerString();
        Cliente cliente = new Cliente(nombre);
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length - 1; j++) {
                if (asientos[i][j] == null && asientos[i][j + 1] == null) {
                    asientos[i][j] = cliente;
                    asientos[i][j + 1] = cliente;
                    System.out.println("Asientos reservados para " + nombre + " en fila " + (i + 1) + " columnas " + (j + 1) + " y " + (j + 2));
                    return;
                } else {
                    System.out.println("Buscando asientos....");
                }
            }
        }
    }

    void cancelarReserva() throws IOException {
        System.out.println("Escriba la fila del asiento (1-14):");
        Teclado t = new Teclado();
        int fila = t.leerInt() - 1;
        System.out.println("Escriba la columna del asiento (1-4):");
        int columna = t.leerInt() - 1;
        if (asientos[fila][columna] != null) {
            System.out.println("Escriba el nombre del cliente para confirmar la cancelación:");
            String nombre = t.leerString();
            if (asientos[fila][columna].nombre.equals(nombre)) {
                asientos[fila][columna] = null;
                System.out.println("Reserva cancelada para " + nombre);
            } else {
                System.out.println("El nombre del cliente no concuerda con la reserva.");
            }
        } else {
            System.out.println("El asiento no está reservado.");
        }
    }

    void mostrarReservas() {
        System.out.println("Estado de las reservas:");
        for (int i = 0; i < asientos.length; i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            for (int j = 0; j < asientos[i].length; j++) {
                if (asientos[i][j] == null) {
                    System.out.print("[Libre] ");
                } else {
                    System.out.print("[" + asientos[i][j].nombre + "] ");
                }
            }
            System.out.println();
        }
    }

    void menu() throws IOException {
        Teclado t = new Teclado();
        int opcion;
        do {
            System.out.println("1. Reservar un asiento");
            System.out.println("2. Reservar dos asientos juntos");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Mostrar reservas");
            System.out.println("0. Salir");
            System.out.println("Elige una opción:");
            opcion = t.leerInt();
            switch (opcion) {
                case 1 -> reservarAsiento();
                case 2 -> reservar2Asientos();
                case 3 -> cancelarReserva();
                case 4 -> mostrarReservas();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}