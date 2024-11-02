package recursivos;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class frm07 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtEntrada;
    JTextField txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm07 frame = new frm07();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("unused")
    public frm07() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        txtEntrada = new JTextField();
        txtEntrada.setBounds(20, 20, 240, 30);
        txtEntrada.setMargin(new Insets(5, 5, 5, 5));
        txtEntrada.setToolTipText("Ingrese un número entero");
        getContentPane().add(txtEntrada);

        JButton btnCalcular = new JButton("Calcular Producto de Dígitos");
        btnCalcular.setBounds(20, 60, 200, 30);
        btnCalcular.addActionListener(e -> calcularProductoDigitos());
        getContentPane().add(btnCalcular);

        txtResultado = new JTextField();
        txtResultado.setBounds(20, 100, 240, 30);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);
    }

    protected void calcularProductoDigitos() {
        int numero = Integer.parseInt(txtEntrada.getText());
        int resultado = productoDigitos(Math.abs(numero));
        txtResultado.setText("Producto de Dígitos: " + resultado);
    }

    protected int productoDigitos(int n) {
        if (n < 10)
            return n;
        return (n % 10) * productoDigitos(n / 10);
    }
}
