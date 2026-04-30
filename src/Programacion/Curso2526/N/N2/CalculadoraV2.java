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
        JPanel panelOperandos = new JPanel(new BorderLayout(8, 8));
        JPanel panelOperandosBoton = new JPanel(new GridLayout(1, 1, 6, 6));
        JPanel panelOperandosTexto = new JPanel(new GridLayout(2, 2, 6, 6));
        JPanel panelResultado = new JPanel(new GridLayout(1, 2, 6, 6));
        JPanel panelBotones = new JPanel(new GridLayout(1, 5, 6, 6));

        JButton operandoBoton = new JButton("Pedir operando");
        operandoBoton.addActionListener(e -> manejarBoton("Pedir operando1"));
        operandoBoton.addActionListener(e -> manejarBoton("Pedir operando2"));

        JLabel operando1Texto = new JLabel("Operando 1:");
        JLabel operando2Texto = new JLabel("Operando 2:");
        JLabel resultadoTexto = new JLabel("Resultado:");

        operando1.setEditable(false);
        operando2.setEditable(false);
        resultado.setEditable(false);

        panelOperandosBoton.add(operandoBoton);
        panelOperandosTexto.add(operando1Texto);
        panelOperandosTexto.add(operando1);
        panelOperandosTexto.add(operando2Texto);
        panelOperandosTexto.add(operando2);
        panelOperandos.add(panelOperandosTexto,  BorderLayout.EAST);
        panelOperandos.add(panelOperandosBoton,  BorderLayout.WEST);
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
        if (texto.equals("C")) {
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Estás seguro?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                operando1.setText("0");
                operando2.setText("0");
                resultado.setText("0");
            }
            return;
        }
        if (texto.startsWith("Pedir")) {
            String entrada = JOptionPane.showInputDialog(this, "Introduce el operando:");
            if (entrada != null) {
                if (texto.endsWith("1")) {
                    operando1.setText(entrada);
                } else {
                    operando2.setText(entrada);
                }
            }
            return;
        }
        try {
            double ope1 = Double.parseDouble(operando1.getText());// Transforma de String a double para poder operar
            double ope2 = Double.parseDouble(operando2.getText());// Transforma de String a double para poder opera
            switch (texto) {
                case "+" -> resultado.setText(String.valueOf(ope1 + ope2));
                case "-" -> resultado.setText(String.valueOf(ope1 - ope2));
                case "*" -> resultado.setText(String.valueOf(ope1 * ope2));
                case "/" -> resultado.setText(ope2 != 0 ? String.valueOf(ope1 / ope2) : "Error: Div / 0");
            }
        } catch (NumberFormatException e) {
            resultado.setText("Error: Entrada no válida");
        }
    }
}