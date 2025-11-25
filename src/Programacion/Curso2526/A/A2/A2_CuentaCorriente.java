package Programacion.Curso2526.A.A2;

import java.io.IOException;

public class A2_CuentaCorriente { //atributos de la clase
    String numCuenta;
    float saldoActual;
    float saldoInicialAgno;

    A2_CuentaCorriente(float si, float sa, String n) { //constructor
        saldoInicialAgno = si;
        saldoActual = sa;
        numCuenta = n;
    }
    
    void mostrarDatos () {
        System.out.println("--- Datos de la Cuenta ---");
        System.out.println("Numero de Cuenta: "+numCuenta);
        System.out.println("Saldo Actual: "+saldoActual);
        System.out.println("Saldo Inicial: "+saldoInicialAgno);
        System.out.println("");
    }

    float ingresarSaldo (float s){
        saldoActual+=s;
        System.out.println("Ingreso de dinero realizado");
        System.out.println("");
        return saldoActual;
    }

    float extraerDinero (float s) {
        if (saldoActual > s) {
            saldoActual -= s;
            System.out.println("Extraccion de dinero realizado");
            System.out.println("");
        }
        else {
            System.out.println("No hay tanto dinero disponible en la cuenta");
            System.out.println("");
        }
        return saldoActual;
    }

    double calcularInteres (double interes) {
        //se recibe como 0.03
        double interesCalculado = saldoActual * interes;
        System.out.println("Interes calculado: " + interesCalculado);//este syso aparece dos veces porque cambioAgno llama a este metodo
        System.out.println("");
        return interesCalculado;
    }

    double cambioAgno (double tipoInteres) {
        double interes =  calcularInteres(tipoInteres);
        saldoActual+=interes;
        saldoInicialAgno=saldoActual;
        System.out.println("Cambio de año realizado");
        System.out.println("");
        return saldoActual;
    }

    public static void main (String[] args)  throws IOException {
        Teclado t = new Teclado();

        System.out.println("Introduce el numero de cuenta: ");
        String numeroCuenta1 = t.leerString();
        System.out.println("Numero de cuenta introducido: "+numeroCuenta1);
        System.out.println("Introduce el saldo inicial del año: ");
        float saldoInicial1 = (float) t.leerDouble();
        System.out.println("Saldo inicial del año introducido: "+saldoInicial1);
        System.out.println("Introduce el saldo actual: ");
        float saldoActual1 = (float) t.leerDouble();
        System.out.println("Saldo actual introducido: "+ saldoActual1);
        A2_CuentaCorriente cuenta1 = new A2_CuentaCorriente(saldoInicial1, saldoActual1, numeroCuenta1);

//        Scanner sc = new Scanner(System.in);
//        String numeroCuenta2;
//        System.out.println("Introduce el numero de cuenta para la cuenta 2: ");
//        numeroCuenta2 = sc.nextLine();
//        System.out.println("Numero de cuenta introducido: " + numeroCuenta2);
//        float saldoInicial2;
//        System.out.println("Introduce el saldo inicial del año para la cuenta 2: ");
//        saldoInicial2 = sc.nextFloat();
//        System.out.println("Saldo inicial del año introducido: " + saldoInicial2);
//        float saldoActual2;
//        System.out.println("Introduce el saldo actual para la cuenta 2: ");
//        saldoActual2 = sc.nextFloat();
//        System.out.println("Saldo actual introducido: " + saldoActual2);
//        A1_CuentaCorriente cuenta2 = new A1_CuentaCorriente(saldoInicial2, saldoActual2, numeroCuenta2);
//        sc.close();

        cuenta1.mostrarDatos();
        cuenta1.ingresarSaldo(500);
        cuenta1.mostrarDatos();
        cuenta1.extraerDinero(200);
        cuenta1.mostrarDatos();
        cuenta1.calcularInteres(0.05);
        cuenta1.mostrarDatos();
        cuenta1.cambioAgno(0.03);
        cuenta1.mostrarDatos();

        System.out.println("--------------------------------------------------");

//        cuenta2.mostrarDatos();
//        cuenta2.ingresarSaldo(500);
//        cuenta2.mostrarDatos();
//        cuenta2.extraerDinero(2500);
//        cuenta2.mostrarDatos();
//        cuenta2.calcularInteres(0.03);
//        cuenta2.mostrarDatos();
//        cuenta2.cambioAgno(0.05);
//        cuenta2.mostrarDatos();
    }
}
