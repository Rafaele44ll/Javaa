package repetitivos;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class frm10 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextArea txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm10 frame = new frm10();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("unused")
    public frm10() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JButton btnCalcular = new JButton("Calcular Números");
        btnCalcular.setBounds(20, 20, 150, 30);
        btnCalcular.addActionListener(e -> calcularNumeros());
        getContentPane().add(btnCalcular);

        txtResultado = new JTextArea();
        txtResultado.setBounds(20, 70, 340, 180);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);
    }

    protected void calcularNumeros() {
        StringBuilder resultado = new StringBuilder();
        int contador = 0;

        for (int i = 1000; i <= 9999; i++) {
            int mil = (i / 1000) % 10;
            int centena = (i / 100) % 10;
            int decena = (i / 10) % 10;
            int unidad = i % 10;

            int sumaPares = (mil % 2 == 0 ? mil : 0) + (centena % 2 == 0 ? centena : 0) +
                    (decena % 2 == 0 ? decena : 0) + (unidad % 2 == 0 ? unidad : 0);
            int sumaImpares = (mil % 2 != 0 ? mil : 0) + (centena % 2 != 0 ? centena : 0) +
                    (decena % 2 != 0 ? decena : 0) + (unidad % 2 != 0 ? unidad : 0);

            if (sumaPares == sumaImpares) {
                resultado.append(i).append(" ");
                contador++;
            }
        }

        resultado.append("\nTotal de números encontrados: ").append(contador);
        txtResultado.setText(resultado.toString());
    }
}
