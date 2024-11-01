package repetitivos;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frm01 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtDividendo;
    private JTextField txtDivisor;
    private JTextField txtCociente;
    private JTextField txtResto;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm01 frame = new frm01();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("unused")
    public frm01() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblDividendo = new JLabel("Dividendo:");
        lblDividendo.setBounds(20, 20, 100, 30);
        add(lblDividendo);

        txtDividendo = new JTextField();
        txtDividendo.setBounds(120, 20, 150, 30);
        add(txtDividendo);

        JLabel lblDivisor = new JLabel("Divisor:");
        lblDivisor.setBounds(20, 70, 100, 30);
        add(lblDivisor);

        txtDivisor = new JTextField();
        txtDivisor.setBounds(120, 70, 150, 30);
        add(txtDivisor);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(20, 120, 250, 30);
        btnCalcular.addActionListener(e -> calcularDivision());
        add(btnCalcular);

        JLabel lblCociente = new JLabel("Cociente:");
        lblCociente.setBounds(20, 170, 100, 30);
        add(lblCociente);

        txtCociente = new JTextField();
        txtCociente.setBounds(120, 170, 150, 30);
        txtCociente.setEditable(false);
        add(txtCociente);

        JLabel lblResto = new JLabel("Resto:");
        lblResto.setBounds(20, 210, 100, 30);
        add(lblResto);

        txtResto = new JTextField();
        txtResto.setBounds(120, 210, 150, 30);
        txtResto.setEditable(false);
        add(txtResto);
    }

    private void calcularDivision() {
        int dividendo = Integer.parseInt(txtDividendo.getText());
        int divisor = Integer.parseInt(txtDivisor.getText());
        int cociente = 0;
        int resto = dividendo;

        while (resto >= divisor) {
            resto -= divisor;
            cociente++;
        }

        txtCociente.setText(String.valueOf(cociente));
        txtResto.setText(String.valueOf(resto));
    }
}
