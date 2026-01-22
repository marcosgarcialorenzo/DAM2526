package Programacion.Curso2526.F;

public class F7_PuntoMiles {

    public static String separar(String cadena) {
        String[] palabras = cadena.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            if (esNumero(palabras[i])) {
                palabras[i] = formatearNumero(palabras[i]);
            }
        }
        return String.join(" ", palabras);
    }

    public static boolean esNumero(String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            if (! Character.isDigit(palabra.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String formatearNumero(String numero) {
        StringBuilder sb = new StringBuilder(numero);
        int longitud = sb.length();
        for (int i = longitud - 3; i > 0; i -= 3) {
            sb.insert(i, '.');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String test1 = "En esta cadena está el número 123456 y el 1456";
        System.out.println(separar(test1));
    }
}