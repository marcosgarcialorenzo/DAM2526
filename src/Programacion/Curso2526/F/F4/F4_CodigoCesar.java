package Programacion.Curso2526.F.F4;

import java.io.IOException;

public class F4_CodigoCesar {

    public String encriptar(String cadena, int codigo) throws IOException {
        Teclado t = new Teclado();
        String cadenaEncriptada = "";
        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            if (Character.isLetter(letra)) {
                char base = Character.isUpperCase(letra) ? 'A' : 'a';
                letra = (char) (base + (letra - base + codigo) % 26);
            }
            cadenaEncriptada += letra;
        }
        System.out.println("Cadena encriptada: " + cadenaEncriptada);
        System.out.println("");
        return cadenaEncriptada;
    }

    public String desencriptar(String cadena, int codigo) throws IOException {
        Teclado t = new Teclado();
        String cadenaDesencriptada = "";
        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            if (Character.isLetter(letra)) {
                char base = Character.isUpperCase(letra) ? 'A' : 'a';
                letra = (char) (base + (letra - base - codigo) % 26);
            }
            cadenaDesencriptada += letra;
        }
        System.out.println("Cadena desencriptada:" + cadenaDesencriptada);
        System.out.println("");
        return cadenaDesencriptada;
    }

    public static void main(String[] args) throws IOException {
        F4_CodigoCesar test = new F4_CodigoCesar();
        String cadena1 = "Marcos";
        String resultado1 = test.encriptar(cadena1, 5);
        String result1 = test.desencriptar(resultado1, 5);
    }
}