package Programacion.Curso2526.ExamenesMGL.Evaluacion2.Simulacro.Ej2;

import java.io.*;

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

    void mostrarEstadisticasPorDueño(File fichero, String dniBuscado) {
        int contadorLocales = 0;
        double superficieTotal = 0;
        boolean dueñoEncontrado = false;

        // Usamos RandomAccessFile para lectura (modo "r")
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
            String linea;

            while ((linea = raf.readLine()) != null) {
                // Formato: id#superficie@horarioAmpliado@DNIDueño
                // 1. Separamos el ID del resto por el '#'
                String[] partesPrincipal = linea.split("#");

                // 2. Separamos los datos restantes por el '@'
                // partesDatos[0] = superficie, [1] = horario, [2] = DNIDueño
                String[] partesDatos = partesPrincipal[1].split("@");

                String dniActual = partesDatos[2].trim();

                if (dniActual.equalsIgnoreCase(dniBuscado.trim())) {
                    contadorLocales++;
                    superficieTotal += Double.parseDouble(partesDatos[0]);
                    dueñoEncontrado = true;
                }
            }

            if (dueñoEncontrado) {
                System.out.println("--- Resultados para el DNI: " + dniBuscado + " ---");
                System.out.println("Número total de locales: " + contadorLocales);
                System.out.printf("Superficie acumulada total: %.2f m²\n", superficieTotal);
            } else {
                System.out.println("No se encontraron locales asociados al DNI: " + dniBuscado);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error en el formato de los datos del archivo.");
        }
    }

    public void calcularCuota() {
        Teclado t = new Teclado();
        System.out.print("Introduce la cantidad total de gastos del centro comercial: ");
        double gastosTotales = 0;
        try {
            gastosTotales = t.leerDouble();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        File ficheroDat = new File("locales.dat");

        // Variables para la primera pasada
        double superficieTotalTotal = 0;
        int contadorHorarioAmpliado = 0;

        // Usamos RandomAccessFile para leer y FileWriter para crear el nuevo fichero de texto
        try (RandomAccessFile raf = new RandomAccessFile(ficheroDat, "r");
             PrintWriter escritor = new PrintWriter(new FileWriter("repartoGastos.txt"))) {

            // --- PRIMERA PASADA: Calcular acumulados ---
            String linea;
            while ((linea = raf.readLine()) != null) {
                // Estructura: id#superficie@horarioAmpliado@DNIDueño
                String[] partes = linea.split("#");
                String[] datos = partes[1].split("@");

                double superficie = Double.parseDouble(datos[0]);
                boolean tieneHorario = Boolean.parseBoolean(datos[1]);

                superficieTotalTotal += superficie;
                if (tieneHorario) {
                    contadorHorarioAmpliado++;
                }
            }

            // Cálculos de cuotas base
            double parteSuperficie = gastosTotales * 0.90;
            double parteHorario = gastosTotales * 0.10;

            double euroPorM2 = (superficieTotalTotal > 0) ? (parteSuperficie / superficieTotalTotal) : 0;
            double cuotaFijaHorario = (contadorHorarioAmpliado > 0) ? (parteHorario / contadorHorarioAmpliado) : 0;

            // --- SEGUNDA PASADA: Calcular cuota individual y escribir en fichero ---
            raf.seek(0); // Volvemos al inicio del fichero .dat

            while ((linea = raf.readLine()) != null) {
                String[] partes = linea.split("#");
                int id = Integer.parseInt(partes[0]);
                String[] datos = partes[1].split("@");

                double superficie = Double.parseDouble(datos[0]);
                boolean tieneHorario = Boolean.parseBoolean(datos[1]);

                // Cálculo final para este local
                double cuotaLocal = (superficie * euroPorM2);
                if (tieneHorario) {
                    cuotaLocal += cuotaFijaHorario;
                }

                // Escritura en el fichero de texto repartoGastos.txt con el formato id@cuota
                escritor.println(id + "@" + cuotaLocal);
            }

            System.out.println("Fichero 'repartoGastos.txt' generado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al procesar los ficheros: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}