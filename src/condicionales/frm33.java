package condicionales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm33 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtTardanza, txtObservaciones, txtPuntajePuntualidad, txtPuntajeRendimiento, txtPuntajeTotal,
            txtBonificacion;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm33 frame = new frm33();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm33() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblTardanza = new JLabel("Tardanza (min):");
        lblTardanza.setBounds(30, 30, 150, 30);
        getContentPane().add(lblTardanza);

        txtTardanza = new JTextField();
        txtTardanza.setBounds(180, 30, 100, 30);
        txtTardanza.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTardanza.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtTardanza);

        JLabel lblObservaciones = new JLabel("Observaciones:");
        lblObservaciones.setBounds(30, 80, 150, 30);
        getContentPane().add(lblObservaciones);

        txtObservaciones = new JTextField();
        txtObservaciones.setBounds(180, 80, 100, 30);
        txtObservaciones.setHorizontalAlignment(SwingConstants.RIGHT);
        txtObservaciones.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtObservaciones);

        JLabel lblPuntajePuntualidad = new JLabel("Puntaje Puntualidad:");
        lblPuntajePuntualidad.setBounds(30, 130, 150, 30);
        getContentPane().add(lblPuntajePuntualidad);

        txtPuntajePuntualidad = new JTextField();
        txtPuntajePuntualidad.setBounds(180, 130, 100, 30);
        txtPuntajePuntualidad.setEditable(false);
        getContentPane().add(txtPuntajePuntualidad);

        JLabel lblPuntajeRendimiento = new JLabel("Puntaje Rendimiento:");
        lblPuntajeRendimiento.setBounds(30, 180, 150, 30);
        getContentPane().add(lblPuntajeRendimiento);

        txtPuntajeRendimiento = new JTextField();
        txtPuntajeRendimiento.setBounds(180, 180, 100, 30);
        txtPuntajeRendimiento.setEditable(false);
        getContentPane().add(txtPuntajeRendimiento);

        JLabel lblPuntajeTotal = new JLabel("Puntaje Total:");
        lblPuntajeTotal.setBounds(30, 230, 150, 30);
        getContentPane().add(lblPuntajeTotal);

        txtPuntajeTotal = new JTextField();
        txtPuntajeTotal.setBounds(180, 230, 100, 30);
        txtPuntajeTotal.setEditable(false);
        getContentPane().add(txtPuntajeTotal);

        JLabel lblBonificacion = new JLabel("Bonificación (S/.):");
        lblBonificacion.setBounds(30, 280, 150, 30);
        getContentPane().add(lblBonificacion);

        txtBonificacion = new JTextField();
        txtBonificacion.setBounds(180, 280, 100, 30);
        txtBonificacion.setEditable(false);
        getContentPane().add(txtBonificacion);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 320, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularEvaluacion();
            }
        });
    }

    protected void calcularEvaluacion() {
        int tardanza, observaciones;

        try {
            tardanza = Integer.parseInt(txtTardanza.getText());
            observaciones = Integer.parseInt(txtObservaciones.getText());

            if (tardanza < 0 || observaciones < 0) {
                JOptionPane.showMessageDialog(this, "Los valores no pueden ser negativos.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int puntajePuntualidad;
        if (tardanza == 0) {
            puntajePuntualidad = 10;
        } else if (tardanza >= 1 && tardanza <= 2) {
            puntajePuntualidad = 8;
        } else if (tardanza >= 3 && tardanza <= 5) {
            puntajePuntualidad = 6;
        } else if (tardanza >= 6 && tardanza <= 9) {
            puntajePuntualidad = 4;
        } else {
            puntajePuntualidad = 0;
        }
        int puntajeRendimiento;
        if (observaciones == 0) {
            puntajeRendimiento = 10;
        } else if (observaciones == 1) {
            puntajeRendimiento = 8;
        } else if (observaciones == 2) {
            puntajeRendimiento = 5;
        } else if (observaciones == 3) {
            puntajeRendimiento = 3;
        } else {
            puntajeRendimiento = 0;
        }

        int puntajeTotal = puntajePuntualidad + puntajeRendimiento;

        double bonificacion;
        if (puntajeTotal <= 10) {
            bonificacion = puntajeTotal * 2.5;
        } else if (puntajeTotal <= 20) {
            bonificacion = puntajeTotal * 5.0;
        } else if (puntajeTotal <= 30) {
            bonificacion = puntajeTotal * 7.5;
        } else if (puntajeTotal <= 40) {
            bonificacion = puntajeTotal * 10.0;
        } else {
            bonificacion = puntajeTotal * 12.5;
        }

        txtPuntajePuntualidad.setText(String.valueOf(puntajePuntualidad));
        txtPuntajeRendimiento.setText(String.valueOf(puntajeRendimiento));
        txtPuntajeTotal.setText(String.valueOf(puntajeTotal));
        txtBonificacion.setText(String.format("%.2f", bonificacion));
    }
}
