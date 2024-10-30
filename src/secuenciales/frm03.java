package secuenciales;

import java.awt.EventQueue;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm03 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtKilometros, txtPies, txtMillas, txtMetros, txtYardas;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm03 frame = new frm03();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm03() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblKilometros = new JLabel("Kilómetros :");
        lblKilometros.setBounds(50, 50, 80, 30);
        getContentPane().add(lblKilometros);

        JLabel lblPies = new JLabel("Pies :");
        lblPies.setBounds(50, 90, 80, 30);
        getContentPane().add(lblPies);

        JLabel lblMillas = new JLabel("Millas :");
        lblMillas.setBounds(50, 130, 80, 30);
        getContentPane().add(lblMillas);

        JLabel lblMetros = new JLabel("Total en Metros :");
        lblMetros.setBounds(50, 230, 120, 30);
        getContentPane().add(lblMetros);

        JLabel lblYardas = new JLabel("Total en Yardas :");
        lblYardas.setBounds(50, 270, 120, 30);
        getContentPane().add(lblYardas);

        txtKilometros = new JTextField();
        txtKilometros.setBounds(150, 50, 80, 30);
        txtKilometros.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtKilometros);

        txtPies = new JTextField();
        txtPies.setBounds(150, 90, 80, 30);
        txtPies.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPies);

        txtMillas = new JTextField();
        txtMillas.setBounds(150, 130, 80, 30);
        txtMillas.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtMillas);

        txtMetros = new JTextField();
        txtMetros.setBounds(150, 230, 80, 30);
        txtMetros.setFocusable(false);
        txtMetros.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtMetros);

        txtYardas = new JTextField();
        txtYardas.setBounds(150, 270, 80, 30);
        txtYardas.setFocusable(false);
        txtYardas.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtYardas);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 180, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        try {
            double kilometros = Double.parseDouble(txtKilometros.getText());
            double pies = Double.parseDouble(txtPies.getText());
            double millas = Double.parseDouble(txtMillas.getText());

            double metrosDesdeKilometros = kilometros * 1000;

            double metrosDesdePies = pies / 3.2808;

            double metrosDesdeMillas = millas * 1609;

            double totalMetros = metrosDesdeKilometros + metrosDesdePies + metrosDesdeMillas;

            double totalYardas = totalMetros * 1.09361;

            DecimalFormat df = new DecimalFormat("###.##");
            txtMetros.setText(df.format(totalMetros));
            txtYardas.setText(df.format(totalYardas));
        } catch (NumberFormatException e) {
            txtMetros.setText("Error");
            txtYardas.setText("Error");
        }
    }
}
