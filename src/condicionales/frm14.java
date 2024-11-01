package condicionales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm14 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNumeroTarjeta, txtMontoCompra, txtDescuento;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm14 frame = new frm14();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm14() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumeroTarjeta = new JLabel("Número de la Tarjeta:");
        lblNumeroTarjeta.setBounds(30, 30, 150, 30);
        getContentPane().add(lblNumeroTarjeta);

        txtNumeroTarjeta = new JTextField();
        txtNumeroTarjeta.setBounds(180, 30, 100, 30);
        txtNumeroTarjeta.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumeroTarjeta.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumeroTarjeta);

        JLabel lblMontoCompra = new JLabel("Monto de la Compra:");
        lblMontoCompra.setBounds(30, 80, 150, 30);
        getContentPane().add(lblMontoCompra);

        txtMontoCompra = new JTextField();
        txtMontoCompra.setBounds(180, 80, 100, 30);
        txtMontoCompra.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMontoCompra.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMontoCompra);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(30, 130, 150, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(180, 130, 100, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setMargin(new Insets(5, 5, 5, 5));
        txtDescuento.setEditable(false);
        getContentPane().add(txtDescuento);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 180, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularDescuento();
            }
        });
    }

    protected void calcularDescuento() {
        int numeroTarjeta;
        double montoCompra;

        try {
            numeroTarjeta = Integer.parseInt(txtNumeroTarjeta.getText());
            montoCompra = Double.parseDouble(txtMontoCompra.getText());
            if (montoCompra < 0) {
                JOptionPane.showMessageDialog(this, "El monto de la compra no puede ser negativo.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double descuento;

        if (numeroTarjeta % 2 == 0 && numeroTarjeta >= 100) {
            descuento = 0.15;
        } else {
            descuento = 0.05;
        }

        double totalDescuento = montoCompra * descuento;

        txtDescuento.setText(String.format("S/ %.2f", totalDescuento));
    }
}
