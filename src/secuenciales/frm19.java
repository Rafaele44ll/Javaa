package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm19 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtMontoVendido;
    JTextField txtComision, txtSueldoBruto, txtDescuento, txtSueldoNeto;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm19 frame = new frm19();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm19() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMontoVendido = new JLabel("Monto Vendido:");
        lblMontoVendido.setBounds(50, 50, 150, 30);
        getContentPane().add(lblMontoVendido);

        txtMontoVendido = new JTextField();
        txtMontoVendido.setBounds(200, 50, 100, 30);
        txtMontoVendido.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMontoVendido.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMontoVendido);

        JButton btnCalcular = new JButton("Calcular Sueldo");
        btnCalcular.setBounds(50, 100, 250, 30);
        getContentPane().add(btnCalcular);

        txtComision = new JTextField();
        txtComision.setBounds(50, 150, 250, 30);
        txtComision.setHorizontalAlignment(SwingConstants.RIGHT);
        txtComision.setEditable(false);
        getContentPane().add(txtComision);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(50, 200, 250, 30);
        txtSueldoBruto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoBruto.setEditable(false);
        getContentPane().add(txtSueldoBruto);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(50, 250, 250, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setEditable(false);
        getContentPane().add(txtDescuento);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(50, 300, 250, 30);
        txtSueldoNeto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoNeto.setEditable(false);
        getContentPane().add(txtSueldoNeto);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double sueldoBasico = 500;

        double montoVendido = Double.parseDouble(txtMontoVendido.getText());

        double comision = montoVendido * 0.09;

        double sueldoBruto = sueldoBasico + comision;

        double descuento = sueldoBruto * 0.11;

        double sueldoNeto = sueldoBruto - descuento;

        DecimalFormat df = new DecimalFormat("###.##");
        txtComision.setText("Comisión: S/. " + df.format(comision));
        txtSueldoBruto.setText("Sueldo Bruto: S/. " + df.format(sueldoBruto));
        txtDescuento.setText("Descuento: S/. " + df.format(descuento));
        txtSueldoNeto.setText("Sueldo Neto: S/. " + df.format(sueldoNeto));
    }
}
