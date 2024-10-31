package condicionales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm13 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero, txtResultado;

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

    public frm13() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("Número (100-999):");
        lblNumero.setBounds(50, 50, 120, 30);
        getContentPane().add(lblNumero);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(50, 100, 80, 30);
        getContentPane().add(lblResultado);

        txtNumero = new JTextField();
        txtNumero.setBounds(180, 50, 60, 30);
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        txtResultado = new JTextField();
        txtResultado.setBounds(130, 100, 120, 30);
        txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);

        JButton btnDeterminar = new JButton("Determinar");
        btnDeterminar.setBounds(90, 150, 120, 30);
        btnDeterminar.setMnemonic('D');
        getContentPane().add(btnDeterminar);

        btnDeterminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDeterminar_actionPerformed();
            }
        });
    }

    protected void btnDeterminar_actionPerformed() {
        int numero = Integer.parseInt(txtNumero.getText());

        int centena = numero / 100;
        int decena = (numero / 10) % 10;
        int unidad = numero % 10;

        int ascendente = (centena + 1 == decena && decena + 1 == unidad) ? 1 : 0;
        int descendente = (centena - 1 == decena && decena - 1 == unidad) ? 1 : 0;

        String resultado = (ascendente + descendente > 0) ? "Consecutivas" : "No consecutivas";
        txtResultado.setText(resultado);
    }
}