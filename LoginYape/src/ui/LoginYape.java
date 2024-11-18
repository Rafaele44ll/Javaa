package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class LoginYape extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPasswordField passwordField;
    private StringBuilder password = new StringBuilder();
    private int intentosFallidos = 0; 

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginYape frame = new LoginYape();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LoginYape() {
        setTitle("Login Yape");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 320, 840); 
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setBackground(new Color(112, 75, 120)); 

        passwordField = new JPasswordField();
        passwordField.setBounds(10, 240, 290, 50); 
        passwordField.setFont(new Font("Segoe UI", Font.BOLD, 18));
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setEditable(false);
        passwordField.setBackground(new Color(112, 75, 120)); 
        passwordField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(passwordField);

        JPanel panelBotones = new JPanel();
        panelBotones.setBounds(25, 300, 260, 230); 
        panelBotones.setLayout(new GridLayout(4, 3, 5, 5)); 
        panelBotones.setBackground(new Color(112, 75, 120)); 
        getContentPane().add(panelBotones);

        List<String> botonesList = new ArrayList<>();
        String[] botones = {
            "7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            "0"
        };

        for (String texto : botones) {
            botonesList.add(texto);
        }

        Collections.shuffle(botonesList);

        for (String texto : botonesList) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            boton.setForeground(new Color(255, 255, 255)); 
            boton.setFocusPainted(false);
            boton.setBackground(new Color(126, 64, 141)); 
            boton.setBorder(BorderFactory.createLineBorder(new Color(114, 2, 142), 1));
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            boton.addActionListener(new LoginActionListener());
            panelBotones.add(boton);
        }
        
        JButton botonX = new JButton("X");
        botonX.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        botonX.setForeground(new Color(255, 255, 255));
        botonX.setFocusPainted(false);
        botonX.setBackground(new Color(126, 64, 141));
        botonX.setBorder(BorderFactory.createLineBorder(new Color(114, 2, 142), 1));
        botonX.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonX.addActionListener(new LoginActionListener());
        panelBotones.add(botonX); 

        JButton btnOlvidasteClave = new JButton("¿Olvidaste tu clave?");
        btnOlvidasteClave.setBounds(8, 540, 290, 40); 
        btnOlvidasteClave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnOlvidasteClave.setBackground(new Color(112, 75, 120)); 
        btnOlvidasteClave.setForeground(new Color(255, 255, 255)); 
        btnOlvidasteClave.setFocusPainted(false);
        btnOlvidasteClave.setBorder(BorderFactory.createEmptyBorder());
        btnOlvidasteClave.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnOlvidasteClave.addActionListener(e -> JOptionPane.showMessageDialog(null, "Recuperación de clave en seguida."));
        getContentPane().add(btnOlvidasteClave);
        
        JLabel textoLabel = new JLabel("Ingresa tu clave Yape");
        textoLabel.setBounds(10, 70, 290, 300);
        textoLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        textoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textoLabel.setForeground(new Color(255, 255, 255));
        getContentPane().add(textoLabel);
        
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBounds(55, 340, 200, 630); 
        ImageIcon icono = new ImageIcon(getClass().getResource("/imagens/Yape.png")); 
        Image imagenEscalada = icono.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH); 
        imagenLabel.setIcon(new ImageIcon(imagenEscalada));
        getContentPane().add(imagenLabel);
        
        JLabel nuevaImagenLabel = new JLabel();
        nuevaImagenLabel.setBounds(55, 70, 200, 130);  
        ImageIcon nuevaImagenIcono = new ImageIcon(getClass().getResource("/imagens/candado.png"));  
        Image nuevaImagenEscalada = nuevaImagenIcono.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        nuevaImagenLabel.setIcon(new ImageIcon(nuevaImagenEscalada));
        getContentPane().add(nuevaImagenLabel);
        
        
    }

    private class LoginActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();

            if (comando.equals("X")) {
                if (password.length() > 0) {
                    password.setLength(password.length() - 1); 
                    passwordField.setText(getCensoredPassword());
                }
                return;
            }

            password.append(comando);
            passwordField.setText(getCensoredPassword());

            if (password.length() == 6) {
                validarLogin();
            }
        }

        private String getCensoredPassword() {
            StringBuilder censoredPassword = new StringBuilder();
            for (int i = 0; i < password.length(); i++) {
                censoredPassword.append('*');
            }
            return censoredPassword.toString();
        }

        private void validarLogin() {
            String claveCorrecta = "123456";  // clave correcta

            if (password.toString().equals(claveCorrecta)) {
                JOptionPane.showMessageDialog(null, "¡Bienvenido a Yape!");
                password.setLength(0);  
                passwordField.setText("");
                intentosFallidos = 0; 
            } else {
                intentosFallidos++;  

                if (intentosFallidos >= 3) {
                    JOptionPane.showMessageDialog(null, "Has fallado 3 veces. El acceso está bloqueado temporalmente.");
                    deshabilitarBotones();
                } else {
                    JOptionPane.showMessageDialog(null, "Clave incorrecta. Intento " + intentosFallidos + " de 3.");
                }

                password.setLength(0);  
                passwordField.setText("");
            }
        }

        private void deshabilitarBotones() {
            Component[] componentes = getContentPane().getComponents();
            for (Component componente : componentes) {
                if (componente instanceof JButton) {
                    componente.setEnabled(false);  
                }
            }
        }
    }
}