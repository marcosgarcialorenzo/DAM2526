package Programacion.Curso2526.I.I6;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Programa de gestion de biblioteca");
        I6_Biblioteca biblioteca = new I6_Biblioteca("Mi Biblioteca");
        biblioteca.cargarLibros();
        biblioteca.menu();
    }
}