package Programacion.Curso2526.F.F2;

import java.io.IOException;

public class F2_OrdenarArrayPersonas {
    public static void ordenarBurbujaDescendente(String[] nombres) {
        if (nombres == null) {
            return;
        }
        int n = nombres.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nombres[j].compareToIgnoreCase(nombres[j + 1]) < 0) {
                    String aux = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = aux;
                }
            }
        }
    }

    static void main() throws IOException {
        Teclado t = new Teclado();
        System.out.println("Ingresa el total de nombres...");
        int numNombres = t.leerInt();
        String[] nombres = new String[numNombres];
        for (int i = 0; i < numNombres; i++) {
            System.out.print("Ingresa el nombre " + (i + 1) + ": ");
            nombres[i] = t.leerString();
        }

        ordenarBurbujaDescendente(nombres);

        System.out.println("Nombres ordenados...");
        for (int i = 0; i < numNombres; i++) {
            System.out.println("- " + nombres[i]);
        }
    }
}