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

public class frm17 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtDocenas, txtPrecioPorDocena, txtMontoCompra, txtDescuento, txtTotalPagar, txtLapiceros;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm17 frame = new frm17();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm17() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblDocenas = new JLabel("Docenas:");
        lblDocenas.setBounds(50, 50, 120, 30);
        getContentPane().add(lblDocenas);

        JLabel lblPrecioPorDocena = new JLabel("Precio/Docena:");
        lblPrecioPorDocena.setBounds(50, 90, 120, 30);
        getContentPane().add(lblPrecioPorDocena);

        JLabel lblMontoCompra = new JLabel("Monto Compra:");
        lblMontoCompra.setBounds(50, 130, 120, 30);
        getContentPane().add(lblMontoCompra);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(50, 170, 120, 30);
        getContentPane().add(lblDescuento);

        JLabel lblTotalPagar = new JLabel("Total a Pagar:");
        lblTotalPagar.setBounds(50, 210, 120, 30);
        getContentPane().add(lblTotalPagar);

        JLabel lblLapiceros = new JLabel("Lapiceros:");
        lblLapiceros.setBounds(50, 250, 120, 30);
        getContentPane().add(lblLapiceros);

        txtDocenas = new JTextField();
        txtDocenas.setBounds(180, 50, 100, 30);
        txtDocenas.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDocenas.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDocenas);

        txtPrecioPorDocena = new JTextField();
        txtPrecioPorDocena.setBounds(180, 90, 100, 30);
        txtPrecioPorDocena.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPrecioPorDocena.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPrecioPorDocena);

        txtMontoCompra = new JTextField();
        txtMontoCompra.setBounds(180, 130, 100, 30);
        txtMontoCompra.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMontoCompra.setMargin(new Insets(5, 5, 5, 5));
        txtMontoCompra.setEditable(false);
        getContentPane().add(txtMontoCompra);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(180, 170, 100, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setMargin(new Insets(5, 5, 5, 5));
        txtDescuento.setEditable(false);
        getContentPane().add(txtDescuento);

        txtTotalPagar = new JTextField();
        txtTotalPagar.setBounds(180, 210, 100, 30);
        txtTotalPagar.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTotalPagar.setMargin(new Insets(5, 5, 5, 5));
        txtTotalPagar.setEditable(false);
        getContentPane().add(txtTotalPagar);

        txtLapiceros = new JTextField();
        txtLapiceros.setBounds(180, 250, 100, 30);
        txtLapiceros.setHorizontalAlignment(SwingConstants.RIGHT);
        txtLapiceros.setMargin(new Insets(5, 5, 5, 5));
        txtLapiceros.setEditable(false);
        getContentPane().add(txtLapiceros);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 290, 120, 30);
        btnCalcular.setMnemonic('C');
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        double docenas = Double.parseDouble(txtDocenas.getText());
        double precioPorDocena = Double.parseDouble(txtPrecioPorDocena.getText());

        double montoCompra = docenas * precioPorDocena;

        double factorDescuento = 0.10 + 0.05 * Math.floor(docenas / 6);
        double descuento = montoCompra * factorDescuento;

        double totalPagar = montoCompra - descuento;

        int factorLapiceros = (int) (2 * (Math.floor(docenas / 30) * Math.floor(docenas / 3)));

        txtMontoCompra.setText(String.format("S/ %.2f", montoCompra));
        txtDescuento.setText(String.format("S/ %.2f", descuento));
        txtTotalPagar.setText(String.format("S/ %.2f", totalPagar));
        txtLapiceros.setText(String.format("%d", factorLapiceros));
    }
}