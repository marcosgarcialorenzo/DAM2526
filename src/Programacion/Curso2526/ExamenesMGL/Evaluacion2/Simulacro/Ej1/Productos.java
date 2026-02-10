package Programacion.Curso2526.ExamenesMGL.Evaluacion2.Simulacro.Ej1;

public class Productos {
    int codigo;
    double[] precios;

    public Productos(int codigo, double[] preciosTemp, int cantidad) {
        this.codigo = codigo;
        this.precios = new double[cantidad];
        for (int i = 0; i < cantidad; i++) {
            this.precios[i] = preciosTemp[i];
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecioMedio() {
        double suma = 0;
        for (int i = 0; i < precios.length; i++) {
            suma += precios[i];
        }
        return suma / precios.length;
    }
}