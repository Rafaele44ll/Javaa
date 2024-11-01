package secuenciales;

import java.awt.EventQueue;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm13 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtCatetoA, txtCatetoB;
    JLabel lblHipotenusa;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm13 frame = new frm13();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @SuppressWarnings("unused")
    public frm13() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCatetoA = new JLabel("Cateto A:");
        lblCatetoA.setBounds(50, 30, 100, 30);
        getContentPane().add(lblCatetoA);

        txtCatetoA = new JTextField();
        txtCatetoA.setBounds(150, 30, 100, 30);
        txtCatetoA.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtCatetoA);

        JLabel lblCatetoB = new JLabel("Cateto B:");
        lblCatetoB.setBounds(50, 80, 100, 30);
        getContentPane().add(lblCatetoB);

        txtCatetoB = new JTextField();
        txtCatetoB.setBounds(150, 80, 100, 30);
        txtCatetoB.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtCatetoB);

        JButton btnCalcular = new JButton("Calcular Hipotenusa");
        btnCalcular.setBounds(50, 130, 200, 30);
        getContentPane().add(btnCalcular);

        lblHipotenusa = new JLabel();
        lblHipotenusa.setBounds(50, 180, 200, 30);
        lblHipotenusa.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblHipotenusa);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double catetoA = Double.parseDouble(txtCatetoA.getText());
        double catetoB = Double.parseDouble(txtCatetoB.getText());

        double hipotenusa = Math.sqrt(catetoA * catetoA + catetoB * catetoB);

        DecimalFormat df = new DecimalFormat("#.##");
        lblHipotenusa.setText(df.format(hipotenusa));
    }
}