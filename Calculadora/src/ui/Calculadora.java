package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculadora extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField pantalla;
    private double num1 = 0;
    private double num2 = 0;
    private String operador = "";
    private boolean nuevoNumero = true;

    private final Map<String, BiFunction<Double, Double, Double>> operaciones;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Calculadora frame = new Calculadora();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Calculadora() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 320, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        pantalla = new JTextField();
        pantalla.setBounds(10, 10, 290, 60);
        pantalla.setFont(new Font("Segoe UI", Font.BOLD, 24));
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
        pantalla.setEditable(false);
        pantalla.setBackground(new Color(240, 240, 240));
        pantalla.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(pantalla);

        JPanel panelBotones = new JPanel();
        panelBotones.setBounds(10, 80, 290, 270);
        panelBotones.setLayout(new GridLayout(5, 4, 5, 5));
        panelBotones.setBackground(new Color(240, 240, 240));
        getContentPane().add(panelBotones);

        String[] botones = {
                "%", "CE", "C", "÷",
                "7", "8", "9", "x",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "x²", "0", ".", "=",
        };

        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            boton.setForeground(Color.BLACK);
            boton.setFocusPainted(false);
            boton.setBackground("C".equals(texto) ? Color.WHITE : new Color(240, 240, 240));
            boton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            if ("÷x-+".contains(texto)) {
                boton.setBackground(new Color(220, 220, 220));
            } else if ("=".equals(texto)) {
                boton.setBackground(new Color(0, 120, 215));
                boton.setForeground(Color.WHITE);
            }

            boton.addActionListener(new CalculadoraActionListener());
            panelBotones.add(boton);
        }

        operaciones = new HashMap<>();
        operaciones.put("+", Double::sum);
        operaciones.put("-", (a, b) -> a - b);
        operaciones.put("x", (a, b) -> a * b);
        operaciones.put("÷", (a, b) -> b == 0 ? null : a / b);
        operaciones.put("%", (a, b) -> (a * b) / 100);
    }

    private class CalculadoraActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();

            if ("C".equals(comando)) {
                pantalla.setText("");
                operador = "";
                num1 = 0;
                nuevoNumero = true;
            } else if ("CE".equals(comando)) {
                if (!pantalla.getText().isEmpty()) {
                    pantalla.setText(pantalla.getText().substring(0, pantalla.getText().length() - 1));
                }
            } else if ("=".equals(comando)) {
                calcularResultado();
                operador = "";
                nuevoNumero = true;
            } else if (operaciones.containsKey(comando)) {
                if (!pantalla.getText().isEmpty()) {
                    num1 = Double.parseDouble(pantalla.getText());
                    operador = comando;
                    nuevoNumero = true;
                }
            } else if ("x²".equals(comando)) {
                if (!pantalla.getText().isEmpty()) {
                    double numero = Double.parseDouble(pantalla.getText());
                    pantalla.setText(String.valueOf(Math.pow(numero, 2)));
                }
            } else {
                if (nuevoNumero) {
                    pantalla.setText(comando);
                    nuevoNumero = false;
                } else {
                    pantalla.setText(pantalla.getText() + comando);
                }
            }
        }

        private void calcularResultado() {
            if (!pantalla.getText().isEmpty() && !operador.isEmpty() && operaciones.containsKey(operador)) {
                num2 = Double.parseDouble(pantalla.getText());
                BiFunction<Double, Double, Double> operacion = operaciones.get(operador);
                Double resultado = operacion.apply(num1, num2);
                if (resultado == null) {
                    pantalla.setText("Error");
                } else {
                    pantalla.setText(String.valueOf(resultado));
                    num1 = resultado;
                }
            }
        }
    }
}