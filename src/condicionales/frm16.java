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

public class frm16 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtIngresoMensual, txtCostoCasa, txtCuotaInicial, txtCuotaMensual;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm16 frame = new frm16();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm16() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblIngresoMensual = new JLabel("Ingreso Mensual:");
        lblIngresoMensual.setBounds(50, 50, 120, 30);
        getContentPane().add(lblIngresoMensual);

        JLabel lblCostoCasa = new JLabel("Costo de la Casa:");
        lblCostoCasa.setBounds(50, 90, 120, 30);
        getContentPane().add(lblCostoCasa);

        JLabel lblCuotaInicial = new JLabel("Cuota Inicial:");
        lblCuotaInicial.setBounds(50, 130, 120, 30);
        getContentPane().add(lblCuotaInicial);

        JLabel lblCuotaMensual = new JLabel("Cuota Mensual:");
        lblCuotaMensual.setBounds(50, 170, 120, 30);
        getContentPane().add(lblCuotaMensual);

        txtIngresoMensual = new JTextField();
        txtIngresoMensual.setBounds(180, 50, 100, 30);
        txtIngresoMensual.setHorizontalAlignment(SwingConstants.RIGHT);
        txtIngresoMensual.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtIngresoMensual);

        txtCostoCasa = new JTextField();
        txtCostoCasa.setBounds(180, 90, 100, 30);
        txtCostoCasa.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCostoCasa.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCostoCasa);

        txtCuotaInicial = new JTextField();
        txtCuotaInicial.setBounds(180, 130, 100, 30);
        txtCuotaInicial.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCuotaInicial.setMargin(new Insets(5, 5, 5, 5));
        txtCuotaInicial.setEditable(false);
        getContentPane().add(txtCuotaInicial);

        txtCuotaMensual = new JTextField();
        txtCuotaMensual.setBounds(180, 170, 100, 30);
        txtCuotaMensual.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCuotaMensual.setMargin(new Insets(5, 5, 5, 5));
        txtCuotaMensual.setEditable(false);
        getContentPane().add(txtCuotaMensual);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(110, 220, 120, 30);
        btnCalcular.setMnemonic('C');
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        double ingresoMensual = Double.parseDouble(txtIngresoMensual.getText());
        double costoCasa = Double.parseDouble(txtCostoCasa.getText());

        double factor = 0.15 + 0.15 * Math.floor(ingresoMensual / 1250);
        int numeroCuotas = 120 - (45 * (int) Math.floor(ingresoMensual / 1250));

        double cuotaInicial = factor * costoCasa;
        double montoCuotaMensual = (costoCasa - cuotaInicial) / numeroCuotas;

        txtCuotaInicial.setText(String.format("S/ %.2f", cuotaInicial));
        txtCuotaMensual.setText(String.format("S/ %.2f", montoCuotaMensual));
    }
}
