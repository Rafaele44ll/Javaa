package repetitivos;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm02 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtMultiplicando, txtMultiplicador, txtProducto;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm02 frame = new frm02();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("unused")
    public frm02() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMultiplicando = new JLabel("Multiplicando :");
        lblMultiplicando.setBounds(50, 50, 100, 30);
        getContentPane().add(lblMultiplicando);

        JLabel lblMultiplicador = new JLabel("Multiplicador :");
        lblMultiplicador.setBounds(50, 90, 100, 30);
        getContentPane().add(lblMultiplicador);

        JLabel lblProducto = new JLabel("Producto :");
        lblProducto.setBounds(50, 130, 100, 30);
        getContentPane().add(lblProducto);

        txtMultiplicando = new JTextField();
        txtMultiplicando.setBounds(150, 50, 60, 30);
        txtMultiplicando.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMultiplicando.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMultiplicando);

        txtMultiplicador = new JTextField();
        txtMultiplicador.setBounds(150, 90, 60, 30);
        txtMultiplicador.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMultiplicador.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMultiplicador);

        txtProducto = new JTextField();
        txtProducto.setBounds(150, 130, 60, 30);
        txtProducto.setFocusable(false);
        txtProducto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtProducto.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtProducto);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 200, 100, 30);
        btnCalcular.setMnemonic('a');
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());

    }

    protected void btnCalcular_actionPerformed() {
        int multiplicando = Integer.parseInt(txtMultiplicando.getText());
        int multiplicador = Integer.parseInt(txtMultiplicador.getText());

        /*
         * int producto = 0;
         * while ( multiplicador-- > 0 )
         * producto += multiplicando;
         * 
         * txtProducto.setText( "" + producto );
         * 
         */

        /*
         * for ( int n = multiplicando ; multiplicador > 1; multiplicador-- )
         * multiplicando += n;
         * 
         * txtProducto.setText( "" + multiplicando );
         */

        // for ( int n = multiplicando ; multiplicador-- > 1; multiplicando += n );
        // txtProducto.setText( "" + multiplicando );

        txtProducto.setText("" + multiplicar(multiplicando, multiplicador));
    }

    private int multiplicar(int multiplicando, int multiplicador) {
        if (multiplicador == 1)
            return multiplicando;
        return multiplicando + multiplicar(multiplicando, multiplicador - 1);
    }

}