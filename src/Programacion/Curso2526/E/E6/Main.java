package Programacion.Curso2526.E.E6;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Programa de gestión de reservas de asientos en un autobus.");
        E6_Autobus autobus = new E6_Autobus();
        autobus.menu();
    }
}