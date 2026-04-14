package Programacion.Curso2526.N.N1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Examen2425Ev3Ej2 extends JFrame {

    JLabel display;
    JButton[] botones = new JButton[3];
    boolean[] pulsados = new boolean[3];
    Random random = new Random();
    int objetivoActual = - 1;

    public Examen2425Ev3Ej2() {
        super("Examen Junio 2425");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(8, 8));
        display = new JLabel("Por favor espere", SwingConstants.CENTER);
        display.setFont(new Font("SansSerif", Font.PLAIN, 18));
        getContentPane().add(display, BorderLayout.SOUTH);
        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 6, 0));
        for (int i = 0; i < botones.length; i++) {
            int indice = i;
            JButton boton = new JButton("Botón " + i);
            boton.addActionListener(e -> manejarBoton(indice));
            boton.setBackground(Color.BLUE);
            boton.setForeground(Color.WHITE); // color de las letras
            botones[i] = boton;
            panelBotones.add(boton);
        }
        getContentPane().add(panelBotones, BorderLayout.CENTER);
        elegirObjetivo();
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Examen2425Ev3Ej2::new); // se puede poner (() -> new CalculadoraBinaria())
    }

    void elegirObjetivo() {
        List<Integer> disponibles = new ArrayList<>();
        for (int i = 0; i < pulsados.length; i++) {
            if (! pulsados[i]) {
                disponibles.add(i);
            }
        }

        if (disponibles.isEmpty()) {
            objetivoActual = - 1;
            display.setText("COMPLETADO: Todos los botones han sido pulsado en el orden correcto");
            pack();
            return;
        }

        objetivoActual = disponibles.get(random.nextInt(disponibles.size())); // coge un índice aleatorio entre la cantidad de disponibles
        display.setText("Pulsa el botón " + objetivoActual);
    }

    private void manejarBoton(int indice) {
        if (indice != objetivoActual) {
            return;
        }
        pulsados[indice] = true;
        botones[indice].setBackground(Color.RED);
        botones[indice].setForeground(Color.BLACK);
        elegirObjetivo();
    }
}