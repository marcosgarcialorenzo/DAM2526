package Programacion.Curso2425.Examenes.Ev1.CuentasBanco;

import java.util.Calendar;

public class Fecha {
    private int dia, mes, agno;

    Fecha() {
    }

    Fecha(int d, int m, int a) {
        dia = d;
        mes = m;
        agno = a;
    }

    /*Coloca en los atributos del objeto la fecha actual obtenida del sistema operativo*/
    void fechaActual() {
        agno = Calendar.getInstance().get(Calendar.YEAR);
        mes = 1 + Calendar.getInstance().get(Calendar.MONTH);
        dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    boolean mismoAgno(Fecha f) {
        boolean mismoAgno = false;
        if (this.agno == f.agno)
            mismoAgno = true;
        return mismoAgno;
    }

    public static void main(String[] args) {
        Fecha f1 = new Fecha(25, 11, 2025);
        Fecha f2 = new Fecha(23, 7, 2023);
        boolean esIgualAgno = f1.mismoAgno(f2);
    }
}