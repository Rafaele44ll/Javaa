package recursivos;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class frm05 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtN;
    JTextField txtK;
    JTextField txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm05 frame = new frm05();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("unused")
    public frm05() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        txtN = new JTextField();
        txtN.setBounds(20, 20, 240, 30);
        txtN.setMargin(new Insets(5, 5, 5, 5));
        txtN.setToolTipText("Ingrese el valor de n");
        getContentPane().add(txtN);

        txtK = new JTextField();
        txtK.setBounds(20, 60, 240, 30);
        txtK.setMargin(new Insets(5, 5, 5, 5));
        txtK.setToolTipText("Ingrese el valor de k");
        getContentPane().add(txtK);

        JButton btnCalcular = new JButton("Calcular Combinación");
        btnCalcular.setBounds(20, 100, 200, 30);
        btnCalcular.addActionListener(e -> calcularCombinacion());
        getContentPane().add(btnCalcular);

        txtResultado = new JTextField();
        txtResultado.setBounds(20, 140, 240, 30);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);
    }

    protected void calcularCombinacion() {
        int n = Integer.parseInt(txtN.getText());
        int k = Integer.parseInt(txtK.getText());
        long resultado = combinacion(n, k);
        txtResultado.setText("Combinación: " + resultado);
    }

    protected long combinacion(int n, int k) {
        if (k == 0 || k == n)
            return 1;
        return combinacion(n - 1, k - 1) + combinacion(n - 1, k);
    }
}
