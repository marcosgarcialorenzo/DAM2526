package Programacion.Curso2526.N.N1;

import javax.swing.*;
import java.awt.*;

public class CalculadoraBinaria extends JFrame {

    private final JTextField display = new JTextField("0");
    private String primerNumero = "";
    private boolean esperando = false;

    public CalculadoraBinaria() {
        super("Calculadora Binaria"); // Establece el título de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Establece que se hace al cerrar la ventana, en este caso saliendo de la aplicación
        getContentPane().setLayout(new BorderLayout(80, 80));
        display.setEditable(false); // Bloquea la escritura directa por teclado para forzar el uso de los botones
        display.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Asigna la tipografía y el tamaño del texto
        getContentPane().add(display, BorderLayout.NORTH); // Ubica la pantalla en la zona superior de la ventana
        JPanel panelBotones = new JPanel(new GridLayout(1, 5, 6, 0)); // Crea un panel con una cuadricula
        for (String texto : new String[]{"1", "0", "+", "=", "C"}) {
            JButton boton = new JButton(texto); // Crea el botón con su texto correspondiente
            boton.addActionListener(e -> manejarBoton(texto)); // Añade un escuchador para cada botón
            panelBotones.add(boton); // Añade el botón recién creado al panel
        }
        getContentPane().add(panelBotones, BorderLayout.CENTER); // Ubica el panel de botones en el centro
        setSize(340, 120); // Dimensiona la ventana (ancho x alto)
        setVisible(true); // Se hace visible después de crear todo
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculadoraBinaria::new); // se puede poner (() -> new CalculadoraBinaria())
    }

    private void manejarBoton(String texto) {
        switch (texto) {
            case "0", "1" -> {
                if (esperando) { // Si acabamos de pulsar '+', empezamos a escribir el segundo número desde cero.
                    display.setText(texto);
                    esperando = false;
                } else {
                    if (display.getText().equals("0")) {
                        display.setText(texto); // Si solo hay un "0", lo sobrescribe para no mostrar "01"
                    } else {
                        display.setText(display.getText() + texto); //concatena
                    }
                }
            }
            case "+" -> {
                primerNumero = display.getText();
                esperando = true;
            }
            case "=" -> {
                long resultado = Long.parseLong(primerNumero, 2) + Long.parseLong(display.getText(), 2);// Convertimos de base 2 a long y sumamos
                display.setText(Long.toBinaryString(resultado)); // Convierte de long a un String de binarios
                primerNumero = "";
            }
            case "C" -> {
                display.setText("0");
                primerNumero = "";
                esperando = false;
            }
        }
    }
}