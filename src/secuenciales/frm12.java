package secuenciales;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm12 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtA, txtB, txtC, txtResultado1, txtResultado2;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm12 frame = new frm12();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @SuppressWarnings("unused")
    public frm12() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblA = new JLabel("Coeficiente a:");
        lblA.setBounds(50, 30, 130, 30);
        getContentPane().add(lblA);

        txtA = new JTextField();
        txtA.setBounds(200, 30, 80, 30);
        txtA.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtA);

        JLabel lblB = new JLabel("Coeficiente b:");
        lblB.setBounds(50, 80, 130, 30);
        getContentPane().add(lblB);

        txtB = new JTextField();
        txtB.setBounds(200, 80, 80, 30);
        txtB.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtB);

        JLabel lblC = new JLabel("Coeficiente c:");
        lblC.setBounds(50, 130, 130, 30);
        getContentPane().add(lblC);

        txtC = new JTextField();
        txtC.setBounds(200, 130, 80, 30);
        txtC.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtC);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 180, 130, 30);
        getContentPane().add(btnCalcular);

        txtResultado1 = new JTextField();
        txtResultado1.setBounds(50, 220, 130, 30);
        txtResultado1.setEditable(false);
        txtResultado1.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(txtResultado1);

        txtResultado2 = new JTextField();
        txtResultado2.setBounds(200, 220, 130, 30);
        txtResultado2.setEditable(false);
        txtResultado2.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(txtResultado2);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double a = Double.parseDouble(txtA.getText());
        double b = Double.parseDouble(txtB.getText());
        double c = Double.parseDouble(txtC.getText());

        double discriminante = b * b - 4 * a * c;

        double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);

        txtResultado1.setText(String.valueOf(raiz1));
        txtResultado2.setText(String.valueOf(raiz2));
    }
}