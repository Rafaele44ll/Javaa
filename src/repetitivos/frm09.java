package repetitivos;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class frm09 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtAltura;
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
        setBounds(0, 0, 300, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        txtAltura = new JTextField();
        txtAltura.setBounds(20, 20, 100, 30);
        txtAltura.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtAltura);

        JButton btnGenerar = new JButton("Generar Rectángulo");
        btnGenerar.setBounds(140, 20, 120, 30);
        btnGenerar.addActionListener(e -> generarRectangulo());
        getContentPane().add(btnGenerar);

        txtResultado = new JTextField();
        txtResultado.setBounds(20, 70, 240, 150);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);
    }

    protected void generarRectangulo() {
        int n = Integer.parseInt(txtAltura.getText());
        if (n < 4) {
            txtResultado.setText("La altura debe ser >= 4.");
            return;
        }

        StringBuilder rectangulo = new StringBuilder();
        int ancho = 2 * n;

        for (int i = 0; i < n; i++) {
            rectangulo.append("*".repeat(ancho)).append("\n");
        }

        txtResultado.setText(rectangulo.toString());
    }
}
