package Programacion.Curso2526.H.H2;

import java.io.IOException;

public class H2_LeerNumsYDevolverNums {
    int atrpos = 1;

    int procesarnums() throws IOException {
        Teclado t = new Teclado();
        int n;
        System.out.println("Dar un número: (0 para terminar)");
        n = t.leerInt();
        if (n == 0) {
            return 0;
        } else {
            int contador = procesarnums();
            System.out.println(n);
            return contador + 1;
        }
    }

    public static void main(String arg[]) throws IOException {
        H2_LeerNumsYDevolverNums f = new H2_LeerNumsYDevolverNums();
        int total = f.procesarnums();
        System.out.println("Se han leído " + total + " números");
        System.out.println("Fin");
    }
}