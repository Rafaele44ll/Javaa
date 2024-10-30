package secuenciales;

import java.awt.EventQueue;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm06 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtRadio, txtAltura, txtArea, txtVolumen;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm06 frame = new frm06();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm06() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblRadio = new JLabel("Radio (r) :");
        lblRadio.setBounds(50, 50, 100, 30);
        getContentPane().add(lblRadio);

        JLabel lblAltura = new JLabel("Altura (h) :");
        lblAltura.setBounds(50, 100, 100, 30);
        getContentPane().add(lblAltura);

        JLabel lblArea = new JLabel("Área Total :");
        lblArea.setBounds(50, 150, 100, 30);
        getContentPane().add(lblArea);

        JLabel lblVolumen = new JLabel("Volumen :");
        lblVolumen.setBounds(50, 200, 100, 30);
        getContentPane().add(lblVolumen);

        txtRadio = new JTextField();
        txtRadio.setBounds(150, 50, 80, 30);
        txtRadio.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtRadio);

        txtAltura = new JTextField();
        txtAltura.setBounds(150, 100, 80, 30);
        txtAltura.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtAltura);

        txtArea = new JTextField();
        txtArea.setBounds(150, 150, 80, 30);
        txtArea.setFocusable(false);
        txtArea.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtArea);

        txtVolumen = new JTextField();
        txtVolumen.setBounds(150, 200, 80, 30);
        txtVolumen.setFocusable(false);
        txtVolumen.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtVolumen);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 250, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        try {
            double radio = Double.parseDouble(txtRadio.getText());
            double altura = Double.parseDouble(txtAltura.getText());

            double area = 2 * Math.PI * radio * (radio + altura);
            double volumen = Math.PI * Math.pow(radio, 2) * altura;

            DecimalFormat df = new DecimalFormat("###.##");
            txtArea.setText(df.format(area));
            txtVolumen.setText(df.format(volumen));
        } catch (NumberFormatException e) {
            txtArea.setText("Error");
            txtVolumen.setText("Error");
        }
    }
}