package Programacion.D;

public class D1_Empresa {
    double sueldos[];
    int contador;

    public D1_Empresa() {
        sueldos = new double[50];
        contador = 0;
    }

    void añadirSueldo(double sueldo) {
        if (contador < sueldos.length) {
            sueldos[contador] = sueldo;
            contador++;
        }
        else {
            System.out.println("ERROR:      No se pueden añadir más sueldos, capacidad máxima alcanzada.");
        }
    }

    double calcularSueldoMedio() {
        double suma = 0;
        for (double sueldo : sueldos) {
            suma += sueldo;
        }
        return suma / contador;
    }

    public static void main(String[] args) {
        D1_Empresa empresa = new D1_Empresa();
        empresa.añadirSueldo(1500.50);
        empresa.añadirSueldo(2000.75);
        empresa.añadirSueldo(1800.00);

        double sueldoMedio = empresa.calcularSueldoMedio();
        System.out.println("El sueldo medio es: " + sueldoMedio);
    }

    void subirSueldo(double porcentaje) {
        for (double sueldo : sueldos) {
            sueldo += sueldo * (porcentaje / 100);
        }
    }
}