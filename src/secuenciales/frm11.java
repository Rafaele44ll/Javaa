package secuenciales;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm11 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero1, txtNumero2, txtResultado1, txtResultado2;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm11 frame = new frm11();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm11() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero1 = new JLabel("Número 1 (3 cifras):");
        lblNumero1.setBounds(50, 30, 130, 30);
        getContentPane().add(lblNumero1);

        txtNumero1 = new JTextField();
        txtNumero1.setBounds(200, 30, 80, 30);
        txtNumero1.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtNumero1);

        JLabel lblNumero2 = new JLabel("Número 2 (3 cifras):");
        lblNumero2.setBounds(50, 80, 130, 30);
        getContentPane().add(lblNumero2);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(200, 80, 80, 30);
        txtNumero2.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtNumero2);

        JButton btnIntercambiar = new JButton("Intercambiar");
        btnIntercambiar.setBounds(100, 130, 130, 30);
        getContentPane().add(btnIntercambiar);

        txtResultado1 = new JTextField();
        txtResultado1.setBounds(50, 180, 130, 30);
        txtResultado1.setEditable(false);
        txtResultado1.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(txtResultado1);

        txtResultado2 = new JTextField();
        txtResultado2.setBounds(200, 180, 130, 30);
        txtResultado2.setEditable(false);
        txtResultado2.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(txtResultado2);

        btnIntercambiar.addActionListener(e -> btnIntercambiar_actionPerformed());
    }

    protected void btnIntercambiar_actionPerformed() {
        int numero1 = Integer.parseInt(txtNumero1.getText());
        int numero2 = Integer.parseInt(txtNumero2.getText());

        int cientos1 = numero1 / 100;
        int decenas1 = (numero1 / 10) % 10;
        int unidades1 = numero1 % 10;

        int cientos2 = numero2 / 100;
        int decenas2 = (numero2 / 10) % 10;
        int unidades2 = numero2 % 10;

        int resultado1 = cientos2 * 100 + decenas1 * 10 + unidades2;
        int resultado2 = cientos1 * 100 + decenas2 * 10 + unidades1;

        txtResultado1.setText(String.valueOf(resultado1));
        txtResultado2.setText(String.valueOf(resultado2));
    }
}