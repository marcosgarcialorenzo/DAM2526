package Programacion.Curso2526.N.N1;

import javax.swing.*;
import java.awt.*;

public class CalculadoraBinaria extends JFrame {

    private JTextField display = new JTextField("0"); // Pantalla de la calculadora
    private String primerNumero = ""; // Primer operando
    private boolean esperando = false; // True tras pulsar +, esperando el segundo número

    public CalculadoraBinaria() {
        setTitle("Calculadora Binaria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8)); // Zonas NORTH/CENTER/SOUTH/EAST/WEST, 8px entre ellas(horizontal y vertical)
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen interior
        // Display
        display.setEditable(false);
        display.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(display, BorderLayout.NORTH);
        // Botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 5, 6, 0)); // 1 fila, 5 col, 6px horizontal, 0px vertical
        for (String texto : new String[]{"1", "0", "+", "=", "C"}) {
            JButton boton = new JButton(texto);
            boton.addActionListener(e -> manejarBoton(texto)); // 'e' es el evento del clic, se manda a manejarBoton
            panelBotones.add(boton);
        }
        add(panelBotones, BorderLayout.CENTER);
        setSize(340, 120);
        setLocationRelativeTo(null); // Centra la ventana
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraBinaria().setVisible(true)); // Lanza la ventana en el hilo EDT
    }

    private void manejarBoton(String texto) {
        switch (texto) {
            case "0" -> {
            }
            case "1" -> {
                if (esperando) {
                    display.setText(texto); // Primer dígito del segundo número
                    esperando = false;
                } else {
                    display.setText(display.getText().equals("0") ? texto : display.getText() + texto); // Reemplaza "0" o concatena
                }
            }
            case "+" -> {
                primerNumero = display.getText(); // Guarda el primer operando
                esperando = true;
            }
            case "=" -> {
                long resultado = Long.parseLong(primerNumero, 2) + Long.parseLong(display.getText(), 2); // Binario → long → suma
                display.setText(Long.toBinaryString(resultado)); // Resultado → binario
                primerNumero = "";
            }
            case "C" -> { // Reinicia todo
                display.setText("0");
                primerNumero = "";
                esperando = false;
            }
        }
    }
}