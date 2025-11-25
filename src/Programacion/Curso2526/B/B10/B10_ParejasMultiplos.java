package Programacion.Curso2526.B.B10;

public class B10_ParejasMultiplos {
    public static void main(String[] args) throws Exception {
        Teclado t = new Teclado();
        int contadorParejasMultiplo = 0;

        while (true) {
            System.out.println("Introduce un numero entero positivo:    (0 para terminar)");
            int n1 = t.leerInt();
            if (n1 < 0) {
                System.out.println("ERROR:  El numero es negativo");
                break;
            }
            System.out.println("Introduce otro numero entero positivo:  (0 para terminar)");
            int n2 = t.leerInt();
            if (n2 < 0) {
                System.out.println("ERROR:  El numero es negativo");
                break;
            }
            if (n1 == 0 || n2 == 0) { // Si alguno es 0 terminar sin contar la pareja
                break;
            }
            if (n1 % n2 == 0 || n2 % n1 == 0) { // Comprobar si uno es múltiplo del otro
                contadorParejasMultiplo++;
            }
        }
        System.out.println("Parejas donde un número es múltiplo del otro: " + contadorParejasMultiplo);
    }
}