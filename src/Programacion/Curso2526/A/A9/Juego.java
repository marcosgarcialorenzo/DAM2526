package Programacion.Curso2526.A.A9;

import Programacion.Curso2526.A.A5_Punto;

import java.io.IOException;

public class Juego {
    public static void main(String[] args) throws IOException {
        // Crear armas
        Arma espada = new Arma("Espada", 50.0);
        Arma arco = new Arma("Arco", 20.0);
        Arma escudo = new Arma("Escudo", 5.0);
        Arma daga = new Arma("Daga", 8.0);

        // Crear posiciones
        A5_Punto posicion1 = new A5_Punto(0, 0);
        A5_Punto posicion2 = new A5_Punto(10, 5);


        // Crear personajes
        Personaje p1 = new Personaje("Guerrero", 0, 0, 100.0, 30.0, espada, escudo);
        Personaje p2 = new Personaje("Arquero", 10, 5, 100.0, 25.0, arco, null);

        System.out.println("Estado inicial de los personajes:");
        p1.mostrarEstado();

        System.out.println("\nProbando cambiarArma en p1 (tiene dos armas):");
        p1.cambiarArma(escudo);
        p1.mostrarEstado();

        System.out.println("\nProbando cambiarArma en p2 (solo tiene una arma):");
        p2.cambiarArma(daga);
        p2.mostrarEstado();

        // Mover personajes    SIGUE SIN IR
        p2.mostrarEstado();
        p2.moverX(-10);
        p2.moverY(1);
        p2.mostrarEstado();

    }
}

