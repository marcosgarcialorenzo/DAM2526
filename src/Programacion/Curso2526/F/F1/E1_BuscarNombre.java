package Programacion.Curso2526.F.F1;

import java.io.IOException;

public class E1_BuscarNombre {
    public static void main(String[] args) throws IOException {
        Teclado t = new Teclado();
        E1_BuscarNombre obj = new E1_BuscarNombre();
        String n2;
        String Fin = "Fin";
        String[] ni;
        int x;
        ni = new String[10];
        for (int i = 0; i < ni.length; i++) {
            System.out.println("Dame el nombre de diez personas: ");
            ni[i] = t.leerString();
        }
        do {
            System.out.println("Dame un nombre que coincida: ");
            n2 = t.leerString();
            x = n2.compareToIgnoreCase(Fin);
            boolean y = obj.nombreEncontrado(ni, n2);
            if (x != 0)
                if (! y)
                    System.out.println("No ha sido introducido");
                else System.out.println("Encontrado");
        } while (x != 0);
    }

    boolean nombreEncontrado(String[] datos, String nombre) {
        boolean encontrado = false;
        int x = 0;
        int y = 0;
        for (int i = 0; i < datos.length && ! encontrado; i++) {
            y = nombre.compareTo(datos[i]);
            if (y == 0)
                encontrado = true;
        }
        return encontrado;
    }
}