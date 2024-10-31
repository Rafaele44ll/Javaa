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

public class frm10 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField[] txtNotas;
    JTextField txtNotaMayor, txtNotaMenor, txtPromedio;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm10 frame = new frm10();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm10() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNotas = new JLabel("Ingrese 5 notas:");
        lblNotas.setBounds(50, 20, 150, 30);
        getContentPane().add(lblNotas);

        txtNotas = new JTextField[5];
        for (int i = 0; i < 5; i++) {
            txtNotas[i] = new JTextField();
            txtNotas[i].setBounds(50, 60 + (i * 30), 60, 30);
            txtNotas[i].setHorizontalAlignment(SwingConstants.RIGHT);
            txtNotas[i].setMargin(new Insets(5, 5, 5, 5));
            getContentPane().add(txtNotas[i]);
        }

        JLabel lblNotaMayor = new JLabel("Nota Mayor:");
        lblNotaMayor.setBounds(150, 60, 100, 30);
        getContentPane().add(lblNotaMayor);

        txtNotaMayor = new JTextField();
        txtNotaMayor.setBounds(250, 60, 60, 30);
        txtNotaMayor.setEditable(false);
        getContentPane().add(txtNotaMayor);

        JLabel lblNotaMenor = new JLabel("Nota Menor:");
        lblNotaMenor.setBounds(150, 100, 100, 30);
        getContentPane().add(lblNotaMenor);

        txtNotaMenor = new JTextField();
        txtNotaMenor.setBounds(250, 100, 60, 30);
        txtNotaMenor.setEditable(false);
        getContentPane().add(txtNotaMenor);

        JLabel lblPromedio = new JLabel("Promedio:");
        lblPromedio.setBounds(150, 140, 100, 30);
        getContentPane().add(lblPromedio);

        txtPromedio = new JTextField();
        txtPromedio.setBounds(250, 140, 60, 30);
        txtPromedio.setEditable(false);
        getContentPane().add(txtPromedio);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 200, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        double[] notas = new double[5];
        for (int i = 0; i < 5; i++) {
            notas[i] = Double.parseDouble(txtNotas[i].getText());
        }

        double notaMayor = notas[0];
        double notaMenor = notas[0];
        for (int i = 1; i < 5; i++) {
            if (notas[i] > notaMayor) {
                notaMayor = notas[i];
            }
            if (notas[i] < notaMenor) {
                notaMenor = notas[i];
            }
        }

        double sumaNotas = 0;
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (notas[i] != notaMayor && notas[i] != notaMenor) {
                sumaNotas += notas[i];
                count++;
            }
        }
        double promedio = sumaNotas / count;

        txtNotaMayor.setText(String.valueOf(notaMayor));
        txtNotaMenor.setText(String.valueOf(notaMenor));
        txtPromedio.setText(String.format("%.2f", promedio));
    }
}
