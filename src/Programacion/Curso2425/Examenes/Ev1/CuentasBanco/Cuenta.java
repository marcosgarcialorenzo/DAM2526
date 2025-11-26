package Programacion.Curso2425.Examenes.Ev1.CuentasBanco;

public class Cuenta {
    String nombreTitular;
    double saldo;
    Movimiento ultimoMovimiento;

    public Cuenta(String nombreTitular) {
        this.nombreTitular = nombreTitular;
        this.saldo = 0;
        this.ultimoMovimiento = null;
    }

    int calcularInteres() {
        double interes = 0;
        if (saldo <= 1000)
            interes = saldo * 0.01;
        else {
            if (saldo <= 5000)
                interes = 1000 * 0.01 + (saldo - 1000) * 0.015;
            else
                interes = 1000 * 0.01 + 4000 * 0.015 + (saldo - 5000) * 0.018;
        }
        int comision = 5;
        Fecha fAhora = new Fecha(4, 4, 4);
        fAhora.fechaActual();
        if (fAhora.mismoAgno(ultimoMovimiento.getFecha()))
            comision = 0;
        saldo = saldo + interes - comision;
        boolean esIngreso = true;
        if (interes - comision < 0)
            esIngreso = false;
        ultimoMovimiento = new Movimiento(interes - comision, esIngreso, 1);
        int valorRetorno = 0;
        if (nombreTitular == null)
            valorRetorno = -1;
        return valorRetorno;
    }
}