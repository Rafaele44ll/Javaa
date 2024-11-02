package repetitivos;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class frm07 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero;
    JTextField txtResultado;

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
        setBounds(0, 0, 300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        txtNumero = new JTextField();
        txtNumero.setBounds(20, 20, 100, 30);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        JButton btnCalcular = new JButton("Calcular Factorial");
        btnCalcular.setBounds(140, 20, 120, 30);
        btnCalcular.addActionListener(e -> calcularFactorial());
        getContentPane().add(btnCalcular);

        txtResultado = new JTextField();
        txtResultado.setBounds(20, 70, 240, 30);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);
    }

    protected void calcularFactorial() {
        int n = Integer.parseInt(txtNumero.getText());
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        txtResultado.setText("Factorial de " + n + " = " + factorial);
    }
}
