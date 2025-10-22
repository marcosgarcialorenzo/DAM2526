package B;

public class B2_Fecha {
    int dia;
    int mes;
    int agno;

    B2_Fecha(int d, int m, int a) { //constructor
        dia = d;
        mes = m;
        agno = a;
    }

    public static void main(String[] args) {
        B2_Fecha fecha = new B2_Fecha(28, 2, 2023);
        System.out.println("Fecha inicial: " + fecha.dia + "/" + fecha.mes + "/" + fecha.agno);
        System.out.println("Es bisiesto: " + fecha.esBisiesto());
        System.out.println("Días en el mes: " + fecha.diasEnMes());
        System.out.println("Siguiente día: " + fecha.siguienteDia());
    }

    boolean esBisiesto() {
        return (agno % 4 == 0 && agno % 100 != 0) || (agno % 400 == 0);
    }

    int diasEnMes() {
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return esBisiesto() ? 29 : 28;
            default:
                return 0; // Mes inválido
        }
    }

    String siguienteDia() {
        dia++;
        if (dia > diasEnMes()) {
            dia = 1;
            mes++;
            if (mes > 12) {
                mes = 1;
                agno++;
            }
        }
        return dia + "/" + mes + "/" + agno;
    }
}