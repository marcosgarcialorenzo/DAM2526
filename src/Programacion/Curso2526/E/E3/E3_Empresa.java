package Programacion.Curso2526.E.E3;

public class E3_Empresa {

    int mujeresSolterasConAntiguedadMayor1(Persona[] empleados) {
        int contador = 0;
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].mujer && empleados[i].estadocivil == 's' && empleados[i].getAntiguedad() > 1) {
                contador++;
            }
        }
        return contador;
    }

    int hombresConMayorMediaSueldoMujeres(Persona[] empleados) {
        double mediaSueldosMujeres = mediaSueldoMujeres(empleados);
        int contadorHombres = 0;
        for (int i = 0; i < empleados.length; i++) {
            if (! empleados[i].mujer && empleados[i].sueldo > mediaSueldosMujeres) {
                contadorHombres++;
            }
        }
        return contadorHombres;
    }

    double mediaSueldoHombresConAntiguedadMayor1(Persona[] empleados) {
        double sumaSueldosHombres = 0;
        int contadorHombres = 0;
        for (int i = 0; i < empleados.length; i++) {
            if (! empleados[i].mujer && empleados[i].getAntiguedad() > 1) {
                sumaSueldosHombres += empleados[i].sueldo;
                contadorHombres++;
            }
        }
        double mediaSueldosHombres = sumaSueldosHombres / contadorHombres;
        return mediaSueldosHombres;
    }

    double mediaSueldosHombresConAntiguedadMenor1(Persona[] empleados) {
        double sumaSueldosHombres = 0;
        int contadorHombres = 0;
        for (int i = 0; i < empleados.length; i++) {
            if (! empleados[i].mujer && empleados[i].getAntiguedad() < 1) {
                sumaSueldosHombres += empleados[i].sueldo;
                contadorHombres++;
            }
        }
        double mediaSueldosHombres = sumaSueldosHombres / contadorHombres;
        return mediaSueldosHombres;
    }

    double mediaSueldoMujeres(Persona[] empleados) {
        double sumaSueldosMujeres = 0;
        int contadorMujeres = 0;
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].mujer) {
                sumaSueldosMujeres += empleados[i].sueldo;
                contadorMujeres++;
            }
        }
        double mediaSueldosMujeres = sumaSueldosMujeres / contadorMujeres;
        return mediaSueldosMujeres;
    }

    boolean mediaSueldoHombresConAntiguedadMayor1SuperiorMenor1(Persona[] empleados) {
        double mediaMayor1 = mediaSueldoHombresConAntiguedadMayor1(empleados);
        double mediaMenor1 = mediaSueldosHombresConAntiguedadMenor1(empleados);
        return mediaMayor1 > mediaMenor1;
    }

    public static void main(String[] args) {
        Persona[] empleados = new Persona[100];
        char[] estados = {'s', 'c', 'v'};
        for (int i = 0; i < empleados.length; i++) {
            char estado = estados[i % estados.length];
            double min = 15000, max = 35000;
            double sueldo = min + Math.random() * (max - min);
            boolean mujer = (i % 2 == 0);
            int antiguedad = i % 11;
            empleados[i] = new Persona(estado, sueldo, mujer, antiguedad);
        }
        E3_Empresa empresa = new E3_Empresa();
        int resultado = empresa.mujeresSolterasConAntiguedadMayor1(empleados);
        System.out.println("Número de mujeres solteras con antigüedad mayor a 1: " + resultado);
        int resultado2 = empresa.hombresConMayorMediaSueldoMujeres(empleados);
        System.out.println("Número de hombres con sueldo mayor a la media de mujeres: " + resultado2);
        boolean resultado3 = empresa.mediaSueldoHombresConAntiguedadMayor1SuperiorMenor1(empleados);
        System.out.println("¿La media de sueldo de hombres con antigüedad mayor a 1 es superior a la de menor a 1? " + resultado3);
    }
}