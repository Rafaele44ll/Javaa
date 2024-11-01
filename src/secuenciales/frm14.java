package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm14 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txt1, txt2, txt3, txt4, txt5;
    JTextField txtPromedio;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm14 frame = new frm14();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @SuppressWarnings("unused")
    public frm14() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        // Crear etiquetas y campos de texto para los números
        JLabel lbl1 = new JLabel("Número 1:");
        lbl1.setBounds(50, 50, 80, 30);
        getContentPane().add(lbl1);

        txt1 = new JTextField();
        txt1.setBounds(150, 50, 80, 30);
        txt1.setHorizontalAlignment(SwingConstants.RIGHT);
        txt1.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txt1);

        JLabel lbl2 = new JLabel("Número 2:");
        lbl2.setBounds(50, 100, 80, 30);
        getContentPane().add(lbl2);

        txt2 = new JTextField();
        txt2.setBounds(150, 100, 80, 30);
        txt2.setHorizontalAlignment(SwingConstants.RIGHT);
        txt2.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txt2);

        JLabel lbl3 = new JLabel("Número 3:");
        lbl3.setBounds(50, 150, 80, 30);
        getContentPane().add(lbl3);

        txt3 = new JTextField();
        txt3.setBounds(150, 150, 80, 30);
        txt3.setHorizontalAlignment(SwingConstants.RIGHT);
        txt3.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txt3);

        JLabel lbl4 = new JLabel("Número 4:");
        lbl4.setBounds(50, 200, 80, 30);
        getContentPane().add(lbl4);

        txt4 = new JTextField();
        txt4.setBounds(150, 200, 80, 30);
        txt4.setHorizontalAlignment(SwingConstants.RIGHT);
        txt4.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txt4);

        JLabel lbl5 = new JLabel("Número 5:");
        lbl5.setBounds(50, 250, 80, 30);
        getContentPane().add(lbl5);

        txt5 = new JTextField();
        txt5.setBounds(150, 250, 80, 30);
        txt5.setHorizontalAlignment(SwingConstants.RIGHT);
        txt5.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txt5);

        JButton btnCalcular = new JButton("Calcular Promedio");
        btnCalcular.setBounds(50, 300, 200, 30);
        getContentPane().add(btnCalcular);

        txtPromedio = new JTextField();
        txtPromedio.setBounds(50, 350, 200, 30);
        txtPromedio.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPromedio.setEditable(false);
        getContentPane().add(txtPromedio);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double n1 = Double.parseDouble(txt1.getText());
        double n2 = Double.parseDouble(txt2.getText());
        double n3 = Double.parseDouble(txt3.getText());
        double n4 = Double.parseDouble(txt4.getText());
        double n5 = Double.parseDouble(txt5.getText());

        double mayor1 = Math.max(Math.max(n1, n2), Math.max(n3, Math.max(n4, n5)));
        double mayor2 = Math.max(Math.min(Math.max(n1, n2), mayor1), Math.max(Math.min(n3, n4), Math.min(n5, mayor1)));
        double mayor3 = Math.min(Math.min(n1, n2), Math.min(n3, Math.min(n4, n5)));

        double promedio = (mayor1 + mayor2 + mayor3) / 3;

        DecimalFormat df = new DecimalFormat("###.##");
        txtPromedio.setText(df.format(promedio));
    }
}