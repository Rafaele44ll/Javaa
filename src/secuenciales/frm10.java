package secuenciales;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm10 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero, txtInverso;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm10 frame = new frm10();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("unused")
    public frm10() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("Número (4 cifras) :");
        lblNumero.setBounds(50, 50, 120, 30);
        getContentPane().add(lblNumero);

        JLabel lblInverso = new JLabel("Número Inverso :");
        lblInverso.setBounds(50, 100, 120, 30);
        getContentPane().add(lblInverso);

        txtNumero = new JTextField();
        txtNumero.setBounds(180, 50, 80, 30);
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtNumero);

        txtInverso = new JTextField();
        txtInverso.setBounds(180, 100, 80, 30);
        txtInverso.setFocusable(false);
        txtInverso.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtInverso);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(125, 150, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        try {
            int numero = Integer.parseInt(txtNumero.getText());

            int millares = numero / 1000;
            int centenas = (numero % 1000) / 100;
            int decenas = (numero % 100) / 10;
            int unidades = numero % 10;

            int inverso = unidades * 1000 + decenas * 100 + centenas * 10 + millares;

            txtInverso.setText(String.valueOf(inverso));
        } catch (NumberFormatException e) {
            txtInverso.setText("Error");
        }
    }
}