package Programacion.A;

public class A13_Seguro {
    int edad;
    int agnoUltimoParte;
    boolean cocheNuevo;

    public static void main(String[] args) {
        A13_Seguro seguro = new A13_Seguro();
        seguro.edad = 31;
        seguro.agnoUltimoParte = 3;
        seguro.cocheNuevo = false;
        System.out.println("Tiene descuento:" + seguro.concederDescuento());
        /*if (seguro.concederDescuento()) {
            System.out.println("Descuento concedido");
        } else {
            System.out.println("Descuento no concedido");
        }*/
    }

    boolean concederDescuento() {
        boolean descuento;
        descuento = (edad >= 30 && agnoUltimoParte > 1 && cocheNuevo)
                || (edad >= 31 && agnoUltimoParte > 2 && !cocheNuevo)
                || (edad < 31 && agnoUltimoParte > 5);
        return descuento;
    }
}