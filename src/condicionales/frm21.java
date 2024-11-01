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

public class frm21 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtCodigo, txtEstadoCivil, txtEdad, txtSexo;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm21 frame = new frm21();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm21() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(50, 50, 80, 30);
        getContentPane().add(lblCodigo);

        JLabel lblEstadoCivil = new JLabel("Estado Civil:");
        lblEstadoCivil.setBounds(50, 90, 80, 30);
        getContentPane().add(lblEstadoCivil);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(50, 130, 80, 30);
        getContentPane().add(lblEdad);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(50, 170, 80, 30);
        getContentPane().add(lblSexo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(130, 50, 80, 30);
        txtCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCodigo.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCodigo);

        txtEstadoCivil = new JTextField();
        txtEstadoCivil.setBounds(130, 90, 100, 30);
        txtEstadoCivil.setHorizontalAlignment(SwingConstants.RIGHT);
        txtEstadoCivil.setMargin(new Insets(5, 5, 5, 5));
        txtEstadoCivil.setEditable(false);
        getContentPane().add(txtEstadoCivil);

        txtEdad = new JTextField();
        txtEdad.setBounds(130, 130, 60, 30);
        txtEdad.setHorizontalAlignment(SwingConstants.RIGHT);
        txtEdad.setMargin(new Insets(5, 5, 5, 5));
        txtEdad.setEditable(false);
        getContentPane().add(txtEdad);

        txtSexo = new JTextField();
        txtSexo.setBounds(130, 170, 100, 30);
        txtSexo.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSexo.setMargin(new Insets(5, 5, 5, 5));
        txtSexo.setEditable(false);
        getContentPane().add(txtSexo);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 220, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        int codigo = Integer.parseInt(txtCodigo.getText());

        int estadoCivilNum = codigo / 1000;
        int edad = (codigo % 1000) / 10;
        int sexoNum = codigo % 10;

        String estadoCivil = switch (estadoCivilNum) {
            case 1 -> "Soltero";
            case 2 -> "Casado";
            case 3 -> "Divorciado";
            default -> "Viudo";
        };

        String sexo = sexoNum == 1 ? "Masculino" : "Femenino";

        txtEstadoCivil.setText(estadoCivil);
        txtEdad.setText(String.valueOf(edad));
        txtSexo.setText(sexo);
    }
}