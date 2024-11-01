package secuenciales;

import java.awt.EventQueue;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm08 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtRadio, txtAltura, txtAreaBase, txtAreaLateral, txtAreaTotal;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm08 frame = new frm08();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("unused")
    public frm08() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblRadio = new JLabel("Radio (r) :");
        lblRadio.setBounds(50, 50, 100, 30);
        getContentPane().add(lblRadio);

        JLabel lblAltura = new JLabel("Altura (h) :");
        lblAltura.setBounds(50, 100, 100, 30);
        getContentPane().add(lblAltura);

        JLabel lblAreaBase = new JLabel("Área Base :");
        lblAreaBase.setBounds(50, 150, 100, 30);
        getContentPane().add(lblAreaBase);

        JLabel lblAreaLateral = new JLabel("Área Lateral :");
        lblAreaLateral.setBounds(50, 200, 100, 30);
        getContentPane().add(lblAreaLateral);

        JLabel lblAreaTotal = new JLabel("Área Total :");
        lblAreaTotal.setBounds(50, 250, 100, 30);
        getContentPane().add(lblAreaTotal);

        txtRadio = new JTextField();
        txtRadio.setBounds(150, 50, 80, 30);
        txtRadio.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtRadio);

        txtAltura = new JTextField();
        txtAltura.setBounds(150, 100, 80, 30);
        txtAltura.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtAltura);

        txtAreaBase = new JTextField();
        txtAreaBase.setBounds(150, 150, 80, 30);
        txtAreaBase.setFocusable(false);
        txtAreaBase.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtAreaBase);

        txtAreaLateral = new JTextField();
        txtAreaLateral.setBounds(150, 200, 80, 30);
        txtAreaLateral.setFocusable(false);
        txtAreaLateral.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtAreaLateral);

        txtAreaTotal = new JTextField();
        txtAreaTotal.setBounds(150, 250, 80, 30);
        txtAreaTotal.setFocusable(false);
        txtAreaTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtAreaTotal);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 300, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        try {
            double radio = Double.parseDouble(txtRadio.getText());
            double altura = Double.parseDouble(txtAltura.getText());

            double areaBase = Math.PI * Math.pow(radio, 2);
            double areaLateral = 2 * Math.PI * radio * altura;
            double areaTotal = 2 * areaBase + areaLateral;

            DecimalFormat df = new DecimalFormat("###.##");
            txtAreaBase.setText(df.format(areaBase));
            txtAreaLateral.setText(df.format(areaLateral));
            txtAreaTotal.setText(df.format(areaTotal));
        } catch (NumberFormatException e) {
            txtAreaBase.setText("Error");
            txtAreaLateral.setText("Error");
            txtAreaTotal.setText("Error");
        }
    }
}