package Programacion.Curso2526.N.N2;

import javax.swing.*;
import java.awt.*;

public class CalculadoraV2 extends JFrame {

    JTextField operando1 = new JTextField("0");
    JTextField operando2 = new JTextField("0");
    JTextField resultado = new JTextField("0");

    public CalculadoraV2() {
        super("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(8, 8));
        JPanel panelOperandos = new JPanel(new GridLayout(2, 2, 6, 6));
        JPanel panelResultado = new JPanel(new GridLayout(1, 2, 6, 6));
        JPanel panelBotones = new JPanel(new GridLayout(1, 5, 6, 6));
        JButton operando1Texto = new JButton("Pedir operando 1:");
        JButton operando2Texto = new JButton("Pedir operando 2:");
        operando1Texto.addActionListener(e -> manejarBoton("Pedir operando1"));
        operando2Texto.addActionListener(e -> manejarBoton("Pedir operando2"));
        JLabel resultadoTexto = new JLabel("Resultado:");
        operando1.setEditable(false);
        operando2.setEditable(false);
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
        SwingUtilities.invokeLater(CalculadoraV2::new);
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
                    int respuesta = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres limpiar los operandos y el resultado?", "Confirmar limpieza", JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        operando1.setText("0");
                        operando2.setText("0");
                        resultado.setText("0");
                    }
                }
                case "Pedir operando1" -> {
                    String entrada = JOptionPane.showInputDialog(this, "Introduce el operando:");
                    operando1.setText(entrada);
                }
                case "Pedir operando2" -> {
                    String entrada = JOptionPane.showInputDialog(this, "Introduce el operando:");
                    operando2.setText(entrada);
                }
            }
        } catch (NumberFormatException e) {
            resultado.setText("Error: Entrada no válida");
        }
    }
}