package Programacion.Curso2526.N.N2;

import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame {

    JTextField operando1 = new JTextField("0");
    JTextField operando2 = new JTextField("0");
    JTextField resultado = new JTextField("0");

    public Calculadora() {
        super("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(8, 8));
        JPanel panelOperandos = new JPanel(new GridLayout(2, 2, 6, 6));
        JPanel panelResultado = new JPanel(new GridLayout(1, 2, 6, 6));
        JPanel panelBotones = new JPanel(new GridLayout(1, 5, 6, 6));
        JLabel operando1Texto = new JLabel("Operando 1:");
        JLabel operando2Texto = new JLabel("Operando 2:");
        JLabel resultadoTexto = new JLabel("Resultado:");
        operando1.setEditable(true);
        operando2.setEditable(true);
        resultado.setEditable(false);
        panelOperandos.add(operando1Texto);
        panelOperandos.add(operando1);
        panelOperandos.add(operando2Texto);
        panelOperandos.add(operando2);
        panelResultado.add(resultadoTexto);
        panelResultado.add(resultado);
        for (String texto : new String[]{"+", "-", "*", "/", "C"}) {
            JButton boton = new JButton(texto);
            boton.addActionListener(e -> manejarBoton(texto));
            panelBotones.add(boton);
        }
        getContentPane().add(panelOperandos, BorderLayout.NORTH);
        getContentPane().add(panelBotones, BorderLayout.CENTER);
        getContentPane().add(panelResultado, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculadora::new); // se puede poner (() -> new CalculadoraBinaria())
    }

    private void manejarBoton(String texto) {
        try {
            double ope1 = Double.parseDouble(operando1.getText());
            double ope2 = Double.parseDouble(operando2.getText());
            switch (texto) {
                case "+" -> resultado.setText(String.valueOf(ope1 + ope2));
                case "-" -> resultado.setText(String.valueOf(ope1 - ope2));
                case "*" -> resultado.setText(String.valueOf(ope1 * ope2));
                case "/" -> resultado.setText(ope2 != 0 ? String.valueOf(ope1 / ope2) : "Error");
                case "C" -> {
                    operando1.setText("0");
                    operando2.setText("0");
                    resultado.setText("0");
                }
            }
        } catch (NumberFormatException e) {
            resultado.setText("Error: Entrada no válida");
        }
    }
}