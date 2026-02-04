package Programacion.Curso2526.I.I4;

import java.io.*;

public class I4_LeerFichero {

    void leerFichero(String ruta) throws IOException {
        int sumaTotal = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    int numero = Integer.parseInt(linea);
                    sumaTotal += numero;
                } catch (NumberFormatException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println("Suma total de los números: " + sumaTotal);
    }

    public static void main(String[] args) throws IOException {
        String ruta = "src/Programacion/Curso2526/I/I4/f1datos.txt";
        I4_LeerFichero obj = new I4_LeerFichero();
        obj.leerFichero(ruta);
    }
}