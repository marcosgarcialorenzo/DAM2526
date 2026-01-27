package Programacion.Curso2526.G.G2;

public class G2_ComprobarDNI {
    private static final char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    public static void verificarDNI(String dni) throws Exception {

        if (dni.length() != 9) {
            throw new Exception("Número incorrecto de caracteres");
        }

        String numeros = dni.substring(0, 8);

        for (int i = 0; i < numeros.length(); i++) {
            if (!Character.isDigit(numeros.charAt(i))) {
                throw new Exception("Carácter no válido en la parte numérica del DNI");
            }
        }

        int numeroDNI = Integer.parseInt(numeros);
        char letra = Character.toUpperCase(dni.charAt(8));

        int resto = numeroDNI % 23;
        char letraCorrecta = letrasDNI[resto];

        if (letra != letraCorrecta) {
            throw new Exception("Letra del DNI incorrecta");
        }
    }

    public static void main(String[] args) {
        String dni = "53908908J";
        String dni1 = "053908908J"; //número de caracteres incorrecto
        String dni2 = "5J908908J"; //carácter no numérico
        String dni3 = "53908908T"; //letra incorrecta

        try {
            verificarDNI(dni);
            System.out.println("DNI correcto");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }try {
            verificarDNI(dni1);
            System.out.println("DNI correcto");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }try {
            verificarDNI(dni2);
            System.out.println("DNI correcto");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }try {
            verificarDNI(dni3);
            System.out.println("DNI correcto");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}