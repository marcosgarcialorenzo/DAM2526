package Programacion.A.A8;

public class Reloj {
    Hora hora;

    public Reloj(Hora hora) {
        this.hora = hora;
    }

    public Reloj() {
        this.hora = new Hora(0, 0, 0);
    }

    public static void main(String[] args) {
        Reloj reloj = new Reloj(new Hora(20, 50, 59));
        Reloj reloj2 = new Reloj(new Hora(20, 59, 59));
        Reloj reloj3 = new Reloj(new Hora(23, 59, 59));

        reloj.hora.mostrarHora();
        System.out.println();
        reloj.hora.incrementarSegundo().mostrarHora();
        System.out.println();

        reloj2.hora.mostrarHora();
        System.out.println();
        reloj2.hora.incrementarSegundo().mostrarHora();
        System.out.println();

        reloj3.hora.mostrarHora();
        System.out.println();
        reloj3.hora.incrementarSegundo().mostrarHora();
        System.out.println();
    }
}
