package Programacion.Curso2526.ExamenesMGL.Evaluacion2.Simulacro.Ej2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ej2 {
    public static void main(String[] args) {
        Ej2 programa = new Ej2();
        programa.modificarHorario();
    }

    void modificarHorario() {
        Teclado t = new Teclado();
        File fichero = new File("locales.dat");

        System.out.print("Introduce el ID del local a modificar: ");
        int idBuscado = 0;
        try {
            idBuscado = t.leerInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            boolean encontrado = false;
            String linea;
            long posicionInicioLinea = 0;

            // Buscamos la línea correspondiente al ID
            while ((linea = raf.readLine()) != null) {
                // El formato es: id#superficie@horarioAmpliado@DNIDueño
                String[] partes = linea.split("#");
                int idActual = Integer.parseInt(partes[0]);

                if (idActual == idBuscado) {
                    encontrado = true;

                    // 1. Mostrar estado actual
                    // Dividimos la segunda parte por las '@'
                    String[] datos = partes[1].split("@");
                    boolean horarioActual = Boolean.parseBoolean(datos[1]);

                    System.out.println("Local ID: " + idBuscado);
                    System.out.println("¿Tiene horario ampliado actualmente?: " + (horarioActual ? "SÍ" : "NO"));

                    // 2. Pedir cambio
                    System.out.print("¿Desea cambiar el valor? (s/n): ");
                    char respuesta = t.leerChar();

                    if (respuesta == 's') {
                        // Cambiamos el valor
                        boolean nuevoHorario = ! horarioActual;

                        // 3. Reconstruir la línea y grabar
                        // NOTA: Para archivos de texto de longitud variable, modificar en medio
                        // requiere reescribir lo posterior o que la línea mida lo mismo.
                        // Si el enunciado asume que el ID coincide con la posición física,
                        // se suele usar una longitud de registro fija.

                        // Reemplazamos en la cadena original para mantener la integridad
                        String nuevaLinea = idActual + "#" + datos[0] + "@" + nuevoHorario + "@" + datos[2];

                        // Volver al inicio de la línea encontrada
                        raf.seek(posicionInicioLinea);
                        raf.writeBytes(nuevaLinea);
                        System.out.println("Valor actualizado correctamente.");
                    }
                    break; // Salimos del bucle
                }
                posicionInicioLinea = raf.getFilePointer();
            }
            if (! encontrado) {
                System.out.println("Ese local no existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al acceder al archivo: " + e.getMessage());
        }
    }
}