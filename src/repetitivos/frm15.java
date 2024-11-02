package repetitivos;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class frm15 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtEntrada;
    JTextField txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm15 frame = new frm15();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("unused")
    public frm15() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        txtEntrada = new JTextField();
        txtEntrada.setBounds(20, 20, 300, 30);
        txtEntrada.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtEntrada);

        JButton btnMayusculas = new JButton("A Mayúsculas");
        btnMayusculas.setBounds(20, 60, 140, 30);
        btnMayusculas.addActionListener(e -> convertirAMayusculas());
        getContentPane().add(btnMayusculas);

        JButton btnMinusculas = new JButton("A Minúsculas");
        btnMinusculas.setBounds(180, 60, 140, 30);
        btnMinusculas.addActionListener(e -> convertirAMinusculas());
        getContentPane().add(btnMinusculas);

        txtResultado = new JTextField();
        txtResultado.setBounds(20, 100, 300, 30);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);
    }

    protected void convertirAMayusculas() {
        String entrada = txtEntrada.getText();
        String resultado = convertirAMayusculas(entrada);
        txtResultado.setText(resultado);
    }

    protected void convertirAMinusculas() {
        String entrada = txtEntrada.getText();
        String resultado = convertirAMinusculas(entrada);
        txtResultado.setText(resultado);
    }

    protected String convertirAMayusculas(String cadena) {
        StringBuilder rpta = new StringBuilder();
        int longitud = cadena.length();

        for (int i = 0; i < longitud; i++) {
            char letra = cadena.charAt(i);
            rpta.append(Character.toUpperCase(letra));
        }

        return rpta.toString();
    }

    protected String convertirAMinusculas(String cadena) {
        StringBuilder rpta = new StringBuilder();
        int longitud = cadena.length();

        for (int i = 0; i < longitud; i++) {
            char letra = cadena.charAt(i);
            rpta.append(Character.toLowerCase(letra));
        }

        return rpta.toString();
    }
}
