package Programacion.Curso2526.N.N1;

import javax.swing.*;
import java.awt.*;

public class CalculadoraBinaria extends JFrame {

    private JTextField display = new JTextField("0"); // Campo de texto donde se muestra el número binario actual
    private String primerNumero = ""; // Almacena el primer número binario introducido (antes de pulsar +)
    private boolean esperando = false; // Flag: indica si estamos esperando que el usuario introduzca el segundo número

    public CalculadoraBinaria() {
        setTitle("Calculadora Binaria"); // Establece el título de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Al cerrar la ventana, termina el programa
        setLayout(new BorderLayout(8, 8)); // BorderLayout divide la ventana en zonas: NORTH, CENTER, SOUTH, EAST, WEST. Los valores (8,8) son el espacio horizontal y vertical entre zonas
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen interior entre el borde de la ventana y los componentes
        // Display
        display.setEditable(false); // El usuario no puede escribir directamente en él
        display.setFont(new Font("SansSerif", Font.PLAIN, 20)); //  Establece la fuente, el tipo y el tamaño
        add(display, BorderLayout.NORTH); // Se añade y coloca en la parte superior
        // Botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 5, 6, 0)); // GridLayout(1, 5, 6, 0): 1 fila, 5 columnas, 6px de separación horizontal y 0px de separación vertical
        for (String texto : new String[]{"1", "0", "+", "=", "C"}) { // Creamos un botón por cada etiqueta del array y los añadimos al panel
            JButton boton = new JButton(texto);
            boton.addActionListener(e -> manejarBoton(texto)); // Cuando se pulsa el botón, se llama a manejarBoton() con su texto, 'e' es el evento del clic (no lo necesitamos, pero hay que declararlo)
            panelBotones.add(boton);
        }
        add(panelBotones, BorderLayout.CENTER); // Se añade y coloca en el centro

        setSize(340, 120);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraBinaria().setVisible(true)); // invokeLater garantiza que la ventana se crea en el hilo correcto de Swing (EDT)
    }

    private void manejarBoton(String texto) {
        switch (texto) {
            case "0" -> {}
            case "1" -> {
                if (esperando) {
                    display.setText(texto); // Si acabamos de pulsar +, empezamos a escribir el segundo número desde cero
                    esperando = false;
                } else {
                    display.setText(display.getText().equals("0") ? texto : display.getText() + texto); // Si el display muestra "0", lo reemplazamos; si no, concatenamos el dígito
                }
                break;
            }
            case "+" -> {
                primerNumero = display.getText(); // Guardamos lo que hay en pantalla
                esperando = true; // Activamos el flag para el segundo número
                break;
            }
            case "=" -> {
                long resultado = Long.parseLong(primerNumero, 2) + Long.parseLong(display.getText(), 2); // parseLong(cadena, 2) convierte un String binario a long decimal

                display.setText(Long.toBinaryString(resultado)); // toBinaryString() convierte el resultado decimal de vuelta a binario
                primerNumero = ""; // Limpiamos para la siguiente operación
                break;
            }
            case "C" -> { // Reiniciamos todo: el display vuelve a "0", el primer número se borra y el flag se desactiva
                display.setText("0");
                primerNumero = "";
                esperando = false;
                break;
            }
        }
    }
}