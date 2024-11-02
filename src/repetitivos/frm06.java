package repetitivos;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class frm06 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero;
    JTextField txtDesde;
    JTextField txtHasta;
    JTextField txtResultado;
    String resultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm06 frame = new frm06();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("unused")
    public frm06() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        txtNumero = new JTextField();
        txtNumero.setBounds(20, 20, 80, 30);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        txtDesde = new JTextField();
        txtDesde.setBounds(120, 20, 80, 30);
        txtDesde.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDesde);

        txtHasta = new JTextField();
        txtHasta.setBounds(220, 20, 80, 30);
        txtHasta.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtHasta);

        JButton btnGenerar = new JButton("Generar Tabla");
        btnGenerar.setBounds(20, 70, 280, 30);
        btnGenerar.addActionListener(e -> generarTablaMultiplicarRango());
        getContentPane().add(btnGenerar);

        txtResultado = new JTextField();
        txtResultado.setBounds(20, 120, 280, 150);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);
    }

    protected void generarTablaMultiplicarRango() {
        int n = Integer.parseInt(txtNumero.getText());
        int desde = Integer.parseInt(txtDesde.getText());
        int hasta = Integer.parseInt(txtHasta.getText());
        resultado = "";

        for (int i = desde; i <= hasta; i++) {
            resultado += n + " x " + i + " = " + (n * i) + "\n";
        }

        txtResultado.setText(resultado);
    }
}
