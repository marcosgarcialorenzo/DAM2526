package Programacion.Curso2526.J.J1; /**
 * @author Jose Manuel Perez Lobato
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
    /* Seria mejor utilizar siempre un BufferedReader y readLine() pero para que sirva como ejemplo uso el System.in.read() aunque hay que tener precauci�n con el salto de l�nea (leerFinLinea) por que si no se pone: si meten blancos despues del numero no se eliminan si se pone: en Unix y justo despues del numero dan return tendre que dar otra vez al return
     */
/*int leerInt() throws IOException{
char c;
int numero=0;
  c= (char) System.in.read();
  while (c>='0' && c<='9'){
    numero=((int)c-(int)'0')+10*numero;
    c=(char) System.in.read();
  }
  leerFinLinea(c);
  return numero;
}*/
/*int leerInt() throws IOException {
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br= new BufferedReader(isr);
  String s=br.readLine();
  int i= Integer.parseInt(s);
  return (i);
}*/

    /**
     * Lee un caracter y elimina del buffer de teclado todos los que est�n en esa l�nea, incluido
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
     * Lee un n�mero entero de teclado y lo devuelve al invocador. Si lo le�do no es un n�mero entero repite la petici�n
     * hasta que se introduzca un n�mero entero v�lido.
     * Descarta el resto de la l�nea.
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
     * Lee un caracter de teclado y lo devuelve al invocador. Descarta el resto de la l�nea
     * vaciando el buffer.
     *
     * @return char
     * @throws IOException
     */
    char leerChar() throws IOException {
        char c;
        c = (char) System.in.read();
        //Si no se desea descartar el resto de la l�nea se deber�a eliminar la siguiente instrucci�n.
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
        String s = br.readLine();
        return (s);
    }

    /**
     * Lee un n�mero double de teclado y lo devuelve al invocador. Si lo le�do no es un n�mero real se producir�
     * una excepci�n de tipo  java.lang.NumberFormatException
     * Descarta el resto de la l�nea.
     *
     * @return double
     * @throws IOException
     * @throws NumberFormatException
     */
    double leerDouble() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        // La siguiente instrucci�n puede generar una excepci�n NumberFormatException.
        //Para evitarlo se puede hacer un tratamiento similar al realizado en leerInt
        double d = Double.valueOf(s).doubleValue();
        // tambien valdria double d= Double.parseDouble(s);
        return (d);
    }
}