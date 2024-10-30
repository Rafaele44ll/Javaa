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

public class frm01 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtUnidades, txtCompra, txtDescuento, txtTotal;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm01 frame = new frm01();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm01() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblUnidades = new JLabel("Unidades :");
        lblUnidades.setBounds(50, 50, 80, 30);
        getContentPane().add(lblUnidades);

        JLabel lblCompra = new JLabel("Compra :");
        lblCompra.setBounds(50, 90, 80, 30);
        getContentPane().add(lblCompra);

        JLabel lblDescuento = new JLabel("Descuento: ");
        lblDescuento.setBounds(50, 130, 80, 30);
        getContentPane().add(lblDescuento);

        JLabel lblTotal = new JLabel("Total: ");
        lblTotal.setBounds(50, 180, 80, 30);
        getContentPane().add(lblTotal);

        txtUnidades = new JTextField();
        txtUnidades.setBounds(130, 50, 60, 30);
        txtUnidades.setHorizontalAlignment(SwingConstants.RIGHT);
        txtUnidades.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtUnidades);

        txtCompra = new JTextField();
        txtCompra.setBounds(130, 90, 60, 30);
        txtCompra.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCompra.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCompra);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(130, 130, 60, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDescuento);

        txtTotal = new JTextField();
        txtTotal.setBounds(130, 180, 60, 30);
        txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTotal.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtTotal);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 150, 100, 30);
        btnCalcular.setMnemonic('a');
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }

        });

    }

    protected void btnCalcular_actionPerformed() {
        int unidades = Integer.parseInt(txtUnidades.getText());

        int precio = 27;
        if (unidades >= 26 && unidades <= 50)
            precio = 25;
        else if (unidades > 50)
            precio = 23;

        double compra = precio * unidades;
        double descuento = (unidades > 50 ? 0.15 : 0.05) * compra;

        double total = compra - descuento;

        txtCompra.setText(String.format("S/ %.2f", compra));
        txtDescuento.setText(String.format("S/ %.2f", descuento));
        txtTotal.setText(String.format("S/ %.2f", total));

    }

}
