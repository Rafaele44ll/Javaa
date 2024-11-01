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

public class frm23 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtMatematicas, txtFisica, txtPropina, txtObsequio;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm23 frame = new frm23();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm23() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMatematicas = new JLabel("Nota en Matemáticas:");
        lblMatematicas.setBounds(50, 50, 150, 30);
        getContentPane().add(lblMatematicas);

        JLabel lblFisica = new JLabel("Nota en Física:");
        lblFisica.setBounds(50, 90, 150, 30);
        getContentPane().add(lblFisica);

        JLabel lblPropina = new JLabel("Propina Total:");
        lblPropina.setBounds(50, 130, 150, 30);
        getContentPane().add(lblPropina);

        JLabel lblObsequio = new JLabel("Obsequio:");
        lblObsequio.setBounds(50, 170, 150, 30);
        getContentPane().add(lblObsequio);

        txtMatematicas = new JTextField();
        txtMatematicas.setBounds(200, 50, 80, 30);
        txtMatematicas.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMatematicas.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMatematicas);

        txtFisica = new JTextField();
        txtFisica.setBounds(200, 90, 80, 30);
        txtFisica.setHorizontalAlignment(SwingConstants.RIGHT);
        txtFisica.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtFisica);

        txtPropina = new JTextField();
        txtPropina.setBounds(200, 130, 80, 30);
        txtPropina.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPropina.setEditable(false);
        txtPropina.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPropina);

        txtObsequio = new JTextField();
        txtObsequio.setBounds(200, 170, 80, 30);
        txtObsequio.setHorizontalAlignment(SwingConstants.RIGHT);
        txtObsequio.setEditable(false);
        txtObsequio.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtObsequio);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 220, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        double notaMatematicas = Double.parseDouble(txtMatematicas.getText());
        double notaFisica = Double.parseDouble(txtFisica.getText());

        double propinaMatematicas = notaMatematicas * (notaMatematicas > 17 ? 3.0 / notaMatematicas : 1);

        double propinaFisica = notaFisica * (notaFisica > 15 ? 2.0 / notaFisica : 0.5);

        double propinaTotal = propinaMatematicas + propinaFisica;

        String obsequio = ((notaMatematicas + notaFisica) / 2) > 16 ? "Reloj" : "Ninguno";

        txtPropina.setText(String.format("S/ %.2f", propinaTotal));
        txtObsequio.setText(obsequio);
    }
}
