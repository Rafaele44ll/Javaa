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

public class frm30 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtCuota, txtDiaPago, txtTotalPagar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm30 frame = new frm30();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm30() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCuota = new JLabel("Cuota Mensual:");
        lblCuota.setBounds(50, 50, 150, 30);
        getContentPane().add(lblCuota);

        JLabel lblDiaPago = new JLabel("Día de Pago:");
        lblDiaPago.setBounds(50, 90, 150, 30);
        getContentPane().add(lblDiaPago);

        JLabel lblTotalPagar = new JLabel("Total a Pagar:");
        lblTotalPagar.setBounds(50, 170, 150, 30);
        getContentPane().add(lblTotalPagar);

        txtCuota = new JTextField();
        txtCuota.setBounds(200, 50, 100, 30);
        txtCuota.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCuota.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCuota);

        txtDiaPago = new JTextField();
        txtDiaPago.setBounds(200, 90, 100, 30);
        txtDiaPago.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDiaPago.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDiaPago);

        txtTotalPagar = new JTextField();
        txtTotalPagar.setBounds(200, 170, 100, 30);
        txtTotalPagar.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTotalPagar.setEditable(false);
        txtTotalPagar.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtTotalPagar);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 220, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        double cuota = Double.parseDouble(txtCuota.getText());
        int diaPago = Integer.parseInt(txtDiaPago.getText());

        double descuento = Math.max(5, 0.02 * cuota) * ((diaPago <= 10) ? 1 : 0);
        double recargo = Math.max(10, 0.03 * cuota) * ((diaPago > 20) ? 1 : 0);

        double totalPagar = cuota - descuento + recargo;

        txtTotalPagar.setText(String.format("$ %.2f", totalPagar));
    }
}