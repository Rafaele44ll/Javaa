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

public class frm20 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtA, txtB, txtC, txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm20 frame = new frm20();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm20() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblA = new JLabel("Número A:");
        lblA.setBounds(50, 50, 80, 30);
        getContentPane().add(lblA);

        JLabel lblB = new JLabel("Número B:");
        lblB.setBounds(50, 90, 80, 30);
        getContentPane().add(lblB);

        JLabel lblC = new JLabel("Número C:");
        lblC.setBounds(50, 130, 80, 30);
        getContentPane().add(lblC);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(50, 170, 80, 30);
        getContentPane().add(lblResultado);

        txtA = new JTextField();
        txtA.setBounds(130, 50, 60, 30);
        txtA.setHorizontalAlignment(SwingConstants.RIGHT);
        txtA.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtA);

        txtB = new JTextField();
        txtB.setBounds(130, 90, 60, 30);
        txtB.setHorizontalAlignment(SwingConstants.RIGHT);
        txtB.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtB);

        txtC = new JTextField();
        txtC.setBounds(130, 130, 60, 30);
        txtC.setHorizontalAlignment(SwingConstants.RIGHT);
        txtC.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtC);

        txtResultado = new JTextField();
        txtResultado.setBounds(130, 170, 100, 30);
        txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtResultado);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 210, 100, 30);
        btnCalcular.setMnemonic('a');
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        int a = Integer.parseInt(txtA.getText());
        int b = Integer.parseInt(txtB.getText());
        int c = Integer.parseInt(txtC.getText());

        int ascendente = (a <= b ? 0 : 1) + (b <= c ? 0 : 1);
        int descendente = (a >= b ? 0 : 1) + (b >= c ? 0 : 1);

        String resultado = ascendente == 0 ? "Ascendente" : descendente == 0 ? "Descendente" : "Desordenado";
        txtResultado.setText(resultado);
    }
}