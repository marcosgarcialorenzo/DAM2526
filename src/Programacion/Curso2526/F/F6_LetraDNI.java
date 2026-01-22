package Programacion.Curso2526.F;

public class F6_LetraDNI {
    private static final char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    public static boolean comprobarDNI(String cadena) {
        if (cadena.length() != 9) {
            return false;
        }
        String numeros = cadena.substring(0, 8); //empieza en 0 y termina en 8 (no incluido) = 8-1
        int numeroDNI = Integer.parseInt(numeros);
        char letra = cadena.charAt(8);
        if (Character.isLowerCase(letra)) {
            letra = Character.toUpperCase(letra);
        }
        int resto = numeroDNI % 23;
        char letraCalculada = letrasDNI[resto];
        if (letra == letraCalculada) {

            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        String dni = ("54406882Z");
        System.out.println("¿El DNI es correcto?: " +comprobarDNI(dni));
    }
}