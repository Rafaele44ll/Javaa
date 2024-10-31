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

public class frm08 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtExamenesAprobados, txtTotalPropina;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm08 frame = new frm08();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm08() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblExamenesAprobados = new JLabel("Exámenes Aprobados:");
        lblExamenesAprobados.setBounds(50, 30, 150, 30);
        getContentPane().add(lblExamenesAprobados);

        JLabel lblTotalPropina = new JLabel("Total Propina:");
        lblTotalPropina.setBounds(50, 90, 100, 30);
        getContentPane().add(lblTotalPropina);

        txtExamenesAprobados = new JTextField();
        txtExamenesAprobados.setBounds(180, 30, 60, 30);
        txtExamenesAprobados.setHorizontalAlignment(SwingConstants.RIGHT);
        txtExamenesAprobados.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtExamenesAprobados);

        txtTotalPropina = new JTextField();
        txtTotalPropina.setBounds(180, 90, 60, 30);
        txtTotalPropina.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTotalPropina.setMargin(new Insets(5, 5, 5, 5));
        txtTotalPropina.setEditable(false);
        getContentPane().add(txtTotalPropina);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(90, 150, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        int examenesAprobados = Integer.parseInt(txtExamenesAprobados.getText());

        int propinaMensual = 20;
        int propinaPorExamen = 5;
        int totalPropina = propinaMensual;

        if (examenesAprobados >= 0 && examenesAprobados <= 3) {
            if (examenesAprobados == 1) {
                totalPropina += propinaPorExamen;
            }

            if (examenesAprobados == 2) {
                totalPropina += 2 * propinaPorExamen;
            }

            if (examenesAprobados == 3) {
                totalPropina += 3 * propinaPorExamen;
            }
        }

        txtTotalPropina.setText(String.valueOf(totalPropina));
    }
}