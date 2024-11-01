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

public class frm31 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtHoras, txtSueldoBruto, txtDescuento, txtSueldoNeto;
    JComboBox<String> cbCategoria;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm31 frame = new frm31();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm31() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setBounds(30, 30, 80, 30);
        getContentPane().add(lblCategoria);

        cbCategoria = new JComboBox<>(new String[] { "A", "B", "C", "D" });
        cbCategoria.setBounds(120, 30, 60, 30);
        getContentPane().add(cbCategoria);

        JLabel lblHoras = new JLabel("Horas Trabajadas:");
        lblHoras.setBounds(30, 70, 120, 30);
        getContentPane().add(lblHoras);

        txtHoras = new JTextField();
        txtHoras.setBounds(150, 70, 60, 30);
        txtHoras.setHorizontalAlignment(SwingConstants.RIGHT);
        txtHoras.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtHoras);

        JLabel lblSueldoBruto = new JLabel("Sueldo Bruto:");
        lblSueldoBruto.setBounds(30, 110, 100, 30);
        getContentPane().add(lblSueldoBruto);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(150, 110, 100, 30);
        txtSueldoBruto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoBruto.setMargin(new Insets(5, 5, 5, 5));
        txtSueldoBruto.setEditable(false);
        getContentPane().add(txtSueldoBruto);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(30, 150, 100, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(150, 150, 100, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setMargin(new Insets(5, 5, 5, 5));
        txtDescuento.setEditable(false);
        getContentPane().add(txtDescuento);

        JLabel lblSueldoNeto = new JLabel("Sueldo Neto:");
        lblSueldoNeto.setBounds(30, 190, 100, 30);
        getContentPane().add(lblSueldoNeto);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(150, 190, 100, 30);
        txtSueldoNeto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoNeto.setMargin(new Insets(5, 5, 5, 5));
        txtSueldoNeto.setEditable(false);
        getContentPane().add(txtSueldoNeto);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 230, 100, 30);
        btnCalcular.setMnemonic('C');
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSueldo();
            }
        });
    }

    protected void calcularSueldo() {
        int horasTrabajadas = Integer.parseInt(txtHoras.getText());
        String categoria = cbCategoria.getSelectedItem().toString();

        double tarifa = 21.0 * (categoria.equals("A") ? 1 : 0)
                + 19.5 * (categoria.equals("B") ? 1 : 0)
                + 17.0 * (categoria.equals("C") ? 1 : 0)
                + 15.5 * (categoria.equals("D") ? 1 : 0);

        double sueldoBruto = horasTrabajadas * tarifa;

        double descuento = sueldoBruto * (0.20 * (sueldoBruto > 2500 ? 1 : 0)
                + 0.15 * (sueldoBruto <= 2500 ? 1 : 0));

        double sueldoNeto = sueldoBruto - descuento;

        txtSueldoBruto.setText(String.format("S/ %.2f", sueldoBruto));
        txtDescuento.setText(String.format("S/ %.2f", descuento));
        txtSueldoNeto.setText(String.format("S/ %.2f", sueldoNeto));
    }
}
