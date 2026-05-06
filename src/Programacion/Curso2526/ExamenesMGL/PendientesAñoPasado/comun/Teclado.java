package Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.comun; /**
 *
 * @author Jose Manuel Perez Lobato
 * @version 1.0
 *
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

    void leerFinLinea(char c) throws IOException {
        while (c != '\n') {
            c = (char) System.in.read();
        }
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

    char leerChar() throws IOException {
        char c;
        c = (char) System.in.read();
        leerFinLinea(c);
        return (c);
    }

    public String leerString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return (s);
    }

    public double leerDouble() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        double d = Double.valueOf(s).doubleValue();
        // tambien valdria double d= Double.parseDouble(s);
        return (d);
    }
}