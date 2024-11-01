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

public class frm36 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtCuadernos, txtLucas, txtFaber, txtPilot;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm36 frame = new frm36();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm36() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCuadernos = new JLabel("Cuadernos:");
        lblCuadernos.setBounds(50, 50, 100, 30);
        getContentPane().add(lblCuadernos);

        JLabel lblLucas = new JLabel("Lapiceros Lucas:");
        lblLucas.setBounds(50, 100, 100, 30);
        getContentPane().add(lblLucas);

        JLabel lblFaber = new JLabel("Lapiceros Faber:");
        lblFaber.setBounds(50, 150, 100, 30);
        getContentPane().add(lblFaber);

        JLabel lblPilot = new JLabel("Lapiceros Pilot:");
        lblPilot.setBounds(50, 200, 100, 30);
        getContentPane().add(lblPilot);

        txtCuadernos = new JTextField();
        txtCuadernos.setBounds(160, 50, 60, 30);
        txtCuadernos.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCuadernos.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCuadernos);

        txtLucas = new JTextField();
        txtLucas.setBounds(160, 100, 60, 30);
        txtLucas.setHorizontalAlignment(SwingConstants.RIGHT);
        txtLucas.setMargin(new Insets(5, 5, 5, 5));
        txtLucas.setEditable(false);
        getContentPane().add(txtLucas);

        txtFaber = new JTextField();
        txtFaber.setBounds(160, 150, 60, 30);
        txtFaber.setHorizontalAlignment(SwingConstants.RIGHT);
        txtFaber.setMargin(new Insets(5, 5, 5, 5));
        txtFaber.setEditable(false);
        getContentPane().add(txtFaber);

        txtPilot = new JTextField();
        txtPilot.setBounds(160, 200, 60, 30);
        txtPilot.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPilot.setMargin(new Insets(5, 5, 5, 5));
        txtPilot.setEditable(false);
        getContentPane().add(txtPilot);

        JButton btnCalcular = new JButton("Calcular Obsequios");
        btnCalcular.setBounds(120, 250, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularLapiceros();
            }
        });
    }

    protected void calcularLapiceros() {
        int cuadernos = Integer.parseInt(txtCuadernos.getText());

        int cantidadLucas = (cuadernos >= 12 ? (cuadernos < 24 ? cuadernos / 4 : (cuadernos >= 36 ? cuadernos / 12 : 0))
                : 0);
        int cantidadFaber = (cuadernos >= 24 && cuadernos < 36 ? (cuadernos / 2) / 2
                : (cuadernos >= 36 ? cuadernos / 6 : 0));
        int cantidadPilot = (cuadernos >= 36 ? cuadernos / 2 : 0);

        txtLucas.setText(String.valueOf(cantidadLucas));
        txtFaber.setText(String.valueOf(cantidadFaber));
        txtPilot.setText(String.valueOf(cantidadPilot));
    }
}