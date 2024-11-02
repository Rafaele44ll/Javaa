package recursivos;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class frm09 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero1;
    JTextField txtNumero2;
    JTextField txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm09 frame = new frm09();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("unused")
    public frm09() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        txtNumero1 = new JTextField();
        txtNumero1.setBounds(20, 20, 240, 30);
        txtNumero1.setMargin(new Insets(5, 5, 5, 5));
        txtNumero1.setToolTipText("Ingrese el primer número");
        getContentPane().add(txtNumero1);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(20, 60, 240, 30);
        txtNumero2.setMargin(new Insets(5, 5, 5, 5));
        txtNumero2.setToolTipText("Ingrese el segundo número");
        getContentPane().add(txtNumero2);

        JButton btnCalcular = new JButton("Calcular MCD");
        btnCalcular.setBounds(20, 100, 200, 30);
        btnCalcular.addActionListener(e -> calcularMCD());
        getContentPane().add(btnCalcular);

        txtResultado = new JTextField();
        txtResultado.setBounds(20, 140, 240, 30);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);
    }

    protected void calcularMCD() {
        int numero1 = Integer.parseInt(txtNumero1.getText());
        int numero2 = Integer.parseInt(txtNumero2.getText());
        int resultado = mcd(Math.abs(numero1), Math.abs(numero2));
        txtResultado.setText("MCD: " + resultado);
    }

    protected int mcd(int a, int b) {
        if (b == 0)
            return a;
        return mcd(b, a % b);
    }
}
