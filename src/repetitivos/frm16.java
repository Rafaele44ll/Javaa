package repetitivos;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class frm16 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtEntrada;
    JTextField txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm16 frame = new frm16();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("unused")
    public frm16() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        txtEntrada = new JTextField();
        txtEntrada.setBounds(20, 20, 240, 30);
        txtEntrada.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtEntrada);

        JButton btnInvertir = new JButton("Invertir Cadena");
        btnInvertir.setBounds(20, 60, 150, 30);
        btnInvertir.addActionListener(e -> invertirCadena());
        getContentPane().add(btnInvertir);

        txtResultado = new JTextField();
        txtResultado.setBounds(20, 100, 240, 30);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);
    }

    protected void invertirCadena() {
        String entrada = txtEntrada.getText();
        String resultado = invertir(entrada);
        txtResultado.setText(resultado);
    }

    protected String invertir(String cadena) {
        String rpta = "";
        int longitud = cadena.length();

        for (int i = longitud - 1; i >= 0; i--) {
            rpta += cadena.charAt(i);
        }

        return rpta;
    }
}
