// AUTOR MARCOS GRACIA LORENZO
package Programacion.Curso2526.ExamenesMGL.Evaluacion1.Ej1;

public class Jugador {
    String nombre;
    int puntuacion;

    Jugador(String n, int p) {
        nombre = n;
        puntuacion = p;
    }

    void tirada(Jugador j) {
        int dado1, dado2, dado3, dado4;
        int dadoJugador1Mayor, dadoJugador2Mayor, dadoJugador1Menor, dadoJugador2Menor;
        dado1 = (int) (Math.random() * 7); // (int) (Math.random() * 6) + 1;
        dado2 = (int) (Math.random() * 7); // esto saca numeros del 0 al 6
        dado3 = (int) (Math.random() * 7);
        dado4 = (int) (Math.random() * 7);
        if (dado1 == 0) {
            dado1 += 1;
        }
        if (dado2 == 0) {
            dado2 += 1;
        }
        if (dado3 == 0) {
            dado3 += 1;
        }
        if (dado4 == 0) {
            dado4 += 1;
        }
        if (dado1 > dado2) {
            dadoJugador1Mayor = dado1;
            dadoJugador1Menor = dado2;
        } else {
            dadoJugador1Mayor = dado2;
            dadoJugador1Menor = dado1;
        }
        if (dado3 > dado4) {
            dadoJugador2Mayor = dado3;
            dadoJugador2Menor = dado4;
        } else {
            dadoJugador2Mayor = dado4;
            dadoJugador2Menor = dado3;
        }
        if (dadoJugador1Mayor > dadoJugador2Mayor) {
            this.puntuacion += 1;
        } else if (dadoJugador1Mayor == dadoJugador2Mayor) {
            this.puntuacion += 1;
        } else {
            j.puntuacion += 1;
        }
        if (dadoJugador1Menor > dadoJugador2Menor) {
            this.puntuacion += 1;

        } else if (dadoJugador1Menor == dadoJugador2Menor) {
            this.puntuacion += 1;
        } else {
            j.puntuacion += 1;
        }
    }

    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Juan", 0);
        Jugador jugador2 = new Jugador("Ana", 0);

        while (jugador1.puntuacion < 10 && jugador2.puntuacion < 10) {
            jugador1.tirada(jugador2);
            jugador2.tirada(jugador1);
        }
        if (jugador1.puntuacion >= 10) {
            System.out.println("El ganador es " + jugador1.nombre + " con " + jugador1.puntuacion);
            System.out.println(jugador2.nombre + " ha terminado con " + jugador2.puntuacion);
        } else {
            System.out.println("El ganador es " + jugador2.nombre + " con " + jugador2.puntuacion);
            System.out.println(jugador1.nombre + " ha terminado con " + jugador1.puntuacion);
        }
    }
}