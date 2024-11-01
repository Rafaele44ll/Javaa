package repetitivos;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class frm04 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero;
    JTextField txtMultiplo;
    JTextField txtResultado;
    String resultado;

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
        setBounds(0, 0, 300, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        txtNumero = new JTextField();
        txtNumero.setBounds(20, 20, 100, 30);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        txtMultiplo = new JTextField();
        txtMultiplo.setBounds(140, 20, 100, 30);
        txtMultiplo.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMultiplo);

        JButton btnCalcular = new JButton("Calcular Múltiplos");
        btnCalcular.setBounds(20, 70, 220, 30);
        btnCalcular.addActionListener(e -> calcularMultiplo());
        getContentPane().add(btnCalcular);

        txtResultado = new JTextField();
        txtResultado.setBounds(20, 120, 220, 70);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);
    }

    protected void calcularMultiplo() {
        int n = Integer.parseInt(txtNumero.getText());
        int m = Integer.parseInt(txtMultiplo.getText());
        resultado = "";

        for (int i = 1; i <= m; i++) {
            resultado += (n * i) + "\n";
        }

        txtResultado.setText(resultado);
    }
}
