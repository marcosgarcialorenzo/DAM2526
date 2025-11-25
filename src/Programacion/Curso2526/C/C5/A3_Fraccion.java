package Programacion.Curso2526.C.C5;

public class A3_Fraccion {
    int numerador;
    int denominador;

    A3_Fraccion(int n, int d) { //constructor
        numerador = n;
        denominador = d;
    }

    A3_Fraccion() {} //constructor vacio

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    void mostrarFraccion () {
        System.out.println(numerador+"/"+denominador);
    }

    A3_Fraccion multiplicar (A3_Fraccion fraccion) {
        A3_Fraccion resultado = new A3_Fraccion();
        resultado.numerador = this.numerador * fraccion.numerador;
        resultado.denominador = this.denominador * fraccion.denominador;
        return resultado;
    }

    A3_Fraccion dividir (A3_Fraccion fraccion) {
        A3_Fraccion resultado = new A3_Fraccion();
        resultado.numerador = this.numerador * fraccion.denominador;
        resultado.denominador = this.denominador * fraccion.numerador;
        return resultado;
    }

    A3_Fraccion sumar (A3_Fraccion fraccion) {
        A3_Fraccion resultado = new A3_Fraccion();
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

    A3_Fraccion restar (A3_Fraccion fraccion) {
        A3_Fraccion resultado = new A3_Fraccion();
        if (this.denominador == fraccion.denominador) {
            resultado.denominador = this.denominador;
            resultado.numerador = this.numerador - fraccion.numerador;
        }
        else {
            resultado.denominador = this.denominador * fraccion.denominador;
            resultado.numerador = (this.numerador * fraccion.denominador) - (fraccion.numerador * this.denominador);
        }
        return resultado;
    }

    public static void main(String[] args) {
        A3_Fraccion f1 = new A3_Fraccion(1,2);
        A3_Fraccion f2 = new A3_Fraccion(2,4);
        A3_Fraccion fAux;

        System.out.print("Fraccion 1: ");
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
        fAux.mostrarFraccion();
    }
}