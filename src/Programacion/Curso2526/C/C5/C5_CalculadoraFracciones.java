package Programacion.Curso2526.C.C5;

import java.io.IOException;

public class C5_CalculadoraFracciones {

    A3_Fraccion sumarFraccion(A3_Fraccion f1, A3_Fraccion f2) {
        return f1.sumar(f2);
    }

    A3_Fraccion restarFraccion(A3_Fraccion f1, A3_Fraccion f2) {
        return f1.restar(f2);
    }

    A3_Fraccion multiplicarFraccion(A3_Fraccion f1, A3_Fraccion f2) {
        return f1.multiplicar(f2);
    }

    A3_Fraccion dividirFraccion(A3_Fraccion f1, A3_Fraccion f2) {
        return f1.dividir(f2);
    }

    public static void main(String[] args) throws IOException {
        C5_CalculadoraFracciones calculadora = new C5_CalculadoraFracciones();
        Teclado t = new Teclado();
        int condicion = 1;
        while (condicion != 0) {
            System.out.println("Para salir del programa pulse 0, para continuar pulse cualquier otro numero:");
            condicion = t.leerInt();
            char operacion;
            System.out.println("Introduzca la operadion a realizar (+, -, *, /):");
            operacion = t.leerChar();
            switch (operacion) {
                case '+' -> {
                    System.out.println("Ha seleccionado suma de fracciones.");
                    System.out.println("Escribe el numerador de la primera fraccion:");
                    int num1 = t.leerInt();
                    System.out.println("Escribe el denominador de la primera fraccion:");
                    int den1 = t.leerInt();
                    System.out.println("Escribe el numerador de la segunda fraccion:");
                    int num2 = t.leerInt();
                    System.out.println("Escribe el denominador de la segunda fraccion:");
                    int den2 = t.leerInt();
                    A3_Fraccion f1 = new A3_Fraccion(num1, den1);
                    A3_Fraccion f2 = new A3_Fraccion(num2, den2);
                    A3_Fraccion resultadoSuma = calculadora.sumarFraccion(f1, f2);
                    System.out.println("El resultado de la suma es:");
                    resultadoSuma.mostrarFraccion();
                    return;
                }
                case '-' -> {
                    System.out.println("Ha seleccionado resta de fracciones.");
                    System.out.println("Escribe el numerador de la primera fraccion:");
                    int num1 = t.leerInt();
                    System.out.println("Escribe el denominador de la primera fraccion:");
                    int den1 = t.leerInt();
                    System.out.println("Escribe el numerador de la segunda fraccion:");
                    int num2 = t.leerInt();
                    System.out.println("Escribe el denominador de la segunda fraccion:");
                    int den2 = t.leerInt();
                    A3_Fraccion f1 = new A3_Fraccion(num1, den1);
                    A3_Fraccion f2 = new A3_Fraccion(num2, den2);
                    A3_Fraccion resultadoResta = calculadora.restarFraccion(f1, f2);
                    System.out.println("El resultado de la resta es:");
                    resultadoResta.mostrarFraccion();
                    return;
                }
                case '*' -> {
                    System.out.println("Ha seleccionado multiplicacion de fracciones.");
                    System.out.println("Escribe el numerador de la primera fraccion:");
                    int num1 = t.leerInt();
                    System.out.println("Escribe el denominador de la primera fraccion:");
                    int den1 = t.leerInt();
                    System.out.println("Escribe el numerador de la segunda fraccion:");
                    int num2 = t.leerInt();
                    System.out.println("Escribe el denominador de la segunda fraccion:");
                    int den2 = t.leerInt();
                    A3_Fraccion f1 = new A3_Fraccion(num1, den1);
                    A3_Fraccion f2 = new A3_Fraccion(num2, den2);
                    A3_Fraccion resultadoMultiplicaion = calculadora.multiplicarFraccion(f1, f2);
                    System.out.println("El resultado de la multiplicacion es:");
                    resultadoMultiplicaion.mostrarFraccion();
                    return;
                }
                case '/' -> {
                    System.out.println("Ha seleccionado division de fracciones.");
                    System.out.println("Escribe el numerador de la primera fraccion:");
                    int num1 = t.leerInt();
                    System.out.println("Escribe el denominador de la primera fraccion:");
                    int den1 = t.leerInt();
                    System.out.println("Escribe el numerador de la segunda fraccion:");
                    int num2 = t.leerInt();
                    System.out.println("Escribe el denominador de la segunda fraccion:");
                    int den2 = t.leerInt();
                    A3_Fraccion f1 = new A3_Fraccion(num1, den1);
                    A3_Fraccion f2 = new A3_Fraccion(num2, den2);
                    A3_Fraccion resultadoDivision = calculadora.dividirFraccion(f1, f2);
                    System.out.println("El resultado de la division es:");
                    resultadoDivision.mostrarFraccion();
                    return;
                }
            }
        }
    }
}