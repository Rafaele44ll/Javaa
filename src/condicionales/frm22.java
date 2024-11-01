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

public class frm22 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtUnidadesA, txtUnidadesB, txtImporteBruto, txtDescuento, txtTotal;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm22 frame = new frm22();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm22() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblUnidadesA = new JLabel("Unidades Producto A:");
        lblUnidadesA.setBounds(50, 50, 150, 30);
        getContentPane().add(lblUnidadesA);

        JLabel lblUnidadesB = new JLabel("Unidades Producto B:");
        lblUnidadesB.setBounds(50, 90, 150, 30);
        getContentPane().add(lblUnidadesB);

        JLabel lblImporteBruto = new JLabel("Importe Bruto:");
        lblImporteBruto.setBounds(50, 130, 150, 30);
        getContentPane().add(lblImporteBruto);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(50, 170, 150, 30);
        getContentPane().add(lblDescuento);

        JLabel lblTotal = new JLabel("Total a Pagar:");
        lblTotal.setBounds(50, 210, 150, 30);
        getContentPane().add(lblTotal);

        txtUnidadesA = new JTextField();
        txtUnidadesA.setBounds(200, 50, 100, 30);
        txtUnidadesA.setHorizontalAlignment(SwingConstants.RIGHT);
        txtUnidadesA.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtUnidadesA);

        txtUnidadesB = new JTextField();
        txtUnidadesB.setBounds(200, 90, 100, 30);
        txtUnidadesB.setHorizontalAlignment(SwingConstants.RIGHT);
        txtUnidadesB.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtUnidadesB);

        txtImporteBruto = new JTextField();
        txtImporteBruto.setBounds(200, 130, 100, 30);
        txtImporteBruto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtImporteBruto.setEditable(false);
        txtImporteBruto.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtImporteBruto);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(200, 170, 100, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setEditable(false);
        txtDescuento.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDescuento);

        txtTotal = new JTextField();
        txtTotal.setBounds(200, 210, 100, 30);
        txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTotal.setEditable(false);
        txtTotal.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtTotal);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(130, 250, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        int unidadesA = Integer.parseInt(txtUnidadesA.getText());
        int unidadesB = Integer.parseInt(txtUnidadesB.getText());

        double precioA = 25;
        double precioB = 30;

        double importeA = unidadesA * precioA;
        double importeB = unidadesB * precioB;
        double importeBruto = importeA + importeB;

        double descuentoA = (unidadesA > 50 ? 0.15 : 0) * importeA;
        double descuentoB = (unidadesB > 60 ? 0.10 : 0) * importeB;
        double descuentoTotal = descuentoA + descuentoB;

        double total = importeBruto - descuentoTotal;

        txtImporteBruto.setText(String.format("S/ %.2f", importeBruto));
        txtDescuento.setText(String.format("S/ %.2f", descuentoTotal));
        txtTotal.setText(String.format("S/ %.2f", total));
    }
}