package Programacion.C.C3;

import java.io.IOException;

public class C3_Juego {
    public static void main(String[] args) throws IOException {
        C3_Juego juego = new C3_Juego();
        long tiempoInicio = System.currentTimeMillis();
        long tiempoFin = tiempoInicio + 120000; // 2 minuto en milisegundos
        boolean fin = false;
        int contador = 0;
        while (!fin) {
            System.out.println("Tiempo restante: " + (tiempoFin - System.currentTimeMillis()) / 1000 + " segundos");
            if (System.currentTimeMillis() >= tiempoFin) {
                System.out.println("Se ha acabado el tiempo. Fin del juego.");
                System.out.println("Has conseguido " + contador + " aciertos.");
                fin = true;
                return;
            }
            int numero1 = juego.numeroAleatorio();
            int numero2 = juego.numeroAleatorio();
            System.out.println("Números generados: " + numero1 + " y " + numero2);
            int operacion;
            operacion = (int) (Math.random() * 4 + 1);
            switch (operacion) {
                case 1 -> { // Suma
                    System.out.println("Se ha elegido suma");
                    System.out.println("Operación: " + numero1 + " + " + numero2);
                    int resultadoSuma = numero1 + numero2;
                    if (juego.pedirResultado() == resultadoSuma) {
                        System.out.println("Correcto");
                        System.out.println();
                        contador++;
                    } else {
                        System.out.println("Incorrecto, el resultado correcto es: " + resultadoSuma);
                        System.out.println("Fin del juego. Has conseguido " + contador + " aciertos.");
                        fin = true;
                    }
                }
                case 2 -> { // Resta
                    System.out.println("Se ha elegido resta");
                    System.out.println("Operación: " + numero1 + " - " + numero2);
                    int resultadoResta = numero1 - numero2;
                    if (juego.pedirResultado() == resultadoResta) {
                        System.out.println("Correcto");
                        System.out.println();
                        contador++;
                    } else {
                        System.out.println("Incorrecto, el resultado correcto es: " + resultadoResta);
                        System.out.println("Fin del juego. Has conseguido " + contador + " aciertos.");
                        fin = true;
                    }
                }
                case 3 -> { // Multiplicacion
                    System.out.println("Se ha elegido multiplicacion");
                    System.out.println("Operación: " + numero1 + " * " + numero2);
                    int resultadoMultiplicacion = numero1 * numero2;
                    if (juego.pedirResultado() == resultadoMultiplicacion) {
                        System.out.println("Correcto");
                        System.out.println();
                        contador++;
                    } else {
                        System.out.println("Incorrecto, el resultado correcto es: " + resultadoMultiplicacion);
                        System.out.println("Fin del juego. Has conseguido " + contador + " aciertos.");
                        fin = true;
                    }
                }
                case 4 -> { // Division
                    System.out.println("Se ha elegido division");
                    System.out.println("Operación: " + numero1 + " / " + numero2);
                    double resultadoDivision = (double) numero1 / numero2;
                    if (juego.pedirResultado() == Math.round(resultadoDivision)) {
                        System.out.println("Correcto");
                        System.out.println();
                        contador++;
                    } else {
                        System.out.println("Incorrecto, el resultado correcto es: " + resultadoDivision);
                        System.out.println("Fin del juego. Has conseguido " + contador + " aciertos.");
                        fin = true;
                    }
                }
            }
        }
    }

    int numeroAleatorio() {
        int numero = (int) (Math.random() * 10 + 1);
        return numero;
    }

    int pedirResultado() throws IOException {
        System.out.println("Introduce el resultado de la operacion:");
        Teclado teclado = new Teclado();
        int resultado;
        resultado = teclado.leerInt();
        return resultado;
    }
}