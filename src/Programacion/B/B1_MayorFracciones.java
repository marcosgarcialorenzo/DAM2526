package Programacion.B;

public class B1_MayorFracciones {
    int numerador;
    int denominador;

    B1_MayorFracciones(int n, int d) { //constructor
        numerador = n;
        denominador = d;
    }

    B1_MayorFracciones() {
    } //constructor vacio

    public static void main(String[] args) {
        Programacion.B.B1_MayorFracciones f1 = new Programacion.B.B1_MayorFracciones(5, 12);
        Programacion.B.B1_MayorFracciones f2 = new Programacion.B.B1_MayorFracciones(2, 4);
        Programacion.B.B1_MayorFracciones fAux;

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

        f1.esMayorQue(f2);
    }

    void mostrarFraccion() {
        System.out.println(numerador + "/" + denominador);
    }

    Programacion.B.B1_MayorFracciones multiplicar(Programacion.B.B1_MayorFracciones fraccion) {
        Programacion.B.B1_MayorFracciones resultado = new Programacion.B.B1_MayorFracciones();
        resultado.numerador = this.numerador * fraccion.numerador;
        resultado.denominador = this.denominador * fraccion.denominador;
        return resultado;
    }

    Programacion.B.B1_MayorFracciones dividir(Programacion.B.B1_MayorFracciones fraccion) {
        Programacion.B.B1_MayorFracciones resultado = new Programacion.B.B1_MayorFracciones();
        resultado.numerador = this.numerador * fraccion.denominador;
        resultado.denominador = this.denominador * fraccion.numerador;
        return resultado;
    }

    Programacion.B.B1_MayorFracciones sumar(Programacion.B.B1_MayorFracciones fraccion) {
        Programacion.B.B1_MayorFracciones resultado = new Programacion.B.B1_MayorFracciones();
        if (this.denominador == fraccion.denominador) {
            resultado.denominador = this.denominador;
            resultado.numerador = this.numerador + fraccion.numerador;
        } else {
            resultado.denominador = this.denominador * fraccion.denominador;
            resultado.numerador = (this.numerador * fraccion.denominador) + (fraccion.numerador * this.denominador);
        }
        return resultado;
    }

    Programacion.B.B1_MayorFracciones restar(Programacion.B.B1_MayorFracciones fraccion) {
        Programacion.B.B1_MayorFracciones resultado = new Programacion.B.B1_MayorFracciones();
        if (this.denominador == fraccion.denominador) {
            resultado.denominador = this.denominador;
            resultado.numerador = this.numerador - fraccion.numerador;
        } else {
            resultado.denominador = this.denominador * fraccion.denominador;
            resultado.numerador = (this.numerador * fraccion.denominador) - (fraccion.numerador * this.denominador);
        }
        return resultado;
    }

    B1_MayorFracciones esMayorQue(B1_MayorFracciones fraccion) {
        int denominadorComun = this.denominador * fraccion.denominador;
        int numerador1 = this.numerador * fraccion.denominador;
        int numerador2 = fraccion.numerador * this.denominador;
        if (numerador1 > numerador2) {
            System.out.println("La fraccion " + this.numerador + "/" + this.denominador + " es mayor que " + fraccion.numerador + "/" + fraccion.denominador);
            return this;
        } else if (numerador1 < numerador2) {
            System.out.println("La fraccion " + fraccion.numerador + "/" + fraccion.denominador + " es mayor que " + this.numerador + "/" + this.denominador);
            return fraccion;
        } else {
            System.out.println("Las fracciones son iguales: " + this.numerador + "/" + this.denominador + " = " + fraccion.numerador + "/" + fraccion.denominador);
            return null;
        }
    }
}
