package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm15 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtJuan, txtRosa, txtDaniel;
    JTextField txtTotalDolares, txtPorcentajeJuan, txtPorcentajeRosa, txtPorcentajeDaniel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm15 frame = new frm15();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm15() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        // Crear etiquetas y campos de texto
        JLabel lblJuan = new JLabel("Aporte Juan (USD):");
        lblJuan.setBounds(50, 50, 150, 30);
        getContentPane().add(lblJuan);

        txtJuan = new JTextField();
        txtJuan.setBounds(200, 50, 100, 30);
        txtJuan.setHorizontalAlignment(SwingConstants.RIGHT);
        txtJuan.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtJuan);

        JLabel lblRosa = new JLabel("Aporte Rosa (USD):");
        lblRosa.setBounds(50, 100, 150, 30);
        getContentPane().add(lblRosa);

        txtRosa = new JTextField();
        txtRosa.setBounds(200, 100, 100, 30);
        txtRosa.setHorizontalAlignment(SwingConstants.RIGHT);
        txtRosa.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtRosa);

        JLabel lblDaniel = new JLabel("Aporte Daniel (S/.):");
        lblDaniel.setBounds(50, 150, 150, 30);
        getContentPane().add(lblDaniel);

        txtDaniel = new JTextField();
        txtDaniel.setBounds(200, 150, 100, 30);
        txtDaniel.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDaniel.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDaniel);

        JButton btnCalcular = new JButton("Calcular Capital");
        btnCalcular.setBounds(50, 200, 250, 30);
        getContentPane().add(btnCalcular);

        txtTotalDolares = new JTextField();
        txtTotalDolares.setBounds(50, 250, 250, 30);
        txtTotalDolares.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTotalDolares.setEditable(false);
        getContentPane().add(txtTotalDolares);

        txtPorcentajeJuan = new JTextField();
        txtPorcentajeJuan.setBounds(50, 300, 100, 30);
        txtPorcentajeJuan.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPorcentajeJuan.setEditable(false);
        getContentPane().add(txtPorcentajeJuan);

        txtPorcentajeRosa = new JTextField();
        txtPorcentajeRosa.setBounds(150, 300, 100, 30);
        txtPorcentajeRosa.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPorcentajeRosa.setEditable(false);
        getContentPane().add(txtPorcentajeRosa);

        txtPorcentajeDaniel = new JTextField();
        txtPorcentajeDaniel.setBounds(250, 300, 100, 30);
        txtPorcentajeDaniel.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPorcentajeDaniel.setEditable(false);
        getContentPane().add(txtPorcentajeDaniel);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double juan = Double.parseDouble(txtJuan.getText());
        double rosa = Double.parseDouble(txtRosa.getText());
        double daniel = Double.parseDouble(txtDaniel.getText());

        double danielDolares = daniel / 3.00;

        double totalDolares = juan + rosa + danielDolares;

        double porcentajeJuan = (juan / totalDolares) * 100;
        double porcentajeRosa = (rosa / totalDolares) * 100;
        double porcentajeDaniel = (danielDolares / totalDolares) * 100;

        DecimalFormat df = new DecimalFormat("###.##");
        txtTotalDolares.setText("Total (USD): " + df.format(totalDolares));
        txtPorcentajeJuan.setText("Juan: " + df.format(porcentajeJuan) + "%");
        txtPorcentajeRosa.setText("Rosa: " + df.format(porcentajeRosa) + "%");
        txtPorcentajeDaniel.setText("Daniel: " + df.format(porcentajeDaniel) + "%");
    }
}
