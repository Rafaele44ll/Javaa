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

public class frm38 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtMes, txtAnio, txtNombreMes, txtDias;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm38 frame = new frm38();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm38() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMes = new JLabel("Número del Mes:");
        lblMes.setBounds(50, 50, 120, 30);
        getContentPane().add(lblMes);

        JLabel lblAnio = new JLabel("Año:");
        lblAnio.setBounds(50, 90, 120, 30);
        getContentPane().add(lblAnio);

        JLabel lblNombreMes = new JLabel("Nombre del Mes:");
        lblNombreMes.setBounds(50, 130, 120, 30);
        getContentPane().add(lblNombreMes);

        JLabel lblDias = new JLabel("Cantidad de Días:");
        lblDias.setBounds(50, 170, 120, 30);
        getContentPane().add(lblDias);

        txtMes = new JTextField();
        txtMes.setBounds(180, 50, 60, 30);
        txtMes.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMes.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMes);

        txtAnio = new JTextField();
        txtAnio.setBounds(180, 90, 60, 30);
        txtAnio.setHorizontalAlignment(SwingConstants.RIGHT);
        txtAnio.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtAnio);

        txtNombreMes = new JTextField();
        txtNombreMes.setBounds(180, 130, 120, 30);
        txtNombreMes.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNombreMes.setMargin(new Insets(5, 5, 5, 5));
        txtNombreMes.setEditable(false);
        getContentPane().add(txtNombreMes);

        txtDias = new JTextField();
        txtDias.setBounds(180, 170, 60, 30);
        txtDias.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDias.setMargin(new Insets(5, 5, 5, 5));
        txtDias.setEditable(false);
        getContentPane().add(txtDias);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 210, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMesYDias();
            }
        });
    }

    protected void calcularMesYDias() {
        int mes = Integer.parseInt(txtMes.getText());
        int anio = Integer.parseInt(txtAnio.getText());

        // Determinación del nombre del mes
        String[] nombresMeses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };
        String nombreMes = nombresMeses[mes - 1];

        int esBisiesto = ((anio % 4 == 0 ? 1 : 0)
                * (1 - ((anio % 100 == 0 ? 1 : 0) * (1 - (anio % 400 == 0 ? 1 : 0)))));

        int[] diasMeses = { 31, 28 + esBisiesto, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int dias = diasMeses[mes - 1];

        txtNombreMes.setText(nombreMes);
        txtDias.setText(String.valueOf(dias));
    }
}
