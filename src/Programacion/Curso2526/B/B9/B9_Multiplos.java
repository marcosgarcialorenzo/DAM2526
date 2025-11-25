package Programacion.Curso2526.B.B9;

public class B9_Multiplos {
    public static void main(String[] args) throws Exception {
        int multiplo2 = 0;
        int multiplo3 = 0;
        int multiplo5 = 0;
        while (true) {
            Teclado t = new Teclado();
            System.out.println("Introduce un numero entero:");
            int numero = t.leerInt();

            if (numero % 2 == 0) {
                System.out.println(numero + " es multiplo de 2.");
                multiplo2++;
            }
            if (numero % 3 == 0) {
                System.out.println(numero + " es multiplo de 3.");
                multiplo3++;
            }
            if (numero % 5 == 0) {
                System.out.println(numero + " es multiplo de 5.");
                multiplo5++;
            }
            if (numero == 0) {
                System.out.println("El programa ha finalizado.");
                break;
            }
        }
        System.out.println("Total de multiplos de 2 introducidos: " + multiplo2);
        System.out.println("Total de multiplos de 3 introducidos: " + multiplo3);
        System.out.println("Total de multiplos de 5 introducidos: " + multiplo5);
    }
}