package Programacion.Curso2526.N.N2;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Calculadora extends JFrame {

    JTextField operando1 = new JTextField("0");
    JTextField operando2 = new JTextField("0");
    JTextField resultado = new JTextField("0");

    public Calculadora() {
        super("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(8, 8));
        JPanel panelOperandos = new JPanel(new GridLayout(2, 2, 6, 0));
        JPanel panelResultado = new JPanel(new GridLayout(1, 2, 6, 0));
        JPanel panelBotones = new JPanel(new GridLayout(1, 6, 6, 0));


        JTextField operando1Texto = new JTextField("Operando 1");
        JTextField operando2Texto = new JTextField("Operando 2");
        JTextField resultadoTexto = new JTextField("Resultado");

        operando1.setEditable(true);
        operando1Texto.setEditable(false);
        operando2.setEditable(true);
        operando2Texto.setEditable(false);
        resultado.setEditable(false);
        resultadoTexto.setEditable(false);

        panelOperandos.add(operando1, BorderLayout.NORTH);
        panelOperandos.add(operando1Texto, BorderLayout.NORTH);
        panelOperandos.add(operando2, BorderLayout.SOUTH);
        panelOperandos.add(operando2Texto, BorderLayout.SOUTH);
        panelResultado.add(resultado, BorderLayout.EAST);
        panelResultado.add(resultadoTexto, BorderLayout.WEST);
        for (String texto : new String[]{"+", "-", "*", "/", "C", "="}) {
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

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(Calculadora::new); // se puede poner (() -> new CalculadoraBinaria())
    }

    private void manejarBoton(String texto) {
        switch (texto) {
            case "+" -> {
                double ope1 = operando1.getText().charAt(0);
                double ope2 = operando2.getText().charAt(0);
                double resul = ope1 + ope2;
                resultado.setText(String.valueOf(resul));

            }
        }
    }
}