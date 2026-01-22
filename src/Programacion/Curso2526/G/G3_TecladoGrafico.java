package Programacion.Curso2526.G;

import javax.swing.*;
import java.awt.*;

public class G3_TecladoGrafico {
    public int leerInt(String texto) {
        int num;
        while (true) {
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog(texto));
                return num;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe introducir un número entero");
            }
        }
    }

    public static void main(String a[]) {
        G3_TecladoGrafico t = new G3_TecladoGrafico();
        int n = t.leerInt("Dar numero");
        System.out.println("Numero leido: " + n);
    }
}