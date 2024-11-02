package repetitivos;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class frm13 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtEntrada;
    JTextField txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm13 frame = new frm13();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("unused")
    public frm13() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        txtEntrada = new JTextField();
        txtEntrada.setBounds(20, 20, 240, 30);
        txtEntrada.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtEntrada);

        JButton btnCalcular = new JButton("Calcular Suma");
        btnCalcular.setBounds(20, 60, 150, 30);
        btnCalcular.addActionListener(e -> calcularSuma());
        getContentPane().add(btnCalcular);

        txtResultado = new JTextField();
        txtResultado.setBounds(20, 100, 240, 30);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);
    }

    protected void calcularSuma() {
        String entrada = txtEntrada.getText();
        int n = Integer.parseInt(entrada);
        int suma = sumaMultiplo3No5(n);
        txtResultado.setText("Suma: " + suma);
    }

    protected int sumaMultiplo3No5(int n) {
        int suma = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                suma += i;
            }
        }

        return suma;
    }
}
