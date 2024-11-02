package repetitivos;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class frm05 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero;
    JTextField txtResultado;
    String resultado;

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
        setBounds(0, 0, 300, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        txtNumero = new JTextField();
        txtNumero.setBounds(20, 20, 100, 30);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        JButton btnGenerar = new JButton("Generar Tabla");
        btnGenerar.setBounds(140, 20, 120, 30);
        btnGenerar.addActionListener(e -> generarTablaMultiplicar());
        getContentPane().add(btnGenerar);

        txtResultado = new JTextField();
        txtResultado.setBounds(20, 70, 240, 170);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);
    }

    protected void generarTablaMultiplicar() {
        int n = Integer.parseInt(txtNumero.getText());
        resultado = "";

        for (int i = 1; i <= 12; i++) {
            resultado += n + " x " + i + " = " + (n * i) + "\n";
        }

        txtResultado.setText(resultado);
    }
}
