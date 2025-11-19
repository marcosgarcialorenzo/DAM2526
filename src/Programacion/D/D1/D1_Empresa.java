package Programacion.D.D1;

import java.io.IOException;

public class D1_Empresa {
    double sueldos[];
    int contador;

    public D1_Empresa() {
        sueldos = new double[50];
        contador = 0;
    }

    public static void main(String[] args) throws IOException {
        Teclado teclado = new Teclado();
        D1_Empresa empresa = new D1_Empresa();
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Añadir sueldo");
            System.out.println("2. Calcular sueldo medio");
            System.out.println("3. Subir sueldo a todos");
            System.out.println("4. Subir sueldo a los menores que la media");
            System.out.println("5. Subir sueldo a empleados específicos");
            System.out.println("6. Mostrar códigos de menor y mayor sueldo");
            System.out.println("7. Mostrar todos los sueldos");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = teclado.leerInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Indica el sueldo a añadir: ");
                    double sueldo = teclado.leerDouble();
                    empresa.añadirSueldo(sueldo);
                }
                case 2 -> {
                    System.out.println("El sueldo medio de los empleados es de: " + empresa.calcularSueldoMedio());
                }
                case 3 -> {
                    System.out.println("Indica el porcentaje de subida de sueldos genéricos (porciento): ");
                    double porcentaje = teclado.leerDouble();
                    empresa.subirSueldo(porcentaje);
                }
                case 4 -> {
                    System.out.println("Indica el porcentaje de subida de sueldo a empleados por debajo de la media: ");
                    double porcentaje = teclado.leerDouble();
                    empresa.subirSueldoMenoresMedia(porcentaje);
                }
                case 5 -> {
                    System.out.println("¿Cuántos empleados quieres actualizar? ");
                    int cantidad = teclado.leerInt();
                    int[] codigos = new int[cantidad];
                    for (int i = 0; i < cantidad; i++) {
                        System.out.println("Introduce el código del empleado ");
                        codigos[i] = teclado.leerInt();
                    }
                    empresa.subirSueldoXEmpleados(codigos);
                }
                case 6 -> {
                    int[] codigos = empresa.devolverCodigoEmpleadosMenoryMayorSueldo();
                    if (codigos[0] == -1) {
                        System.out.println("No hay sueldos registrados.");
                    } else {
                        int menor = codigos[0];
                        int mayor = codigos[1];
                        System.out.println("Empleado con menor sueldo: " + menor + " (Sueldo: " + empresa.sueldos[menor] + ")");
                        System.out.println("Empleado con mayor sueldo: " + mayor + " (Sueldo: " + empresa.sueldos[mayor] + ")");
                    }
                }
                case 7 -> {
                    empresa.mostrarSueldos();
                }
                case 0 -> {
                    System.out.println("Saliendo del programa...");
                }
                default -> {
                    System.out.println("Opción incorrecta");
                }
            }
        } while (opcion != 0);
    }

    void añadirSueldo(double sueldo) {
        if (contador < sueldos.length) {
            sueldos[contador] = sueldo;
            contador++;
        } else {
            System.out.println("ERROR:      No se pueden añadir más sueldos, capacidad máxima alcanzada.");
        }
    }

    double calcularSueldoMedio() {
        double suma = 0;
        for (int i = 0; i < contador; i++) {
            suma += sueldos[i];
        }
        return suma / contador;
    }

    void subirSueldo(double porcentaje) {
        for (int i = 0; i < contador; i++) {
            sueldos[i] += sueldos[i] * (porcentaje / 100.0);
        }
    }

    void subirSueldoMenoresMedia(double porcentaje) {
        double media = calcularSueldoMedio();
        for (int i = 0; i < contador; i++) {
            if (sueldos[i] < media) {
                sueldos[i] += sueldos[i] * (porcentaje / 100);
            }
        }
    }

    void subirSueldoXEmpleados(int[] numeroEmpleados) {
        for (int i = 0; i < numeroEmpleados.length; i++) {
            int indice = numeroEmpleados[i];
            if (indice >= 0 && indice < contador) {
                sueldos[indice] += sueldos[indice] * 0.10;
            } else {
                System.out.println("ERROR:      Índice de empleado fuera de rango: " + indice);
            }
        }
    }

    int[] devolverCodigoEmpleadosMenoryMayorSueldo() {
        int[] resultado = new int[2];
        double media = calcularSueldoMedio();
        int menor = -1;
        int mayor = -1;

        for (int i = 0; i < contador; i++) {
            if (sueldos[i] < media) {
                menor = i;
            } else if (sueldos[i] > media) {
                mayor = i;
            }
        }

        resultado[0] = menor;
        resultado[1] = mayor;
        return resultado;
    }

    void mostrarSueldos() {
        for (int i = 0; i < contador; i++) {
            System.out.println("Empleado " + i + ": Sueldo = " + sueldos[i]);
        }
    }
}