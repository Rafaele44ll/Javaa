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

public class frm24 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtVentas, txtSueldo;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm24 frame = new frm24();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm24() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblVentas = new JLabel("Monto de Ventas:");
        lblVentas.setBounds(50, 50, 150, 30);
        getContentPane().add(lblVentas);

        JLabel lblSueldo = new JLabel("Sueldo Total:");
        lblSueldo.setBounds(50, 100, 150, 30);
        getContentPane().add(lblSueldo);

        txtVentas = new JTextField();
        txtVentas.setBounds(200, 50, 100, 30);
        txtVentas.setHorizontalAlignment(SwingConstants.RIGHT);
        txtVentas.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtVentas);

        txtSueldo = new JTextField();
        txtSueldo.setBounds(200, 100, 100, 30);
        txtSueldo.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldo.setEditable(false);
        txtSueldo.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtSueldo);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 150, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        double ventas = Double.parseDouble(txtVentas.getText());

        // Cálculo de sueldo base (10% de las ventas)
        double sueldoBase = ventas * 0.10;

        // Cálculo del bono adicional
        double exceso = Math.max(ventas - 5000, 0);
        double bono = (Math.floor(exceso / 500)) * 25;

        // Cálculo del sueldo total
        double sueldoTotal = sueldoBase + bono;

        // Mostrar resultado
        txtSueldo.setText(String.format("S/ %.2f", sueldoTotal));
    }
}
