package secuenciales;

import java.awt.EventQueue;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm07 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtBase, txtAltura, txtArea, txtPerimetro;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm07 frame = new frm07();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("unused")
    public frm07() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblBase = new JLabel("Base (b) :");
        lblBase.setBounds(50, 50, 100, 30);
        getContentPane().add(lblBase);

        JLabel lblAltura = new JLabel("Altura (h) :");
        lblAltura.setBounds(50, 100, 100, 30);
        getContentPane().add(lblAltura);

        JLabel lblArea = new JLabel("Área :");
        lblArea.setBounds(50, 150, 100, 30);
        getContentPane().add(lblArea);

        JLabel lblPerimetro = new JLabel("Perímetro :");
        lblPerimetro.setBounds(50, 200, 100, 30);
        getContentPane().add(lblPerimetro);

        txtBase = new JTextField();
        txtBase.setBounds(150, 50, 80, 30);
        txtBase.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtBase);

        txtAltura = new JTextField();
        txtAltura.setBounds(150, 100, 80, 30);
        txtAltura.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtAltura);

        txtArea = new JTextField();
        txtArea.setBounds(150, 150, 80, 30);
        txtArea.setFocusable(false);
        txtArea.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtArea);

        txtPerimetro = new JTextField();
        txtPerimetro.setBounds(150, 200, 80, 30);
        txtPerimetro.setFocusable(false);
        txtPerimetro.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPerimetro);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 250, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        try {
            double base = Double.parseDouble(txtBase.getText());
            double altura = Double.parseDouble(txtAltura.getText());

            double area = base * altura;
            double perimetro = 2 * (base + altura);

            DecimalFormat df = new DecimalFormat("###.##");
            txtArea.setText(df.format(area));
            txtPerimetro.setText(df.format(perimetro));
        } catch (NumberFormatException e) {
            txtArea.setText("Error");
            txtPerimetro.setText("Error");
        }
    }
}