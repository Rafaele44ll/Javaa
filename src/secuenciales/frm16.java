package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm16 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtHorasTrabajadas, txtTarifaPorHora;
    JTextField txtSueldoBasico, txtSueldoBruto, txtSueldoNeto;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm16 frame = new frm16();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @SuppressWarnings("unused")
    public frm16() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblHorasTrabajadas = new JLabel("Horas Trabajadas:");
        lblHorasTrabajadas.setBounds(50, 50, 150, 30);
        getContentPane().add(lblHorasTrabajadas);

        txtHorasTrabajadas = new JTextField();
        txtHorasTrabajadas.setBounds(200, 50, 100, 30);
        txtHorasTrabajadas.setHorizontalAlignment(SwingConstants.RIGHT);
        txtHorasTrabajadas.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtHorasTrabajadas);

        JLabel lblTarifaPorHora = new JLabel("Tarifa por Hora:");
        lblTarifaPorHora.setBounds(50, 100, 150, 30);
        getContentPane().add(lblTarifaPorHora);

        txtTarifaPorHora = new JTextField();
        txtTarifaPorHora.setBounds(200, 100, 100, 30);
        txtTarifaPorHora.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTarifaPorHora.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtTarifaPorHora);

        JButton btnCalcular = new JButton("Calcular Sueldo");
        btnCalcular.setBounds(50, 150, 250, 30);
        getContentPane().add(btnCalcular);

        txtSueldoBasico = new JTextField();
        txtSueldoBasico.setBounds(50, 200, 250, 30);
        txtSueldoBasico.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoBasico.setEditable(false);
        getContentPane().add(txtSueldoBasico);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(50, 250, 250, 30);
        txtSueldoBruto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoBruto.setEditable(false);
        getContentPane().add(txtSueldoBruto);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(50, 300, 250, 30);
        txtSueldoNeto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoNeto.setEditable(false);
        getContentPane().add(txtSueldoNeto);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double horasTrabajadas = Double.parseDouble(txtHorasTrabajadas.getText());
        double tarifaPorHora = Double.parseDouble(txtTarifaPorHora.getText());

        double sueldoBasico = horasTrabajadas * tarifaPorHora;

        double sueldoBruto = sueldoBasico * 1.20;

        double sueldoNeto = sueldoBruto * 0.90;

        DecimalFormat df = new DecimalFormat("###.##");
        txtSueldoBasico.setText("Sueldo Básico: " + df.format(sueldoBasico));
        txtSueldoBruto.setText("Sueldo Bruto: " + df.format(sueldoBruto));
        txtSueldoNeto.setText("Sueldo Neto: " + df.format(sueldoNeto));
    }
}