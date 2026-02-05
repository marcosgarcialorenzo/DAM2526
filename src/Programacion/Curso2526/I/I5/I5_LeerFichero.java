package Programacion.Curso2526.I.I5;

import java.io.*;

public class I5_LeerFichero {

    void leerFichero(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            double mejorMedia = 0;
            br.readLine(); // lee la primera linea y la salta
            String nombreAlumno = "";
            double sumaClase = 0;
            int contadorClase = 0;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                double sumaAlumno = 0;
                int contadorNotas = 0;
                for (int i = 1; i < partes.length; i++) {
                    if (! partes[i].isEmpty()) {
                        sumaAlumno += Double.parseDouble(partes[i]);
                        contadorNotas++;
                    }
                }
                contadorClase++;
                double mediaAlumno = sumaAlumno / contadorNotas;
                sumaClase += mediaAlumno;
                if (mediaAlumno > mejorMedia) {
                    mejorMedia = mediaAlumno;
                    nombreAlumno = partes[0];
                }
            }
            sumaClase = sumaClase / contadorClase;
            System.out.println("La media de la clase es " + sumaClase);
            System.out.println("EL alumno con mejor media es " + nombreAlumno + " con una media de " + mejorMedia);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String ruta = "src/Programacion/Curso2526/I/I5/notasAlumnos.csv";
        I5_LeerFichero obj = new I5_LeerFichero();
        obj.leerFichero(ruta);
    }
}