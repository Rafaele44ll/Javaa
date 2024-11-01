package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frm40 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtMatematicasP1, txtMatematicasP2, txtMatematicasP3, txtMatematicasEP, txtMatematicasEF;
    JTextField txtFisicaP1, txtFisicaP2, txtFisicaP3, txtFisicaEP, txtFisicaEF;
    JTextField txtQuimicaP1, txtQuimicaP2, txtQuimicaP3, txtQuimicaEP, txtQuimicaEF;
    JTextField txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm40 frame = new frm40();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm40() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 600, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        // Matemáticas
        JLabel lblMatematicas = new JLabel("Matemáticas:");
        lblMatematicas.setBounds(50, 30, 100, 30);
        getContentPane().add(lblMatematicas);

        JLabel lblMatematicasP1 = new JLabel("PC1:");
        lblMatematicasP1.setBounds(50, 70, 30, 30);
        getContentPane().add(lblMatematicasP1);
        txtMatematicasP1 = new JTextField();
        txtMatematicasP1.setBounds(80, 70, 50, 30);
        getContentPane().add(txtMatematicasP1);

        JLabel lblMatematicasP2 = new JLabel("PC2:");
        lblMatematicasP2.setBounds(50, 110, 30, 30);
        getContentPane().add(lblMatematicasP2);
        txtMatematicasP2 = new JTextField();
        txtMatematicasP2.setBounds(80, 110, 50, 30);
        getContentPane().add(txtMatematicasP2);

        JLabel lblMatematicasP3 = new JLabel("PC3:");
        lblMatematicasP3.setBounds(50, 150, 30, 30);
        getContentPane().add(lblMatematicasP3);
        txtMatematicasP3 = new JTextField();
        txtMatematicasP3.setBounds(80, 150, 50, 30);
        getContentPane().add(txtMatematicasP3);

        JLabel lblMatematicasEP = new JLabel("EP:");
        lblMatematicasEP.setBounds(50, 190, 30, 30);
        getContentPane().add(lblMatematicasEP);
        txtMatematicasEP = new JTextField();
        txtMatematicasEP.setBounds(80, 190, 50, 30);
        getContentPane().add(txtMatematicasEP);

        JLabel lblMatematicasEF = new JLabel("EF:");
        lblMatematicasEF.setBounds(50, 230, 30, 30);
        getContentPane().add(lblMatematicasEF);
        txtMatematicasEF = new JTextField();
        txtMatematicasEF.setBounds(80, 230, 50, 30);
        getContentPane().add(txtMatematicasEF);

        // Física
        JLabel lblFisica = new JLabel("Física:");
        lblFisica.setBounds(200, 30, 100, 30);
        getContentPane().add(lblFisica);

        JLabel lblFisicaP1 = new JLabel("PC1:");
        lblFisicaP1.setBounds(200, 70, 30, 30);
        getContentPane().add(lblFisicaP1);
        txtFisicaP1 = new JTextField();
        txtFisicaP1.setBounds(230, 70, 50, 30);
        getContentPane().add(txtFisicaP1);

        JLabel lblFisicaP2 = new JLabel("PC2:");
        lblFisicaP2.setBounds(200, 110, 30, 30);
        getContentPane().add(lblFisicaP2);
        txtFisicaP2 = new JTextField();
        txtFisicaP2.setBounds(230, 110, 50, 30);
        getContentPane().add(txtFisicaP2);

        JLabel lblFisicaP3 = new JLabel("PC3:");
        lblFisicaP3.setBounds(200, 150, 30, 30);
        getContentPane().add(lblFisicaP3);
        txtFisicaP3 = new JTextField();
        txtFisicaP3.setBounds(230, 150, 50, 30);
        getContentPane().add(txtFisicaP3);

        JLabel lblFisicaEP = new JLabel("EP:");
        lblFisicaEP.setBounds(200, 190, 30, 30);
        getContentPane().add(lblFisicaEP);
        txtFisicaEP = new JTextField();
        txtFisicaEP.setBounds(230, 190, 50, 30);
        getContentPane().add(txtFisicaEP);

        JLabel lblFisicaEF = new JLabel("EF:");
        lblFisicaEF.setBounds(200, 230, 30, 30);
        getContentPane().add(lblFisicaEF);
        txtFisicaEF = new JTextField();
        txtFisicaEF.setBounds(230, 230, 50, 30);
        getContentPane().add(txtFisicaEF);

        JLabel lblQuimica = new JLabel("Química:");
        lblQuimica.setBounds(350, 30, 100, 30);
        getContentPane().add(lblQuimica);

        JLabel lblQuimicaP1 = new JLabel("PC1:");
        lblQuimicaP1.setBounds(350, 70, 30, 30);
        getContentPane().add(lblQuimicaP1);
        txtQuimicaP1 = new JTextField();
        txtQuimicaP1.setBounds(380, 70, 50, 30);
        getContentPane().add(txtQuimicaP1);

        JLabel lblQuimicaP2 = new JLabel("PC2:");
        lblQuimicaP2.setBounds(350, 110, 30, 30);
        getContentPane().add(lblQuimicaP2);
        txtQuimicaP2 = new JTextField();
        txtQuimicaP2.setBounds(380, 110, 50, 30);
        getContentPane().add(txtQuimicaP2);

        JLabel lblQuimicaP3 = new JLabel("PC3:");
        lblQuimicaP3.setBounds(350, 150, 30, 30);
        getContentPane().add(lblQuimicaP3);
        txtQuimicaP3 = new JTextField();
        txtQuimicaP3.setBounds(380, 150, 50, 30);
        getContentPane().add(txtQuimicaP3);

        JLabel lblQuimicaEP = new JLabel("EP:");
        lblQuimicaEP.setBounds(350, 190, 30, 30);
        getContentPane().add(lblQuimicaEP);
        txtQuimicaEP = new JTextField();
        txtQuimicaEP.setBounds(380, 190, 50, 30);
        getContentPane().add(txtQuimicaEP);

        JLabel lblQuimicaEF = new JLabel("EF:");
        lblQuimicaEF.setBounds(350, 230, 30, 30);
        getContentPane().add(lblQuimicaEF);
        txtQuimicaEF = new JTextField();
        txtQuimicaEF.setBounds(380, 230, 50, 30);
        getContentPane().add(txtQuimicaEF);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(50, 280, 100, 30);
        getContentPane().add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(150, 280, 200, 30);
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);

        JButton btnCalcular = new JButton("Calcular Promedio");
        btnCalcular.setBounds(400, 280, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPromedio();
            }
        });
    }

    protected void calcularPromedio() {
        double matematicasPC1 = Double.parseDouble(txtMatematicasP1.getText());
        double matematicasPC2 = Double.parseDouble(txtMatematicasP2.getText());
        double matematicasPC3 = Double.parseDouble(txtMatematicasP3.getText());
        double matematicasEP = Double.parseDouble(txtMatematicasEP.getText());
        double matematicasEF = Double.parseDouble(txtMatematicasEF.getText());

        double fisicaPC1 = Double.parseDouble(txtFisicaP1.getText());
        double fisicaPC2 = Double.parseDouble(txtFisicaP2.getText());
        double fisicaPC3 = Double.parseDouble(txtFisicaP3.getText());
        double fisicaEP = Double.parseDouble(txtFisicaEP.getText());
        double fisicaEF = Double.parseDouble(txtFisicaEF.getText());

        double quimicaPC1 = Double.parseDouble(txtQuimicaP1.getText());
        double quimicaPC2 = Double.parseDouble(txtQuimicaP2.getText());
        double quimicaPC3 = Double.parseDouble(txtQuimicaP3.getText());
        double quimicaEP = Double.parseDouble(txtQuimicaEP.getText());
        double quimicaEF = Double.parseDouble(txtQuimicaEF.getText());

        double promedioMatematicas = (matematicasPC1 * 0.1 + matematicasPC2 * 0.2 + matematicasPC3 * 0.1
                + matematicasEP * 0.3 + matematicasEF * 0.3);
        double promedioFisica = (fisicaPC1 * 0.2 + fisicaPC2 * 0.2 + fisicaPC3 * 0.2 + fisicaEP * 0.2 + fisicaEF * 0.2);
        double promedioQuimica = (quimicaPC1 * 0.1 + quimicaPC2 * 0.3 + quimicaPC3 * 0.1 + quimicaEP * 0.25
                + quimicaEF * 0.25);

        double promedioFinal = (promedioMatematicas + promedioFisica + promedioQuimica) / 3;

        String estado = promedioFinal >= 13 ? "Aprobado" : "Desaprobado";

        txtResultado.setText("Promedio: " + String.format("%.2f", promedioFinal) + " - " + estado);
    }
}
