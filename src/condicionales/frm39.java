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

public class frm39 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtHorasAusencia, txtTornillosDefectuosos, txtTornillosNoDefectuosos, txtGradoEficiencia;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm39 frame = new frm39();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm39() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblHorasAusencia = new JLabel("Horas de Ausencia:");
        lblHorasAusencia.setBounds(50, 50, 130, 30);
        getContentPane().add(lblHorasAusencia);

        JLabel lblTornillosDefectuosos = new JLabel("Tornillos Defectuosos:");
        lblTornillosDefectuosos.setBounds(50, 90, 130, 30);
        getContentPane().add(lblTornillosDefectuosos);

        JLabel lblTornillosNoDefectuosos = new JLabel("Tornillos No Defectuosos:");
        lblTornillosNoDefectuosos.setBounds(50, 130, 150, 30);
        getContentPane().add(lblTornillosNoDefectuosos);

        JLabel lblGradoEficiencia = new JLabel("Grado de Eficiencia:");
        lblGradoEficiencia.setBounds(50, 170, 130, 30);
        getContentPane().add(lblGradoEficiencia);

        txtHorasAusencia = new JTextField();
        txtHorasAusencia.setBounds(200, 50, 60, 30);
        txtHorasAusencia.setHorizontalAlignment(SwingConstants.RIGHT);
        txtHorasAusencia.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtHorasAusencia);

        txtTornillosDefectuosos = new JTextField();
        txtTornillosDefectuosos.setBounds(200, 90, 60, 30);
        txtTornillosDefectuosos.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTornillosDefectuosos.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtTornillosDefectuosos);

        txtTornillosNoDefectuosos = new JTextField();
        txtTornillosNoDefectuosos.setBounds(200, 130, 60, 30);
        txtTornillosNoDefectuosos.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTornillosNoDefectuosos.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtTornillosNoDefectuosos);

        txtGradoEficiencia = new JTextField();
        txtGradoEficiencia.setBounds(200, 170, 60, 30);
        txtGradoEficiencia.setHorizontalAlignment(SwingConstants.RIGHT);
        txtGradoEficiencia.setEditable(false);
        getContentPane().add(txtGradoEficiencia);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 210, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularGradoEficiencia();
            }
        });
    }

    protected void calcularGradoEficiencia() {
        double horasAusencia = Double.parseDouble(txtHorasAusencia.getText());
        int tornillosDefectuosos = Integer.parseInt(txtTornillosDefectuosos.getText());
        int tornillosNoDefectuosos = Integer.parseInt(txtTornillosNoDefectuosos.getText());

        boolean cumplePrimera = horasAusencia <= 1.5;
        boolean cumpleSegunda = tornillosDefectuosos < 300;
        boolean cumpleTercera = tornillosNoDefectuosos > 10000;

        int gradoEficiencia;
        if (!cumplePrimera && !cumpleSegunda && !cumpleTercera) {
            gradoEficiencia = 5;
        } else if (cumplePrimera && !cumpleSegunda && !cumpleTercera) {
            gradoEficiencia = 7;
        } else if (!cumplePrimera && cumpleSegunda && !cumpleTercera) {
            gradoEficiencia = 8;
        } else if (!cumplePrimera && !cumpleSegunda && cumpleTercera) {
            gradoEficiencia = 9;
        } else if (cumplePrimera && cumpleSegunda && !cumpleTercera) {
            gradoEficiencia = 12;
        } else if (cumplePrimera && !cumpleSegunda && cumpleTercera) {
            gradoEficiencia = 13;
        } else if (!cumplePrimera && cumpleSegunda && cumpleTercera) {
            gradoEficiencia = 15;
        } else {
            gradoEficiencia = 20;
        }

        txtGradoEficiencia.setText(String.valueOf(gradoEficiencia));
    }
}
