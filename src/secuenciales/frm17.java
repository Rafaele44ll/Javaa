package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm17 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtDonacionTotal;
    JTextField txtCentroSalud, txtComedorInfantil, txtEscuelaInfantil, txtAsiloAncianos;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm17 frame = new frm17();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @SuppressWarnings("unused")
    public frm17() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblDonacionTotal = new JLabel("Donación Total:");
        lblDonacionTotal.setBounds(50, 50, 150, 30);
        getContentPane().add(lblDonacionTotal);

        txtDonacionTotal = new JTextField();
        txtDonacionTotal.setBounds(200, 50, 100, 30);
        txtDonacionTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDonacionTotal.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDonacionTotal);

        JButton btnCalcular = new JButton("Calcular Asignaciones");
        btnCalcular.setBounds(50, 100, 250, 30);
        getContentPane().add(btnCalcular);

        txtCentroSalud = new JTextField();
        txtCentroSalud.setBounds(50, 150, 250, 30);
        txtCentroSalud.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCentroSalud.setEditable(false);
        getContentPane().add(txtCentroSalud);

        txtComedorInfantil = new JTextField();
        txtComedorInfantil.setBounds(50, 200, 250, 30);
        txtComedorInfantil.setHorizontalAlignment(SwingConstants.RIGHT);
        txtComedorInfantil.setEditable(false);
        getContentPane().add(txtComedorInfantil);

        txtEscuelaInfantil = new JTextField();
        txtEscuelaInfantil.setBounds(50, 250, 250, 30);
        txtEscuelaInfantil.setHorizontalAlignment(SwingConstants.RIGHT);
        txtEscuelaInfantil.setEditable(false);
        getContentPane().add(txtEscuelaInfantil);

        txtAsiloAncianos = new JTextField();
        txtAsiloAncianos.setBounds(50, 300, 250, 30);
        txtAsiloAncianos.setHorizontalAlignment(SwingConstants.RIGHT);
        txtAsiloAncianos.setEditable(false);
        getContentPane().add(txtAsiloAncianos);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double donacionTotal = Double.parseDouble(txtDonacionTotal.getText());

        double centroSalud = donacionTotal * 0.25;
        double comedorInfantil = donacionTotal * 0.35;
        double escuelaInfantil = donacionTotal * 0.25;
        double asiloAncianos = donacionTotal * (1 - 0.25 - 0.35 - 0.25);

        DecimalFormat df = new DecimalFormat("###.##");
        txtCentroSalud.setText("Centro de Salud: " + df.format(centroSalud));
        txtComedorInfantil.setText("Comedor Infantil: " + df.format(comedorInfantil));
        txtEscuelaInfantil.setText("Escuela Infantil: " + df.format(escuelaInfantil));
        txtAsiloAncianos.setText("Asilo de Ancianos: " + df.format(asiloAncianos));
    }
}
