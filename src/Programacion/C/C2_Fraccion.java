package Programacion.C;

public class C2_Fraccion {
    int numerador;
    int denominador;

    C2_Fraccion(int n, int d) { //constructor
        numerador = n;
        denominador = d;
    }

    C2_Fraccion() {} //constructor vacio

    void mostrarFraccion () {
        System.out.println(numerador+"/"+denominador);
    }

    /*C2_Fraccion multiplicar (C2_Fraccion fraccion) {
        C2_Fraccion resultado = new C2_Fraccion();
        resultado.numerador = this.numerador * fraccion.numerador;
        resultado.denominador = this.denominador * fraccion.denominador;
        return resultado;
    }

    C2_Fraccion dividir (C2_Fraccion fraccion) {
        C2_Fraccion resultado = new C2_Fraccion();
        resultado.numerador = this.numerador * fraccion.denominador;
        resultado.denominador = this.denominador * fraccion.numerador;
        return resultado;
    }

    C2_Fraccion sumar (C2_Fraccion fraccion) {
        C2_Fraccion resultado = new C2_Fraccion();
        if (this.denominador == fraccion.denominador) {
            resultado.denominador = this.denominador;
            resultado.numerador = this.numerador + fraccion.numerador;
        }
        else {
            resultado.denominador = this.denominador * fraccion.denominador;
            resultado.numerador = (this.numerador * fraccion.denominador) + (fraccion.numerador * this.denominador);
        }
        return resultado;
    }

    C2_Fraccion restar (C2_Fraccion fraccion) {
        C2_Fraccion resultado = new C2_Fraccion();
        if (this.denominador == fraccion.denominador) {
            resultado.denominador = this.denominador;
            resultado.numerador = this.numerador - fraccion.numerador;
        }
        else {
            resultado.denominador = this.denominador * fraccion.denominador;
            resultado.numerador = (this.numerador * fraccion.denominador) - (fraccion.numerador * this.denominador);
        }
        return resultado;
    }*/

    void reducir(C2_Fraccion fraccion) {
        int a = fraccion.numerador;
        int b = fraccion.denominador;
        int mcd = 1;

        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                mcd = i;
            }
        }

        fraccion.numerador = a / mcd;
        fraccion.denominador = b / mcd;
    }

    public static void main(String[] args) {
        /*C2_Fraccion f1 = new C2_Fraccion(1,2);
        C2_Fraccion f2 = new C2_Fraccion(2,4);*/
        C2_Fraccion f3 = new C2_Fraccion(40,140);
//        C2_Fraccion fAux;

        /*System.out.print("Fraccion 1: ");
        f1.mostrarFraccion();
        System.out.print("Fraccion 2: ");
        f2.mostrarFraccion();

        fAux = f1.multiplicar(f2);
        System.out.print("Multiplicacion: ");
        fAux.mostrarFraccion();

        fAux = f1.dividir(f2);
        System.out.print("Division: ");
        fAux.mostrarFraccion();

        fAux = f1.sumar(f2);
        System.out.print("Suma: ");
        fAux.mostrarFraccion();

        fAux = f1.restar(f2);
        System.out.print("Resta: ");
        fAux.mostrarFraccion();*/

        System.out.println("Fraccion a reducir: ");
        f3.mostrarFraccion();
        f3.reducir(f3);
        System.out.println("Fraccion reducida: ");
        f3.mostrarFraccion();
    }
}