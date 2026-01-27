package Programacion.Curso2526.I.I2;

import java.io.File;
import java.io.IOException;

public class I2_EstructuraDeFicheros {

    public static void main(String[] args) {
        crearDirectoriosYFicheros();
    }

    private static void crearDirectoriosYFicheros() {

        File dir1 = new File("C:\\Users\\marco\\IdeaProjects\\DAM2526\\src\\Programacion\\Curso2526\\I\\I2\\dir1");
        File dir1a = new File(dir1, "dir1a");

        File f1 = new File(dir1, "f1.txt");
        File f2 = new File(dir1, "f2.txt");

        File f1a = new File(dir1a, "f1a.txt");
        File f2a = new File(dir1a, "f2a.txt");

        // Crear directorios
        dir1.mkdirs();
        dir1a.mkdirs();

        try {
            // Crear ficheros
            f1.createNewFile();
            f2.createNewFile();
            f1a.createNewFile();
            f2a.createNewFile();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}