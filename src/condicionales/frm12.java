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

public class frm12 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumeroDia, txtNombreDia;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm12 frame = new frm12();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm12() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumeroDia = new JLabel("Número (1-7):");
        lblNumeroDia.setBounds(50, 50, 100, 30);
        getContentPane().add(lblNumeroDia);

        JLabel lblNombreDia = new JLabel("Día de la semana:");
        lblNombreDia.setBounds(50, 100, 100, 30);
        getContentPane().add(lblNombreDia);

        txtNumeroDia = new JTextField();
        txtNumeroDia.setBounds(160, 50, 60, 30);
        txtNumeroDia.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumeroDia.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumeroDia);

        txtNombreDia = new JTextField();
        txtNombreDia.setBounds(160, 100, 100, 30);
        txtNombreDia.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNombreDia.setMargin(new Insets(5, 5, 5, 5));
        txtNombreDia.setEditable(false);
        getContentPane().add(txtNombreDia);

        JButton btnDeterminar = new JButton("Determinar");
        btnDeterminar.setBounds(80, 150, 120, 30);
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
        int numeroDia = Integer.parseInt(txtNumeroDia.getText());

        String[] diasSemana = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };

        String nombreDia = (numeroDia >= 1 && numeroDia <= 7) ? diasSemana[numeroDia - 1] : "Inválido";

        txtNombreDia.setText(nombreDia);
    }
}
