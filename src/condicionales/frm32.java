package condicionales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm32 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtPromedio, txtPensionActual, txtDescuento, txtNuevaPension;
    private JComboBox<String> cboCategoria;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm32 frame = new frm32();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm32() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setBounds(30, 30, 100, 30);
        getContentPane().add(lblCategoria);

        cboCategoria = new JComboBox<>(new String[] { "A", "B", "C", "D" });
        cboCategoria.setBounds(150, 30, 100, 30);
        getContentPane().add(cboCategoria);

        JLabel lblPromedio = new JLabel("Promedio Ponderado:");
        lblPromedio.setBounds(30, 80, 150, 30);
        getContentPane().add(lblPromedio);

        txtPromedio = new JTextField();
        txtPromedio.setBounds(180, 80, 100, 30);
        txtPromedio.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPromedio.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPromedio);

        JLabel lblPensionActual = new JLabel("Pensión Actual:");
        lblPensionActual.setBounds(30, 130, 150, 30);
        getContentPane().add(lblPensionActual);

        txtPensionActual = new JTextField();
        txtPensionActual.setBounds(180, 130, 100, 30);
        txtPensionActual.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPensionActual.setMargin(new Insets(5, 5, 5, 5));
        txtPensionActual.setEditable(false);
        getContentPane().add(txtPensionActual);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(30, 180, 150, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(180, 180, 100, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setMargin(new Insets(5, 5, 5, 5));
        txtDescuento.setEditable(false);
        getContentPane().add(txtDescuento);

        JLabel lblNuevaPension = new JLabel("Nueva Pensión:");
        lblNuevaPension.setBounds(30, 230, 150, 30);
        getContentPane().add(lblNuevaPension);

        txtNuevaPension = new JTextField();
        txtNuevaPension.setBounds(180, 230, 100, 30);
        txtNuevaPension.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNuevaPension.setMargin(new Insets(5, 5, 5, 5));
        txtNuevaPension.setEditable(false);
        getContentPane().add(txtNuevaPension);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 300, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPension();
            }
        });
    }

    protected void calcularPension() {
        double promedio = Double.parseDouble(txtPromedio.getText());
        String categoria = (String) cboCategoria.getSelectedItem();

        double pensionActual = 0;
        double descuento = 0;

        switch (categoria) {
            case "A":
                pensionActual = 550;
                descuento = calcularDescuento(promedio, pensionActual);
                break;
            case "B":
                pensionActual = 500;
                break;
            case "C":
                pensionActual = 450;
                descuento = calcularDescuento(promedio, pensionActual);
                break;
            case "D":
                pensionActual = 400;
                descuento = calcularDescuento(promedio, pensionActual);
                break;
        }

        double nuevaPension = pensionActual - descuento;

        txtPensionActual.setText(String.format("S/ %.2f", pensionActual));
        txtDescuento.setText(String.format("S/ %.2f", descuento));
        txtNuevaPension.setText(String.format("S/ %.2f", nuevaPension));
    }

    private double calcularDescuento(double promedio, double pensionActual) {
        if (promedio >= 0 && promedio < 14) {
            return 0;
        } else if (promedio >= 14 && promedio < 16) {
            return pensionActual * 0.10;
        } else if (promedio >= 16 && promedio < 18) {
            return pensionActual * 0.12;
        } else if (promedio >= 18 && promedio <= 20) {
            return pensionActual * 0.15;
        }
        return 0;
    }
}
