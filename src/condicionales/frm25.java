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

public class frm25 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtSueldoBruto, txtHijos, txtBonificacion, txtSueldoNeto;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm25 frame = new frm25();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm25() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblSueldoBruto = new JLabel("Sueldo Bruto:");
        lblSueldoBruto.setBounds(50, 50, 150, 30);
        getContentPane().add(lblSueldoBruto);

        JLabel lblHijos = new JLabel("Cantidad de Hijos:");
        lblHijos.setBounds(50, 90, 150, 30);
        getContentPane().add(lblHijos);

        JLabel lblBonificacion = new JLabel("Bonificación:");
        lblBonificacion.setBounds(50, 130, 150, 30);
        getContentPane().add(lblBonificacion);

        JLabel lblSueldoNeto = new JLabel("Sueldo Neto:");
        lblSueldoNeto.setBounds(50, 170, 150, 30);
        getContentPane().add(lblSueldoNeto);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(200, 50, 100, 30);
        txtSueldoBruto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoBruto.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtSueldoBruto);

        txtHijos = new JTextField();
        txtHijos.setBounds(200, 90, 100, 30);
        txtHijos.setHorizontalAlignment(SwingConstants.RIGHT);
        txtHijos.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtHijos);

        txtBonificacion = new JTextField();
        txtBonificacion.setBounds(200, 130, 100, 30);
        txtBonificacion.setHorizontalAlignment(SwingConstants.RIGHT);
        txtBonificacion.setEditable(false);
        txtBonificacion.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtBonificacion);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(200, 170, 100, 30);
        txtSueldoNeto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoNeto.setEditable(false);
        txtSueldoNeto.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtSueldoNeto);

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
        double sueldoBruto = Double.parseDouble(txtSueldoBruto.getText());
        int cantidadHijos = Integer.parseInt(txtHijos.getText());

        double porcentajeBonificacion = 0.10 + (cantidadHijos > 1 ? 0.025 : 0);
        double bonificacion = sueldoBruto * porcentajeBonificacion + cantidadHijos * 40;

        double sueldoNeto = sueldoBruto + bonificacion;

        txtBonificacion.setText(String.format("S/ %.2f", bonificacion));
        txtSueldoNeto.setText(String.format("S/ %.2f", sueldoNeto));
    }
}