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

public class frm03 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtAngulo, txtClasificacion;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm03 frame = new frm03();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm03() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblAngulo = new JLabel("Ángulo (°):");
        lblAngulo.setBounds(50, 50, 80, 30);
        getContentPane().add(lblAngulo);

        txtAngulo = new JTextField();
        txtAngulo.setBounds(130, 50, 60, 30);
        txtAngulo.setHorizontalAlignment(SwingConstants.RIGHT);
        txtAngulo.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtAngulo);

        JLabel lblClasificacion = new JLabel("Clasificación:");
        lblClasificacion.setBounds(50, 100, 100, 30);
        getContentPane().add(lblClasificacion);

        txtClasificacion = new JTextField();
        txtClasificacion.setBounds(130, 100, 120, 30);
        txtClasificacion.setEditable(false);
        txtClasificacion.setHorizontalAlignment(SwingConstants.RIGHT);
        txtClasificacion.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtClasificacion);

        JButton btnClasificar = new JButton("Clasificar");
        btnClasificar.setBounds(80, 140, 100, 30);
        getContentPane().add(btnClasificar);

        btnClasificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnClasificar_actionPerformed();
            }
        });
    }

    protected void btnClasificar_actionPerformed() {
        double angulo = Double.parseDouble(txtAngulo.getText());
        String clasificacion = "";

        clasificacion = (angulo == 0) ? "Nulo"
                : (angulo > 0 && angulo < 90) ? "Agudo"
                        : (angulo == 90) ? "Recto"
                                : (angulo > 90 && angulo < 180) ? "Obtuso"
                                        : (angulo == 180) ? "Llano"
                                                : (angulo > 180 && angulo < 360) ? "Cóncavo"
                                                        : (angulo == 360) ? "Completo" : "Ángulo inválido";

        txtClasificacion.setText(clasificacion);
    }
}
