package secuenciales;

import java.awt.EventQueue;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm05 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtGigabytes, txtMegabytes, txtKilobytes, txtBytes;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm05 frame = new frm05();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("unused")
    public frm05() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblGigabytes = new JLabel("Gigabytes :");
        lblGigabytes.setBounds(50, 50, 100, 30);
        getContentPane().add(lblGigabytes);

        JLabel lblMegabytes = new JLabel("Total en Megabytes :");
        lblMegabytes.setBounds(20, 150, 120, 30);
        getContentPane().add(lblMegabytes);

        JLabel lblKilobytes = new JLabel("Total en Kilobytes :");
        lblKilobytes.setBounds(30, 190, 120, 30);
        getContentPane().add(lblKilobytes);

        JLabel lblBytes = new JLabel("Total en Bytes :");
        lblBytes.setBounds(50, 230, 120, 30);
        getContentPane().add(lblBytes);

        txtGigabytes = new JTextField();
        txtGigabytes.setBounds(150, 50, 80, 30);
        txtGigabytes.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtGigabytes);

        txtMegabytes = new JTextField();
        txtMegabytes.setBounds(150, 150, 80, 30);
        txtMegabytes.setFocusable(false);
        txtMegabytes.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtMegabytes);

        txtKilobytes = new JTextField();
        txtKilobytes.setBounds(150, 190, 80, 30);
        txtKilobytes.setFocusable(false);
        txtKilobytes.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtKilobytes);

        txtBytes = new JTextField();
        txtBytes.setBounds(150, 230, 80, 30);
        txtBytes.setFocusable(false);
        txtBytes.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtBytes);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 100, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        try {
            int gigabytes = Integer.parseInt(txtGigabytes.getText());

            long megabytes = gigabytes * 1024;
            long kilobytes = megabytes * 1024;
            long bytes = kilobytes * 1024;

            DecimalFormat df = new DecimalFormat("###,###");
            txtMegabytes.setText(df.format(megabytes));
            txtKilobytes.setText(df.format(kilobytes));
            txtBytes.setText(df.format(bytes));
        } catch (NumberFormatException e) {
            txtMegabytes.setText("Error");
            txtKilobytes.setText("Error");
            txtBytes.setText("Error");
        }
    }
}