package condicionales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm09 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtUnidades, txtImporte, txtDescuento, txtTotal;
    private JComboBox<String> cboProducto;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm09 frame = new frm09();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm09() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblProducto = new JLabel("Código del Producto:");
        lblProducto.setBounds(30, 30, 150, 30);
        getContentPane().add(lblProducto);

        cboProducto = new JComboBox<>(new String[] { "101", "102", "103", "104" });
        cboProducto.setBounds(180, 30, 100, 30);
        getContentPane().add(cboProducto);

        JLabel lblUnidades = new JLabel("Unidades:");
        lblUnidades.setBounds(30, 80, 150, 30);
        getContentPane().add(lblUnidades);

        txtUnidades = new JTextField();
        txtUnidades.setBounds(180, 80, 100, 30);
        txtUnidades.setHorizontalAlignment(SwingConstants.RIGHT);
        txtUnidades.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtUnidades);

        JLabel lblImporte = new JLabel("Importe Total:");
        lblImporte.setBounds(30, 130, 150, 30);
        getContentPane().add(lblImporte);

        txtImporte = new JTextField();
        txtImporte.setBounds(180, 130, 100, 30);
        txtImporte.setHorizontalAlignment(SwingConstants.RIGHT);
        txtImporte.setMargin(new Insets(5, 5, 5, 5));
        txtImporte.setEditable(false);
        getContentPane().add(txtImporte);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(30, 180, 150, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(180, 180, 100, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setMargin(new Insets(5, 5, 5, 5));
        txtDescuento.setEditable(false);
        getContentPane().add(txtDescuento);

        JLabel lblTotal = new JLabel("Total a Pagar:");
        lblTotal.setBounds(30, 230, 150, 30);
        getContentPane().add(lblTotal);

        txtTotal = new JTextField();
        txtTotal.setBounds(180, 230, 100, 30);
        txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTotal.setMargin(new Insets(5, 5, 5, 5));
        txtTotal.setEditable(false);
        getContentPane().add(txtTotal);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 300, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularCompra();
            }
        });
    }

    protected void calcularCompra() {
        String codigo = (String) cboProducto.getSelectedItem();
        int unidades;

        try {
            unidades = Integer.parseInt(txtUnidades.getText());
            if (unidades <= 0) {
                JOptionPane.showMessageDialog(this, "El número de unidades debe ser mayor a 0.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido de unidades.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        double precioUnitario = 0;
        double descuento = 0;

        switch (codigo) {
            case "101":
                precioUnitario = 17;
                descuento = calcularDescuento(unidades, 5);
                break;
            case "102":
                precioUnitario = 25;
                descuento = calcularDescuento(unidades, 10);
                break;
            case "103":
                precioUnitario = 8;
                descuento = calcularDescuento(unidades, 8);
                break;
            case "104":
                precioUnitario = 27;
                descuento = calcularDescuento(unidades, 10);
                break;
        }

        double importeTotal = precioUnitario * unidades;
        double totalPagar = importeTotal - (importeTotal * descuento / 100);

        txtImporte.setText(String.format("S/ %.2f", importeTotal));
        txtDescuento.setText(String.format("S/ %.2f", importeTotal * descuento / 100));
        txtTotal.setText(String.format("S/ %.2f", totalPagar));
    }

    private double calcularDescuento(int unidades, double baseDescuento) {
        if (unidades >= 1 && unidades <= 10) {
            return 0;
        } else if (unidades >= 11 && unidades <= 20) {
            return baseDescuento;
        } else if (unidades >= 21 && unidades <= 30) {
            return 8;
        } else if (unidades > 30) {
            return 13;
        }
        return baseDescuento;
    }
}