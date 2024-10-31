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

public class frm18 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtDonacion, txtCentroSalud, txtComedorNinos, txtBolsa;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm18 frame = new frm18();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm18() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblDonacion = new JLabel("Monto Donación:");
        lblDonacion.setBounds(50, 50, 120, 30);
        getContentPane().add(lblDonacion);

        JLabel lblCentroSalud = new JLabel("Centro de Salud:");
        lblCentroSalud.setBounds(50, 100, 120, 30);
        getContentPane().add(lblCentroSalud);

        JLabel lblComedorNinos = new JLabel("Comedor Niños:");
        lblComedorNinos.setBounds(50, 150, 120, 30);
        getContentPane().add(lblComedorNinos);

        JLabel lblBolsa = new JLabel("Inversión Bolsa:");
        lblBolsa.setBounds(50, 200, 120, 30);
        getContentPane().add(lblBolsa);

        txtDonacion = new JTextField();
        txtDonacion.setBounds(180, 50, 100, 30);
        txtDonacion.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDonacion.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDonacion);

        txtCentroSalud = new JTextField();
        txtCentroSalud.setBounds(180, 100, 100, 30);
        txtCentroSalud.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCentroSalud.setMargin(new Insets(5, 5, 5, 5));
        txtCentroSalud.setEditable(false);
        getContentPane().add(txtCentroSalud);

        txtComedorNinos = new JTextField();
        txtComedorNinos.setBounds(180, 150, 100, 30);
        txtComedorNinos.setHorizontalAlignment(SwingConstants.RIGHT);
        txtComedorNinos.setMargin(new Insets(5, 5, 5, 5));
        txtComedorNinos.setEditable(false);
        getContentPane().add(txtComedorNinos);

        txtBolsa = new JTextField();
        txtBolsa.setBounds(180, 200, 100, 30);
        txtBolsa.setHorizontalAlignment(SwingConstants.RIGHT);
        txtBolsa.setMargin(new Insets(5, 5, 5, 5));
        txtBolsa.setEditable(false);
        getContentPane().add(txtBolsa);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 250, 120, 30);
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
        double donacion = Double.parseDouble(txtDonacion.getText());

        double factorCentroSalud = 0.25 + 0.05 * Math.floor(donacion / 10000);
        double factorComedorNinos = 0.60 - 0.10 * Math.floor(donacion / 10000);
        double factorBolsa = 1 - (factorCentroSalud + factorComedorNinos);

        double montoCentroSalud = donacion * factorCentroSalud;
        double montoComedorNinos = donacion * factorComedorNinos;
        double montoBolsa = donacion * factorBolsa;

        txtCentroSalud.setText(String.format("$ %.2f", montoCentroSalud));
        txtComedorNinos.setText(String.format("$ %.2f", montoComedorNinos));
        txtBolsa.setText(String.format("$ %.2f", montoBolsa));
    }
}