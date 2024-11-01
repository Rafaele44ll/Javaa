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

public class frm35 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtCodigo, txtTipoEmpleado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm35 frame = new frm35();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm35() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 210);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(50, 50, 80, 30);
        getContentPane().add(lblCodigo);

        JLabel lblTipoEmpleado = new JLabel("Tipo de Empleado:");
        lblTipoEmpleado.setBounds(50, 90, 120, 30);
        getContentPane().add(lblTipoEmpleado);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 50, 60, 30);
        txtCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCodigo.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCodigo);

        txtTipoEmpleado = new JTextField();
        txtTipoEmpleado.setBounds(160, 90, 100, 30);
        txtTipoEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTipoEmpleado.setMargin(new Insets(5, 5, 5, 5));
        txtTipoEmpleado.setEditable(false);
        getContentPane().add(txtTipoEmpleado);

        JButton btnCalcular = new JButton("Calcular Tipo");
        btnCalcular.setBounds(80, 130, 120, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                determinarTipoEmpleado();
            }
        });
    }

    protected void determinarTipoEmpleado() {
        int codigo = Integer.parseInt(txtCodigo.getText());

        int esDivisiblePor2 = 1 - (codigo % 2);
        int esDivisiblePor3 = 1 - (codigo % 3);
        int esDivisiblePor5 = 1 - (codigo % 5);

        String tipoEmpleado = "Administrativo".repeat(esDivisiblePor2 * esDivisiblePor3 * esDivisiblePor5)
                + "Directivo".repeat((1 - esDivisiblePor2) * esDivisiblePor3 * esDivisiblePor5)
                + "Vendedor".repeat(esDivisiblePor2 * (1 - esDivisiblePor3) * (1 - esDivisiblePor5))
                + "Seguridad".repeat((1 - esDivisiblePor2) * (1 - esDivisiblePor3) * (1 - esDivisiblePor5));

        txtTipoEmpleado.setText(tipoEmpleado);
    }
}
