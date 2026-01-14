package Programacion.Curso2526.E.E8;

public class Carta {
    String palo;
    int numero;

    public Carta(String palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public void mostrarCarta() {
        System.out.println(numero + " de " + palo);
    }

    @Override
    public String toString() {
        return numero + " de " + palo;
    }
    public double valorCarta(Carta carta) {
        int numero = carta.numero;
        return switch (numero) {
            case 10, 11, 12 -> 0.5;
            case 1 -> 1.0;
            case 2 -> 2.0;
            case 3 -> 3.0;
            case 4 -> 4.0;
            case 5 -> 5.0;
            case 6 -> 6.0;
            case 7 -> 7.0;
            default -> 0.0;
        };
    }
}