package Programacion.Curso2526.M.M3; /*
  @author Jose Manuel Perez Lobato
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado {
    public static void main(String[] args) throws IOException {

        Teclado t = new Teclado();

        System.out.println("Dar char");
        char c = t.leerChar();
        System.out.println("Char:" + c + ":");
        System.out.println("Dar int");
        int numero = t.leerInt();
        System.out.println("Int:" + numero + ":");
        System.out.println("Dar double");
        double d = t.leerDouble();
        System.out.println("Double:" + d + ":");
        System.out.println("Dar String");
        String s = t.leerString();
        System.out.println("String:" + s + ":");
    }
    /* Sería mejor utilizar siempre un BufferedReader y readLine() pero para que sirva como ejemplo uso el System.in.read() aunque hay que tener precaución con el salto de l�nea (leerFinLinea) por qué si no se pone: si meten blancos después del número no se eliminan si se pone: en Unix y justo después del número dan return tendré que dar otra vez al return
     */

    /**
     * Lee un carácter y elimina del buffer de teclado todos los que est�n en esa l�nea, incluido
     * el final de la l�nea.
     *
     * @throws IOException
     */
    void leerFinLinea() throws IOException {
        char c = ' ';
        while (c != '\n') {
            c = (char) System.in.read();
        }
    }

    /**
     * Lee un n�mero entero de teclado y lo devuelve al invocador. Si lo le�do no es un n�mero entero repite la petición
     * hasta que se introduzca un número entero válido.
     * Descarta el resto de la línea.
     *
     * @return int
     * @throws IOException
     */
    public int leerInt() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s;
        boolean fin = false;
        int i = 0;
        do {
            s = br.readLine();
            try {
                i = Integer.parseInt(s);
                fin = true;
            } catch (NumberFormatException e) {
            }
        } while (! fin);
        return (i);
    }

    /**
     * Lee un carácter de teclado y lo devuelve al invocador. Descarta el resto de la l�nea
     * vaciando el buffer.
     *
     * @return char
     * @throws IOException
     */
    char leerChar() throws IOException {
        char c;
        c = (char) System.in.read();
        //Si no se desea descartar el resto de la l�nea se deber�a eliminar la siguiente instrucción.
        leerFinLinea();
        return (c);
    }

    /**
     * Lee una l�nea de texto de teclado y la devuelve al invocador.
     *
     * @return String
     * @throws IOException
     */
    public String leerString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return (br.readLine());
    }

    /**
     * Lee un n�mero double de teclado y lo devuelve al invocador. Si lo le�do no es un n�mero real se producir�
     * una excepción de tipo java.lang.NumberFormatException
     * Descarta el resto de la l�nea.
     *
     * @return double
     * @throws IOException
     * @throws NumberFormatException
     */
    public double leerDouble() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        // La siguiente instrucción puede generar una excepción NumberFormatException.
        //Para evitarlo se puede hacer un tratamiento similar al realizado en leerInt
        // también valdría double d= Double.parseDouble(s);
        return (Double.valueOf(s).doubleValue());
    }
}