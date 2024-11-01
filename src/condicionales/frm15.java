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

public class frm15 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtMontoVendido, txtSueldoBruto, txtComision, txtDescuento, txtSueldoNeto;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm15 frame = new frm15();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm15() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMontoVendido = new JLabel("Monto Total Vendido:");
        lblMontoVendido.setBounds(30, 30, 150, 30);
        getContentPane().add(lblMontoVendido);

        txtMontoVendido = new JTextField();
        txtMontoVendido.setBounds(180, 30, 100, 30);
        txtMontoVendido.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMontoVendido.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMontoVendido);

        JLabel lblSueldoBruto = new JLabel("Sueldo Bruto:");
        lblSueldoBruto.setBounds(30, 80, 150, 30);
        getContentPane().add(lblSueldoBruto);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(180, 80, 100, 30);
        txtSueldoBruto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoBruto.setEditable(false);
        getContentPane().add(txtSueldoBruto);

        JLabel lblComision = new JLabel("Comisión:");
        lblComision.setBounds(30, 130, 150, 30);
        getContentPane().add(lblComision);

        txtComision = new JTextField();
        txtComision.setBounds(180, 130, 100, 30);
        txtComision.setHorizontalAlignment(SwingConstants.RIGHT);
        txtComision.setEditable(false);
        getContentPane().add(txtComision);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(30, 180, 150, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(180, 180, 100, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setEditable(false);
        getContentPane().add(txtDescuento);

        JLabel lblSueldoNeto = new JLabel("Sueldo Neto:");
        lblSueldoNeto.setBounds(30, 230, 150, 30);
        getContentPane().add(lblSueldoNeto);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(180, 230, 100, 30);
        txtSueldoNeto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoNeto.setEditable(false);
        getContentPane().add(txtSueldoNeto);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 270, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSueldo();
            }
        });
    }

    protected void calcularSueldo() {
        double sueldoBasico = 250.0;
        double montoVendido;

        try {
            montoVendido = Double.parseDouble(txtMontoVendido.getText());
            if (montoVendido < 0) {
                JOptionPane.showMessageDialog(this, "El monto vendido no puede ser negativo.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido para el monto vendido.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        double comision = 0.0;

        if (montoVendido <= 5000) {
            comision = montoVendido * 0.05;
        } else if (montoVendido <= 10000) {
            comision = montoVendido * 0.08;
        } else if (montoVendido <= 20000) {
            comision = montoVendido * 0.10;
        } else {
            comision = montoVendido * 0.15;
        }

        double sueldoBruto = sueldoBasico + comision;

        double descuento = (sueldoBruto > 3500) ? sueldoBruto * 0.15 : sueldoBruto * 0.08;

        double sueldoNeto = sueldoBruto - descuento;

        txtSueldoBruto.setText(String.format("S/ %.2f", sueldoBruto));
        txtComision.setText(String.format("S/ %.2f", comision));
        txtDescuento.setText(String.format("S/ %.2f", descuento));
        txtSueldoNeto.setText(String.format("S/ %.2f", sueldoNeto));
    }
}
