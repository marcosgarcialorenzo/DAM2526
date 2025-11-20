package Programacion.D.D3;

import java.io.IOException;

public class D3_AparicionNumeros {
    public static void main(String[] args) throws IOException {
        Teclado teclado = new Teclado();
        int[] numeros = new int[20];

        System.out.println("Introduce 20 números enteros:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = teclado.leerInt();
        }

        int mejorIndice = 0;
        int mejorCuenta = 0;

        for (int i = 0; i < numeros.length; i++) {
            int cuenta = 0;
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[j] == numeros[i]) {
                    cuenta++;
                }
                /*esto compara el indice 0 del array con todos los demas indices, si coincide suma 1 a cuenta. cuando termina el for cambia el indice i a 1 y vuelve a comparar el indice 1 con todos los demas indices*/
            }
            if (cuenta > mejorCuenta) { // si la cuenta del numero en el indice i es mayor que la mejor cuenta hasta ahora, actualiza la mejor cuenta y el mejor indice
                mejorCuenta = cuenta;
                mejorIndice = i;
            }
        }
        System.out.println("El número que más aparece es: " + numeros[mejorIndice] + " (aparece " + mejorCuenta + " veces)");
    }
}