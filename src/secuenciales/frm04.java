package secuenciales;

import java.awt.EventQueue;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm04 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtPies, txtPulgadas, txtMetros;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm04 frame = new frm04();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("unused")
    public frm04() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblPies = new JLabel("Pies :");
        lblPies.setBounds(50, 50, 80, 30);
        getContentPane().add(lblPies);

        JLabel lblPulgadas = new JLabel("Pulgadas :");
        lblPulgadas.setBounds(50, 90, 80, 30);
        getContentPane().add(lblPulgadas);

        JLabel lblMetros = new JLabel("Estatura en Metros :");
        lblMetros.setBounds(30, 150, 120, 30);
        getContentPane().add(lblMetros);

        txtPies = new JTextField();
        txtPies.setBounds(150, 50, 80, 30);
        txtPies.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPies);

        txtPulgadas = new JTextField();
        txtPulgadas.setBounds(150, 90, 80, 30);
        txtPulgadas.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPulgadas);

        txtMetros = new JTextField();
        txtMetros.setBounds(150, 150, 80, 30);
        txtMetros.setFocusable(false);
        txtMetros.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtMetros);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 120, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        try {
            int pies = Integer.parseInt(txtPies.getText());
            int pulgadas = Integer.parseInt(txtPulgadas.getText());

            double totalPulgadas = (pies * 12) + pulgadas;
            double metros = totalPulgadas * 0.0254;

            DecimalFormat df = new DecimalFormat("###.##");
            txtMetros.setText(df.format(metros));
        } catch (NumberFormatException e) {
            txtMetros.setText("Error");
        }
    }
}