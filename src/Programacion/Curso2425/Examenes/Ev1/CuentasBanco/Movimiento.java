package Programacion.Curso2425.Examenes.Ev1.CuentasBanco;

public class Movimiento {
    double cantidad;
    boolean ingreso; //true para ingreso, false para reintegro
    private Fecha fecha; // fecha del movimiento;
    int tipo; // 1- para cálculo de interes, 2- para retirada en cajero, etc...

    Movimiento(double cant, boolean ingreso, int tipo) {
        cantidad = cant;
        this.ingreso = ingreso;
        this.tipo = tipo;
    }

    public Fecha getFecha() {
        return fecha;
    }
}