package Programacion.Curso2526.E.E8;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Teclado teclado = new Teclado();
        E8_BarajaEspañola baraja = new E8_BarajaEspañola();
        baraja.barajear(100);
        boolean finJuego = false;
        boolean finRonda = false;
        boolean J1Plantado = false;
        boolean J2Plantado = false;
        Boolean J1PlantadoForzado = false;
        Boolean J2PlantadoForzado = false;
        Carta[] manoJ1 = new Carta[15];
        Carta[] manoJ2 = new Carta[15];
        int numeroRondas = 1;
        double sumaJ1 = 0;
        double sumaJ2 = 0;
        int indiceManoJ1 = 0;
        int indiceManoJ2 = 0;
        do {
            finRonda = false;
            System.out.println("=== Ronda " + numeroRondas + " ===");
            System.out.println();
            System.out.println("Carta del jugador 1: ");
            manoJ1[indiceManoJ1] = baraja.repartirCarta();
            manoJ1[indiceManoJ1].mostrarCarta();
            System.out.println();
            System.out.println("Carta del jugador 2: ");
            manoJ2[indiceManoJ2] = baraja.repartirCarta();
            manoJ2[indiceManoJ2].mostrarCarta();
            System.out.println();
            do {
                for (int i = 0; i < manoJ1.length; i++) {
                    if (manoJ1[i] != null) {
                        double temporal = manoJ1[i].valorCarta(manoJ1[i]);
                        sumaJ1 = 0;
                        sumaJ1 += temporal;
                    }
                }
                if (sumaJ1 > 7.6) {
                    System.out.println("Jugador 1 se ha pasado");
                    finRonda = true;
                    J1PlantadoForzado = true;
                    J2PlantadoForzado = true;
                }
                int auxManoJ1 = 1;
                if (J1PlantadoForzado) {
                    J1Plantado = true;
                } else if (! J1Plantado) {
                    System.out.println("¿Jugador 1 se planta?: (s/n)");
                    String respuestaJ1;
                    respuestaJ1 = teclado.leerString();
                    if (respuestaJ1.equals("s")) {
                        J1Plantado = true;
                    } else if (respuestaJ1.equals("n")) {
                        System.out.println("Nueva carta del jugador 1: ");
                        manoJ1[auxManoJ1] = baraja.repartirCarta();
                        manoJ1[auxManoJ1].mostrarCarta();
                        auxManoJ1++;
                    }
                }
            } while (! J1Plantado);

            System.out.println("Suma final del jugador 1: " + sumaJ1);

            do {
                for (int i = 0; i < manoJ2.length; i++) {
                    if (manoJ2[i] != null) {
                        double temporal = manoJ2[i].valorCarta(manoJ2[i]);
                        sumaJ2 = 0;
                        sumaJ2+= temporal;
                    }
                }
                if (sumaJ2 > 7.6) {
                    System.out.println("Jugador 2 se ha pasado");
                    finRonda = true;
                    J1PlantadoForzado = true;
                    J2PlantadoForzado = true;
                }
                int auxManoJ2 = 1;
                if (J2PlantadoForzado) {
                    J2Plantado = true;
                } else if (! J2Plantado) {
                    System.out.println("¿Jugador 2 se planta?: (s/n)");
                    String respuestaJ2;
                    respuestaJ2 = teclado.leerString();
                    if (respuestaJ2.equals("s")) {
                        J2Plantado = true;
                    } else if (respuestaJ2.equals("n")) {
                        System.out.println("Nueva carta del jugador 2: ");
                        manoJ1[auxManoJ2] = baraja.repartirCarta();
                        manoJ1[auxManoJ2].mostrarCarta();
                        auxManoJ2++;
                    }
                }
            } while (! J2Plantado);

            System.out.println("Suma final del jugador 1: " + sumaJ2);

            if (J1Plantado && J2Plantado) {
                finRonda = true;
                numeroRondas++;
            }
            if (numeroRondas > 5) {
                finJuego = true;
            }
        } while (! finJuego && ! finRonda); // && = y lógico, || = o lógico
    }
}