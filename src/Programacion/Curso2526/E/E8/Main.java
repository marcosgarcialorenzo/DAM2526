package Programacion.Curso2526.E.E8;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Teclado teclado = new Teclado();
        E8_BarajaEspañola baraja = new E8_BarajaEspañola();
        baraja.barajear(100);

        boolean finJuego = false;
        int numeroRondas = 1;
        int rondasGanadasJ1 = 0;
        int rondasGanadasJ2 = 0;

        do {
            boolean finRonda = false;
            boolean J1Plantado = false;
            boolean J2Plantado = false;
            Boolean J1PlantadoForzado = false;
            Boolean J2PlantadoForzado = false;
            Carta[] manoJ1 = new Carta[15];
            Carta[] manoJ2 = new Carta[15];
            double sumaJ1 = 0;
            double sumaJ2 = 0;
            int indiceManoJ1 = 0;
            int indiceManoJ2 = 0;

            System.out.println("=== Ronda " + numeroRondas + " ===");
            System.out.println();

            System.out.println("Carta del jugador 1: ");
            manoJ1[indiceManoJ1] = baraja.repartirCarta();
            if (manoJ1[indiceManoJ1] == null) {
                finJuego = true;
            }
            manoJ1[indiceManoJ1].mostrarCarta();
            indiceManoJ1++;

            System.out.println();
            System.out.println("Carta del jugador 2: ");
            manoJ2[indiceManoJ2] = baraja.repartirCarta();
            if (manoJ2[indiceManoJ2] == null) {
                finJuego = true;
            }
            manoJ2[indiceManoJ2].mostrarCarta();
            indiceManoJ2++;

            System.out.println();

            do { // turno del jugador 1
                //comprobar J2
                sumaJ2 = 0;
                for (int i = 0; i < manoJ2.length; i++) {
                    if (manoJ2[i] != null) {
                        sumaJ2 += manoJ2[i].valorCarta(manoJ2[i]);
                    }
                }

                if (sumaJ2 > 7.6) {
                    System.out.println("Jugador 2 se ha pasado");
                    finRonda = true;
                    J2PlantadoForzado = true;
                    rondasGanadasJ1++;
                }

                sumaJ1 = 0;
                for (int i = 0; i < manoJ1.length; i++) {
                    if (manoJ1[i] != null) {
                        sumaJ1 += manoJ1[i].valorCarta(manoJ1[i]);
                    }
                }

                if (sumaJ1 > 7.6) {
                    System.out.println("Jugador 1 se ha pasado");
                    finRonda = true;
                    J1PlantadoForzado = true;
                    rondasGanadasJ2++;
                }

                if (J1PlantadoForzado) {
                    J1Plantado = true;
                } else if (! J1Plantado) {
                    System.out.println("¿Jugador 1 se planta?: (s/n)");
                    String respuestaJ1 = teclado.leerString();
                    if (respuestaJ1.equals("s")) {
                        J1Plantado = true;
                    } else if (respuestaJ1.equals("n")) {
                        System.out.println("Nueva carta del jugador 1: ");
                        manoJ1[indiceManoJ1] = baraja.repartirCarta();
                        if (manoJ1[indiceManoJ1] == null) {
                            finJuego = true;
                        }
                        manoJ1[indiceManoJ1].mostrarCarta();
                        indiceManoJ1++;
                    }
                }
            } while (! J1Plantado && ! finJuego);

            System.out.println("Suma final del jugador 1: " + sumaJ1);

            if (finJuego || finRonda) {

            } else {
                // turno jugador 2
                do {
                    sumaJ2 = 0;
                    for (int i = 0; i < manoJ2.length; i++) {
                        if (manoJ2[i] != null) {
                            sumaJ2 += manoJ2[i].valorCarta(manoJ2[i]);
                        }
                    }

                    if (sumaJ2 > 7.6) {
                        System.out.println("Jugador 2 se ha pasado");
                        finRonda = true;
                        J2PlantadoForzado = true;
                    }

                    if (J2PlantadoForzado) {
                        J2Plantado = true;
                    } else if (! J2Plantado) {
                        System.out.println("¿Jugador 2 se planta?: (s/n)");
                        String respuestaJ2 = teclado.leerString();
                        if (respuestaJ2.equals("s")) {
                            J2Plantado = true;
                        } else if (respuestaJ2.equals("n")) {
                            System.out.println("Nueva carta del jugador 2: ");
                            manoJ2[indiceManoJ2] = baraja.repartirCarta();
                            if (manoJ2[indiceManoJ2] == null) {
                                finJuego = true;
                            }
                            manoJ2[indiceManoJ2].mostrarCarta();
                            indiceManoJ2++;
                        }
                    }
                } while (! J2Plantado && ! finJuego);
            }

            System.out.println("Suma final del jugador 2: " + sumaJ2);

            if ((J1Plantado || J1PlantadoForzado) && (J2Plantado || J2PlantadoForzado)) {
                finRonda = true;
                numeroRondas++;
            }

            if (numeroRondas > 5) {
                finJuego = true;
            }
            if (sumaJ1 > 7.6) {
                System.out.println("Jugador 2 gana la ronda.");
            } else if (sumaJ2 > 7.6) {
                System.out.println("Jugador 1 gana la ronda.");
            } else if (sumaJ1 > sumaJ2) {
                System.out.println("Jugador 1 gana la ronda.");
                rondasGanadasJ1++;
            } else if (sumaJ2 >= sumaJ1) { // en caso de empate gana el jugador 2
                System.out.println("Jugador 2 gana la ronda.");
                rondasGanadasJ2++;
            }
        } while (! finJuego);

        if (rondasGanadasJ1 > rondasGanadasJ2) {
            System.out.println("Jugador 1 gana el juego con " + rondasGanadasJ1 + " rondas ganadas.");
        } else if (rondasGanadasJ2 > rondasGanadasJ1) {
            System.out.println("Jugador 2 gana el juego con " + rondasGanadasJ2 + " rondas ganadas.");
        }
        System.out.println("Fin del juego.");
    }
}