package Programacion.Curso2526.I.I3;

import java.io.File;
import java.io.IOException;

public class I3_LlegadaFichero {
    public static void main(String[] args) throws InterruptedException {
        /*String ruta1 = "src/Programacion/Curso2526/I/I3/origen";
        crearDirectorio(ruta1);
        File f1 = new File(ruta1);
        copiarDirectorio(f1, new File("src/Programacion/Curso2526/I/I3/copia_ " + f1.getName()));*/

        File origen = new File("src/Programacion/Curso2526/I/I3/origen");
        File copia = new File("src/Programacion/Curso2526/I/I3/copia");

        origen.mkdirs();
        copia.mkdirs();

        System.out.println("Vigilando el directorio Origen...");

        while (true){
            File[] archivos = origen.listFiles();

            if (archivos != null){
                for (int i=0; i< archivos.length; i++){
                    File f =archivos[i];
                    if (f.isFile()) {
                        System.out.println("Detectado fichero: " + f.getName());

                        File destino = new File(copia, f.getName());
                        boolean movido = f.renameTo(destino);

                        if (!movido){
                            System.out.println(f.getName() + "no se pudo mover");
                        }
                    }
                }
            }
            Thread.sleep(5000);
        }
    }

    /*private static void crearDirectorio(String ruta) {
        File f1 = new File(ruta);
        f1.mkdirs();
    }

    private static void copiarDirectorio(File origen, File destino) {
        if (origen.exists() && origen.isDirectory()) {
            destino.mkdirs();
            File[] contenido = origen.listFiles();
            if (contenido == null) return;
            for (int i = 0; i < contenido.length; i++) {
                File nuevo = new File(destino, contenido[i].getName());
                if (contenido[i].isDirectory()) {
                    copiarDirectorio(contenido[i], nuevo);
                } else {
                    copiarArchivo(contenido[i], nuevo);
                }
            }
        }
    }

    private static void copiarArchivo(File origen, File destino) {
        try {
            java.io.FileInputStream in = new java.io.FileInputStream(origen);
            java.io.FileOutputStream out = new java.io.FileOutputStream(destino);

            int dato;
            while ((dato = in.read()) != - 1) {
                out.write(dato);
            }

            in.close();
            out.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }*/

}