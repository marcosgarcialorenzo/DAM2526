package Programacion.Curso2526.G.G1;

import java.io.IOException;

public class G1_LeerNumero {
    public int leerNumero() {
        Teclado t = new Teclado();
        while (true) {
            System.out.println("Introduzca un número entero:");
            try {
                String texto = t.leerString(); // asi para que pueda leer todo y lo convierta a entero
                return Integer.parseInt(texto);
            } catch (NumberFormatException numeroNoValido) {
                System.err.println("Debe dar un número entero válido.");
            } catch (IOException errorTeclado) {
                System.err.println("Error de entrada/salida");
            }
        }
    }

    public static  void main(String[] args) {
        G1_LeerNumero G1 = new G1_LeerNumero();
        int numero = G1.leerNumero();
        System.out.println("El número introducido es: " + numero);
    }
}