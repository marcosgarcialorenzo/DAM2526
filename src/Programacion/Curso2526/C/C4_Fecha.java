package Programacion.Curso2526.C;

public class C4_Fecha {
    int dia;
    int mes;
    int agno;

    C4_Fecha(int d, int m, int a) { //constructor
        dia = d;
        mes = m;
        agno = a;
    }

    public static void main(String[] args) {
        C4_Fecha fecha = new C4_Fecha(28, 2, 2023);
        C4_Fecha fecha2 = new C4_Fecha(1, 11, 2025);
        System.out.println("Fecha inicial: " + fecha.dia + "/" + fecha.mes + "/" + fecha.agno);
        /*System.out.println("Es bisiesto: " + fecha.esBisiesto());
        System.out.println("Días en el mes: " + fecha.diasEnMes());
        System.out.println("Siguiente día: " + fecha.siguienteDia());*/
        System.out.println("Calendario del mes:");
        fecha2.escribirCalendarioMes(6); // Suponiendo que el mes empieza en
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

    void escribirCalendarioMes(int primerDiaSemana) {
        if (primerDiaSemana < 1 || primerDiaSemana > 7) {
            System.out.println("ERROR:      Primer día de la semana inválido (usar 1=lunes ... 7=domingo).");
        } else {
            int dias = diasEnMes();
            System.out.println("Lu Ma Mi Ju Vi Sa Do");

            for (int i = 1; i < primerDiaSemana; i++) {
                System.out.print("   ");
            }

            for (int d = 1; d <= dias; d++) {
                System.out.printf("%2d ", d);
                int posicion = (primerDiaSemana - 1 + d) % 7; // salto de línea cada 7 días
                if (posicion == 0) {
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
}