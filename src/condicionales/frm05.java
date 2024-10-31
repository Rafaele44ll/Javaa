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

public class frm05 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero, txtMayorNumero;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm05 frame = new frm05();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm05() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("Número (4 cifras):");
        lblNumero.setBounds(50, 30, 120, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(180, 30, 60, 30);
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        JLabel lblMayorNumero = new JLabel("Mayor Número:");
        lblMayorNumero.setBounds(50, 80, 120, 30);
        getContentPane().add(lblMayorNumero);

        txtMayorNumero = new JTextField();
        txtMayorNumero.setBounds(180, 80, 60, 30);
        txtMayorNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMayorNumero.setMargin(new Insets(5, 5, 5, 5));
        txtMayorNumero.setEditable(false);
        getContentPane().add(txtMayorNumero);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(90, 130, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        int numero = Integer.parseInt(txtNumero.getText());

        // Obtener las cifras
        int cifra1 = numero / 1000;
        int cifra2 = (numero / 100) % 10;
        int cifra3 = (numero / 10) % 10;
        int cifra4 = numero % 10;

        // Inicializar mayor y menor cifras
        int mayor = cifra1;
        int menor = cifra1;

        // Encontrar la mayor y menor cifra
        if (cifra2 > mayor)
            mayor = cifra2;
        if (cifra3 > mayor)
            mayor = cifra3;
        if (cifra4 > mayor)
            mayor = cifra4;

        if (cifra2 < menor)
            menor = cifra2;
        if (cifra3 < menor)
            menor = cifra3;
        if (cifra4 < menor)
            menor = cifra4;

        // Formar el mayor número posible de dos cifras
        String mayorNumero = String.valueOf(mayor) + String.valueOf(menor);

        txtMayorNumero.setText(mayorNumero);
    }
}