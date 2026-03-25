package Programacion.Curso2526.N.N1;

import javax.swing.*;
import java.awt.*;

public class CalculadoraBinaria extends JFrame {

    private JTextField display = new JTextField("0");
    private String primerNumero = "";
    private boolean esperando = false;

    public CalculadoraBinaria() {
        setTitle("Calculadora Binaria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Display
        display.setEditable(false);
        display.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(display, BorderLayout.NORTH);

        // Botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 5, 6, 0));
        for (String texto : new String[]{"1", "0", "+", "=", "C"}) {
            JButton boton = new JButton(texto);
            boton.addActionListener(e -> manejarBoton(texto));
            panelBotones.add(boton);
        }
        add(panelBotones, BorderLayout.CENTER);

        setSize(340, 120);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraBinaria().setVisible(true));
    }

    private void manejarBoton(String texto) {
        switch (texto) {
            case "0":
            case "1":
                if (esperando) {
                    display.setText(texto);
                    esperando = false;
                } else {
                    display.setText(display.getText().equals("0") ? texto : display.getText() + texto);
                }
                break;
            case "+":
                primerNumero = display.getText();
                esperando = true;
                break;
            case "=":
                long resultado = Long.parseLong(primerNumero, 2) + Long.parseLong(display.getText(), 2);
                display.setText(Long.toBinaryString(resultado));
                primerNumero = "";
                break;
            case "C":
                display.setText("0");
                primerNumero = "";
                esperando = false;
                break;
        }
    }
}