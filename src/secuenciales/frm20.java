package secuenciales;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Insets;

public class frm20 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtCantidad;
    private JLabel lblBilletes200, lblBilletes100, lblBilletes50, lblBilletes20, lblBilletes10;
    private JLabel lblMonedas5, lblMonedas2, lblMonedas1;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm20 frame = new frm20();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @SuppressWarnings("unused")
    public frm20() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 600);
        setLayout(null);
        setLocationRelativeTo(null);

        agregarCampoEntrada("Cantidad en Soles:", 50, txtCantidad = new JTextField());

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(50, 150, 250, 30);
        getContentPane().add(btnCalcular);
        btnCalcular.addActionListener(e -> descomponerDinero());

        agregarCampoResultado("Billetes de 200:", 200, lblBilletes200 = new JLabel("0"));
        agregarCampoResultado("Billetes de 100:", 250, lblBilletes100 = new JLabel("0"));
        agregarCampoResultado("Billetes de 50:", 300, lblBilletes50 = new JLabel("0"));
        agregarCampoResultado("Billetes de 20:", 350, lblBilletes20 = new JLabel("0"));
        agregarCampoResultado("Billetes de 10:", 400, lblBilletes10 = new JLabel("0"));
        agregarCampoResultado("Monedas de 5:", 450, lblMonedas5 = new JLabel("0"));
        agregarCampoResultado("Monedas de 2:", 500, lblMonedas2 = new JLabel("0"));
        agregarCampoResultado("Monedas de 1:", 550, lblMonedas1 = new JLabel("0"));
    }

    private void agregarCampoEntrada(String etiqueta, int posY, JTextField campo) {
        JLabel lbl = new JLabel(etiqueta);
        lbl.setBounds(50, posY, 150, 30);
        getContentPane().add(lbl);

        campo.setBounds(200, posY, 100, 30);
        campo.setHorizontalAlignment(JTextField.RIGHT);
        campo.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(campo);
    }

    private void agregarCampoResultado(String etiqueta, int posY, JLabel campo) {
        JLabel lbl = new JLabel(etiqueta);
        lbl.setBounds(50, posY, 150, 30);
        getContentPane().add(lbl);

        campo.setBounds(200, posY, 100, 30);
        campo.setHorizontalAlignment(JLabel.RIGHT);
        getContentPane().add(campo);
    }

    private void descomponerDinero() {
        int cantidad = Integer.parseInt(txtCantidad.getText());

        int billetes200 = cantidad / 200;
        cantidad -= billetes200 * 200;

        int billetes100 = cantidad / 100;
        cantidad -= billetes100 * 100;

        int billetes50 = cantidad / 50;
        cantidad -= billetes50 * 50;

        int billetes20 = cantidad / 20;
        cantidad -= billetes20 * 20;

        int billetes10 = cantidad / 10;
        cantidad -= billetes10 * 10;

        int monedas5 = cantidad / 5;
        cantidad -= monedas5 * 5;

        int monedas2 = cantidad / 2;
        int monedas1 = cantidad - (monedas2 * 2);

        lblBilletes200.setText(Integer.toString(billetes200));
        lblBilletes100.setText(Integer.toString(billetes100));
        lblBilletes50.setText(Integer.toString(billetes50));
        lblBilletes20.setText(Integer.toString(billetes20));
        lblBilletes10.setText(Integer.toString(billetes10));
        lblMonedas5.setText(Integer.toString(monedas5));
        lblMonedas2.setText(Integer.toString(monedas2));
        lblMonedas1.setText(Integer.toString(monedas1));
    }
}