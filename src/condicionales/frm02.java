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

public class frm02 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtUnidades, txtImporteCompra, txtDescuento, txtTotalPagar, txtCaramelos;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm02 frame = new frm02();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm02() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblUnidades = new JLabel("Unidades:");
        lblUnidades.setBounds(30, 30, 100, 30);
        getContentPane().add(lblUnidades);

        txtUnidades = new JTextField();
        txtUnidades.setBounds(150, 30, 100, 30);
        txtUnidades.setHorizontalAlignment(SwingConstants.RIGHT);
        txtUnidades.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtUnidades);

        JLabel lblImporteCompra = new JLabel("Importe Compra:");
        lblImporteCompra.setBounds(30, 80, 120, 30);
        getContentPane().add(lblImporteCompra);

        txtImporteCompra = new JTextField();
        txtImporteCompra.setBounds(150, 80, 100, 30);
        txtImporteCompra.setHorizontalAlignment(SwingConstants.RIGHT);
        txtImporteCompra.setMargin(new Insets(5, 5, 5, 5));
        txtImporteCompra.setEditable(false);
        getContentPane().add(txtImporteCompra);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(30, 130, 120, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(150, 130, 100, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setMargin(new Insets(5, 5, 5, 5));
        txtDescuento.setEditable(false);
        getContentPane().add(txtDescuento);

        JLabel lblTotalPagar = new JLabel("Total a Pagar:");
        lblTotalPagar.setBounds(30, 180, 120, 30);
        getContentPane().add(lblTotalPagar);

        txtTotalPagar = new JTextField();
        txtTotalPagar.setBounds(150, 180, 100, 30);
        txtTotalPagar.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTotalPagar.setMargin(new Insets(5, 5, 5, 5));
        txtTotalPagar.setEditable(false);
        getContentPane().add(txtTotalPagar);

        JLabel lblCaramelos = new JLabel("Caramelos:");
        lblCaramelos.setBounds(30, 230, 120, 30);
        getContentPane().add(lblCaramelos);

        txtCaramelos = new JTextField();
        txtCaramelos.setBounds(150, 230, 100, 30);
        txtCaramelos.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCaramelos.setMargin(new Insets(5, 5, 5, 5));
        txtCaramelos.setEditable(false);
        getContentPane().add(txtCaramelos);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 300, 100, 30);
        btnCalcular.setMnemonic('C');
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularVenta();
            }
        });
    }

    protected void calcularVenta() {
        int unidades = Integer.parseInt(txtUnidades.getText());
        double precioUnitario = 20.0;

        double importeCompra = unidades * precioUnitario;

        double descuentoPorcentaje = 0.12 * (importeCompra <= 500 ? 1 : 0)
                + 0.14 * (importeCompra > 500 && importeCompra <= 700 ? 1 : 0)
                + 0.16 * (importeCompra > 700 ? 1 : 0);

        double descuento = importeCompra * descuentoPorcentaje;

        double totalPagar = importeCompra - descuento;

        int caramelos = 5 * (unidades <= 50 ? 1 : 0)
                + 10 * (unidades > 50 && unidades <= 100 ? 1 : 0)
                + 15 * (unidades > 100 ? 1 : 0);

        txtImporteCompra.setText(String.format("S/ %.2f", importeCompra));
        txtDescuento.setText(String.format("S/ %.2f", descuento));
        txtTotalPagar.setText(String.format("S/ %.2f", totalPagar));
        txtCaramelos.setText(String.valueOf(caramelos));
    }
}
