package condicionales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm26 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtMontoCompra, txtPagoPropio, txtPrestamoBanco;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm26 frame = new frm26();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm26() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMontoCompra = new JLabel("Monto Total de Compra:");
        lblMontoCompra.setBounds(50, 50, 150, 30);
        getContentPane().add(lblMontoCompra);

        JLabel lblPagoPropio = new JLabel("Pago con Fondos Propios:");
        lblPagoPropio.setBounds(50, 130, 150, 30);
        getContentPane().add(lblPagoPropio);

        JLabel lblPrestamoBanco = new JLabel("Préstamo con Intereses:");
        lblPrestamoBanco.setBounds(50, 170, 150, 30);
        getContentPane().add(lblPrestamoBanco);

        txtMontoCompra = new JTextField();
        txtMontoCompra.setBounds(220, 50, 100, 30);
        txtMontoCompra.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMontoCompra.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMontoCompra);

        txtPagoPropio = new JTextField();
        txtPagoPropio.setBounds(220, 130, 100, 30);
        txtPagoPropio.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPagoPropio.setEditable(false);
        txtPagoPropio.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPagoPropio);

        txtPrestamoBanco = new JTextField();
        txtPrestamoBanco.setBounds(220, 170, 100, 30);
        txtPrestamoBanco.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPrestamoBanco.setEditable(false);
        txtPrestamoBanco.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPrestamoBanco);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 220, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        double montoCompra = Double.parseDouble(txtMontoCompra.getText());

        double porcentajePrestamo = 0.20 + (montoCompra > 5000 ? 0.10 : 0);

        double prestamo = montoCompra * porcentajePrestamo;
        double interes = prestamo * 0.10;
        double prestamoConInteres = prestamo + interes;

        double pagoPropio = montoCompra - prestamo;

        txtPagoPropio.setText(String.format("$ %.2f", pagoPropio));
        txtPrestamoBanco.setText(String.format("$ %.2f", prestamoConInteres));
    }
}