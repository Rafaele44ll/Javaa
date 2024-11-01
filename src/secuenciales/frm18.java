package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm18 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtUnidades, txtPrecioUnitario;
    JTextField txtImporteCompra, txtDescuentoTotal, txtImportePagar;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm18 frame = new frm18();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @SuppressWarnings("unused")
    public frm18() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblUnidades = new JLabel("Unidades:");
        lblUnidades.setBounds(50, 50, 150, 30);
        getContentPane().add(lblUnidades);

        txtUnidades = new JTextField();
        txtUnidades.setBounds(200, 50, 100, 30);
        txtUnidades.setHorizontalAlignment(SwingConstants.RIGHT);
        txtUnidades.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtUnidades);

        JLabel lblPrecioUnitario = new JLabel("Precio Unitario:");
        lblPrecioUnitario.setBounds(50, 100, 150, 30);
        getContentPane().add(lblPrecioUnitario);

        txtPrecioUnitario = new JTextField();
        txtPrecioUnitario.setBounds(200, 100, 100, 30);
        txtPrecioUnitario.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPrecioUnitario.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPrecioUnitario);

        JButton btnCalcular = new JButton("Calcular Descuento");
        btnCalcular.setBounds(50, 150, 250, 30);
        getContentPane().add(btnCalcular);

        txtImporteCompra = new JTextField();
        txtImporteCompra.setBounds(50, 200, 250, 30);
        txtImporteCompra.setHorizontalAlignment(SwingConstants.RIGHT);
        txtImporteCompra.setEditable(false);
        getContentPane().add(txtImporteCompra);

        txtDescuentoTotal = new JTextField();
        txtDescuentoTotal.setBounds(50, 250, 250, 30);
        txtDescuentoTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuentoTotal.setEditable(false);
        getContentPane().add(txtDescuentoTotal);

        txtImportePagar = new JTextField();
        txtImportePagar.setBounds(50, 300, 250, 30);
        txtImportePagar.setHorizontalAlignment(SwingConstants.RIGHT);
        txtImportePagar.setEditable(false);
        getContentPane().add(txtImportePagar);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        int unidades = Integer.parseInt(txtUnidades.getText());
        double precioUnitario = Double.parseDouble(txtPrecioUnitario.getText());

        double importeCompra = unidades * precioUnitario;

        double primerDescuento = importeCompra * 0.15;
        double importeTrasPrimerDescuento = importeCompra - primerDescuento;

        double segundoDescuento = importeTrasPrimerDescuento * 0.15;
        double descuentoTotal = primerDescuento + segundoDescuento;

        double importePagar = importeCompra - descuentoTotal;

        DecimalFormat df = new DecimalFormat("###.##");
        txtImporteCompra.setText("Importe de Compra: " + df.format(importeCompra));
        txtDescuentoTotal.setText("Descuento Total: " + df.format(descuentoTotal));
        txtImportePagar.setText("Importe a Pagar: " + df.format(importePagar));
    }
}
