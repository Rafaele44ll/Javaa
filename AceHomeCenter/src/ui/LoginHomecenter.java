package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginHomecenter extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField idOperadorField;
    private JPasswordField passwordField;
    private boolean isIdFieldFocused = true;

    public LoginHomecenter() {
        setTitle("Login - Ace Home Center");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(147, 8, 8));

        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        leftPanel.setBackground(new Color(147, 8, 8));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        imagePanel.setBackground(new Color(147, 8, 8));
        JLabel imagenLabel = new JLabel();
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/homecenter.png"));
        Image imagenEscalada = icono.getImage().getScaledInstance(460, 360, Image.SCALE_SMOOTH);
        imagenLabel.setIcon(new ImageIcon(imagenEscalada));
        imagePanel.add(imagenLabel);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        leftPanel.add(imagePanel, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel idLabel = new JLabel("ID Operador:");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        idLabel.setForeground(Color.WHITE);
        leftPanel.add(idLabel, gbc);

        gbc.gridx = 1;
        idOperadorField = new JTextField();
        idOperadorField.setPreferredSize(new Dimension(200, 30));
        idOperadorField.setFont(new Font("Arial", Font.PLAIN, 14));
        idOperadorField.setForeground(Color.WHITE);
        idOperadorField.setBackground(Color.WHITE);
        idOperadorField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                isIdFieldFocused = true;
            }
        });
        leftPanel.add(idOperadorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordLabel.setForeground(Color.WHITE);
        leftPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(Color.WHITE);
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                isIdFieldFocused = false;
            }
        });
        leftPanel.add(passwordField, gbc);

        add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new GridLayout(4, 4, 15, 15));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        String[] buttons = {
                "1", "2", "3", "Cancelar",
                "4", "5", "6", "Borrar",
                "7", "8", "9", "Atrás",
                "", "0", "", "Enter"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.setPreferredSize(new Dimension(40, 40));
            button.setFocusPainted(false);
            button.setBorder(new RoundedBorder(15));
            if (!text.isEmpty()) {
                button.addActionListener(new KeypadListener());
            } else {
                button.setEnabled(false);
            }
            rightPanel.add(button);
        }

        add(rightPanel, BorderLayout.CENTER);
    }

    private void login() {
        String idOperador = idOperadorField.getText();
        String password = new String(passwordField.getPassword());

        if (idOperador.equals("123456") && password.equals("123456")) {
            JOptionPane.showMessageDialog(this, "¡Inicio de sesión exitoso!", "Login", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "ID o Contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        clearFields();
        idOperadorField.requestFocus();
    }

    private void clearFields() {
        idOperadorField.setText("");
        passwordField.setText("");
    }

    private class KeypadListener implements ActionListener {
        @SuppressWarnings("deprecation")
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Borrar")) {
                if (isIdFieldFocused) {
                    String currentText = idOperadorField.getText();
                    if (currentText.length() > 0) {
                        idOperadorField.setText(currentText.substring(0, currentText.length() - 1));
                    }
                } else {
                    String currentText = new String(passwordField.getPassword());
                    if (currentText.length() > 0) {
                        passwordField.setText(currentText.substring(0, currentText.length() - 1));
                    }
                }
            } else if (command.equals("Cancelar")) {
                clearFields();
            } else if (command.equals("Enter")) {
                if (isIdFieldFocused) {
                    isIdFieldFocused = false;
                    passwordField.requestFocus();
                } else {
                    login();
                }
            } else if (command.equals("Atrás")) {
                int option = JOptionPane.showConfirmDialog(LoginHomecenter.this,
                        "¿Estás seguro que deseas salir del Login de usuario?", "Salir", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            } else {
                if (isIdFieldFocused) {
                    idOperadorField.setText(idOperadorField.getText() + command);
                } else {
                    passwordField.setText(passwordField.getText() + command);
                }
            }
        }
    }

    private static class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(10, 10, 10, 10);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(c.getForeground());
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginHomecenter login = new LoginHomecenter();
            login.setVisible(true);
        });
    }
}