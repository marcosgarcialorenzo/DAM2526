package Programacion.Curso2526.E.E8;

public class E8_BarajaEspañola {
    Carta[] baraja;

    public E8_BarajaEspañola() {
        baraja = new Carta[40];
        String[] palos = {"Oros", "Copas", "Espadas", "Bastos"};
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
        int idx = 0;
        for (int i = 0; i < palos.length; i++) {
            for (int j = 0; j < numeros.length; j++) {
                baraja[idx++] = new Carta(palos[i], numeros[j]);
            }
        }
    }

    public Carta[] getBaraja() {
        return baraja;
    }

    public void barajear(int n) {
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * 40);
            int b = (int) (Math.random() * 40);
            Carta tmp = baraja[a];
            baraja[a] = baraja[b];
            baraja[b] = tmp;
        }
    }

    public Carta repartirCarta() {
        int numeroAleatorio = (int) (Math.random() * 40);
        if (baraja[numeroAleatorio] == null) {
            return repartirCarta();
        }
        else {
            Carta cartaRepartida = baraja[numeroAleatorio];
            baraja[numeroAleatorio] = null;
            return cartaRepartida;
        }
    }
}