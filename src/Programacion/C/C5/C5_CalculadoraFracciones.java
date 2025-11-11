package Programacion.C.C5;

public class C5_CalculadoraFracciones {

    A3_Fraccion sumarFraccion (A3_Fraccion f1, A3_Fraccion f2) {
        return f1.sumar(f2);
    }

    A3_Fraccion restarFraccion (A3_Fraccion f1, A3_Fraccion f2) {
        return f1.restar(f2);
    }

    A3_Fraccion multiplicarFraccion (A3_Fraccion f1, A3_Fraccion f2) {
        return f1.multiplicar(f2);
    }

    A3_Fraccion dividirFraccion (A3_Fraccion f1, A3_Fraccion f2) {
        return f1.dividir(f2);
    }

    public static void main(String[] args) {
        C5_CalculadoraFracciones calc = new C5_CalculadoraFracciones();

        A3_Fraccion f1 = new A3_Fraccion(1,2);
        A3_Fraccion f2 = new A3_Fraccion(2,4);

        A3_Fraccion resultadoSuma = calc.sumarFraccion(f1, f2);
        A3_Fraccion resultadoResta = calc.restarFraccion(f1, f2);
        A3_Fraccion resultadoMultiplicacion = calc.multiplicarFraccion(f1, f2);
        A3_Fraccion resultadoDivision = calc.dividirFraccion(f1, f2);

        System.out.print("Suma: ");
        resultadoSuma.mostrarFraccion();

        System.out.print("Resta: ");
        resultadoResta.mostrarFraccion();

        System.out.print("Multiplicacion: ");
        resultadoMultiplicacion.mostrarFraccion();

        System.out.print("Division: ");
        resultadoDivision.mostrarFraccion();
    }
}