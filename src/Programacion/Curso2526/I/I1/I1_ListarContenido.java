package Programacion.Curso2526.I.I1;

import java.io.File;
import java.io.IOException;

public class I1_ListarContenido {

    static void listar(File f) {
        if (f.isFile()) {
            System.out.println("Ruta: " + f.getAbsolutePath());
            System.out.println("Nombre del archivo: " + f.getName() + " - " + f.length() + " bytes");
            System.out.println();
        } else if (f.isDirectory()) {
            File[] contenido = f.listFiles();
            if (contenido != null) {
                for (int i = 0; i < contenido.length; i++) {
                    listar(contenido[i]); // llamada recursiva
                }
            }
        }
    }

    public static void main(String[] args) {
        Teclado t = new Teclado();
        try {
            System.out.println("Introduce el nombre de un directorio:");
            String directorio = t.leerString();

            File f = new File(directorio);

            if (f.exists()) {
                if (f.isDirectory()) {
                    listar(f);
                } else {
                    throw new Exception("La ruta proporcionada no es un directorio");
                }
            } else {
                throw new Exception("La ruta proporcionada no existe");
            }

        } catch (IOException e) {
            System.err.println("Error de entrada");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}