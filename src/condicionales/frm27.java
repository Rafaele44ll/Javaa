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

public class frm27 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtMontoVendido, txtSueldoBruto, txtDescuento, txtSueldoNeto, txtPolos;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm27 frame = new frm27();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm27() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 360);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMontoVendido = new JLabel("Monto Total Vendido:");
        lblMontoVendido.setBounds(50, 50, 150, 30);
        getContentPane().add(lblMontoVendido);

        JLabel lblSueldoBruto = new JLabel("Sueldo Bruto:");
        lblSueldoBruto.setBounds(50, 130, 150, 30);
        getContentPane().add(lblSueldoBruto);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(50, 170, 150, 30);
        getContentPane().add(lblDescuento);

        JLabel lblSueldoNeto = new JLabel("Sueldo Neto:");
        lblSueldoNeto.setBounds(50, 210, 150, 30);
        getContentPane().add(lblSueldoNeto);

        JLabel lblPolos = new JLabel("Número de Polos:");
        lblPolos.setBounds(50, 250, 150, 30);
        getContentPane().add(lblPolos);

        txtMontoVendido = new JTextField();
        txtMontoVendido.setBounds(220, 50, 100, 30);
        txtMontoVendido.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMontoVendido.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMontoVendido);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(220, 130, 100, 30);
        txtSueldoBruto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoBruto.setEditable(false);
        txtSueldoBruto.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtSueldoBruto);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(220, 170, 100, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setEditable(false);
        txtDescuento.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDescuento);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(220, 210, 100, 30);
        txtSueldoNeto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoNeto.setEditable(false);
        txtSueldoNeto.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtSueldoNeto);

        txtPolos = new JTextField();
        txtPolos.setBounds(220, 250, 100, 30);
        txtPolos.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPolos.setEditable(false);
        txtPolos.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPolos);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 290, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        double montoVendido = Double.parseDouble(txtMontoVendido.getText());

        double sueldoBasico = 600;
        double comision = montoVendido * 0.15;
        double sueldoBruto = sueldoBasico + comision;

        double porcentajeDescuento = 0.05 + (sueldoBruto > 1800 ? 0.05 : 0);
        double descuento = sueldoBruto * porcentajeDescuento;

        double sueldoNeto = sueldoBruto - descuento;

        int polos = (montoVendido > 1000) ? 3 : 1;

        txtSueldoBruto.setText(String.format("S/ %.2f", sueldoBruto));
        txtDescuento.setText(String.format("S/ %.2f", descuento));
        txtSueldoNeto.setText(String.format("S/ %.2f", sueldoNeto));
        txtPolos.setText(String.valueOf(polos));
    }
}