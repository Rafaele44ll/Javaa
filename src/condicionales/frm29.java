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

public class frm29 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtHorasTrabajadas, txtPagoHora, txtSueldoBruto, txtDescuento, txtSueldoNeto;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm29 frame = new frm29();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm29() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblHorasTrabajadas = new JLabel("Horas Trabajadas:");
        lblHorasTrabajadas.setBounds(50, 50, 150, 30);
        getContentPane().add(lblHorasTrabajadas);

        JLabel lblPagoHora = new JLabel("Pago por Hora:");
        lblPagoHora.setBounds(50, 90, 150, 30);
        getContentPane().add(lblPagoHora);

        JLabel lblSueldoBruto = new JLabel("Sueldo Bruto:");
        lblSueldoBruto.setBounds(50, 170, 150, 30);
        getContentPane().add(lblSueldoBruto);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(50, 210, 150, 30);
        getContentPane().add(lblDescuento);

        JLabel lblSueldoNeto = new JLabel("Sueldo Neto:");
        lblSueldoNeto.setBounds(50, 250, 150, 30);
        getContentPane().add(lblSueldoNeto);

        txtHorasTrabajadas = new JTextField();
        txtHorasTrabajadas.setBounds(200, 50, 100, 30);
        txtHorasTrabajadas.setHorizontalAlignment(SwingConstants.RIGHT);
        txtHorasTrabajadas.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtHorasTrabajadas);

        txtPagoHora = new JTextField();
        txtPagoHora.setBounds(200, 90, 100, 30);
        txtPagoHora.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPagoHora.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPagoHora);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(200, 170, 100, 30);
        txtSueldoBruto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoBruto.setEditable(false);
        txtSueldoBruto.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtSueldoBruto);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(200, 210, 100, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setEditable(false);
        txtDescuento.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDescuento);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(200, 250, 100, 30);
        txtSueldoNeto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoNeto.setEditable(false);
        txtSueldoNeto.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtSueldoNeto);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 300, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        double horasTrabajadas = Double.parseDouble(txtHorasTrabajadas.getText());
        double pagoHora = Double.parseDouble(txtPagoHora.getText());

        double horasNormales = Math.min(horasTrabajadas, 48);
        double horasExtras = Math.max(0, horasTrabajadas - 48);
        double pagoHorasExtras = horasExtras * pagoHora * 1.2;
        double sueldoBruto = (horasNormales * pagoHora) + pagoHorasExtras;

        double descuento = sueldoBruto > 1500 ? sueldoBruto * 0.11 : sueldoBruto * 0.05;

        double sueldoNeto = sueldoBruto - descuento;

        txtSueldoBruto.setText(String.format("S/ %.2f", sueldoBruto));
        txtDescuento.setText(String.format("S/ %.2f", descuento));
        txtSueldoNeto.setText(String.format("S/ %.2f", sueldoNeto));
    }
}
