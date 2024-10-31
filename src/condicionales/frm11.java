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

public class frm11 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero, txtSigno;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm11 frame = new frm11();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm11() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("Ingrese un número:");
        lblNumero.setBounds(50, 30, 150, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(50, 70, 100, 30);
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        JLabel lblSigno = new JLabel("El signo es:");
        lblSigno.setBounds(50, 110, 100, 30);
        getContentPane().add(lblSigno);

        txtSigno = new JTextField();
        txtSigno.setBounds(150, 110, 100, 30);
        txtSigno.setEditable(false);
        getContentPane().add(txtSigno);

        JButton btnCalcular = new JButton("Determinar");
        btnCalcular.setBounds(50, 150, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        double numero = Double.parseDouble(txtNumero.getText());
        String signo = "";

        if (numero > 0) {
            signo = "Positivo";
        }

        if (numero < 0) {
            signo = "Negativo";
        }

        if (numero == 0) {
            signo = "Cero";
        }

        txtSigno.setText(signo);
    }
}
