package Programacion.Curso2526.E.E4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Programa de gesti��n de biblioteca");
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca");
        biblioteca.menu();
    }
}