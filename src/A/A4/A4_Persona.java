package A.A4;

import java.io.IOException;

public class A4_Persona {
    double sueldo;

    A4_Persona(double s) { //constructor
        sueldo = s;
    }

    double incrementarSueldo (double incremento) {
        sueldo = sueldo + (sueldo * incremento);
        return sueldo;
    }

    public static void main(String[] args) throws IOException {  ///hay que pedir los datos por teclado
        double sueldo;
        Teclado t = new Teclado();
        System.out.println("Introduce el sueldo de la persona:");
        sueldo = t.leerDouble();
        A4_Persona p1 = new A4_Persona(sueldo);
        System.out.println("Sueldo inicial: "+p1.sueldo);
        p1.incrementarSueldo(0.10);
        System.out.println("Sueldo despues del incremento: "+p1.sueldo);

        //lo mismo para los otros dos



        A4_Persona p2 = new A4_Persona(2000);
        System.out.println("Sueldo inicial: "+p2.sueldo);
        p2.incrementarSueldo(0.05);
        System.out.println("Sueldo despues del incremento: "+p2.sueldo);

        A4_Persona p3 = new A4_Persona(3000);
        System.out.println("Sueldo inicial: "+p3.sueldo);
        p3.incrementarSueldo(0.50);
        System.out.println("Sueldo despues del incremento: "+p3.sueldo);
    }
}