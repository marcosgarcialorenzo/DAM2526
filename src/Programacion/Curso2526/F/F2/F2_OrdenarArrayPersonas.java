package Programacion.Curso2526.F.F2;

import java.util.Arrays;

public class F2_OrdenarArrayPersonas {
    public static void ordenarBurbujaDescendente(String[] nombres) {
        for (int i = 0; i < nombres.length - 1; i++) {
            for (int j = 0; j < nombres.length - 1 - i; j++) {
                if (nombres[j].compareToIgnoreCase(nombres[j + 1]) < 0) {
                    String aux = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = aux;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] nombres = {"ana", "Luis", "María", "pepe", "Óscar", "beatriz"};
        System.out.println("Antes: " + Arrays.toString(nombres));
        ordenarBurbujaDescendente(nombres);
        System.out.println("Después: " + Arrays.toString(nombres));
    }
}