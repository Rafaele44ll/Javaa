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

public class frm37 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtVotosPamela, txtVotosCarol, txtVotosFanny, txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm37 frame = new frm37();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm37() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblVotosPamela = new JLabel("Votos Pamela:");
        lblVotosPamela.setBounds(50, 50, 100, 30);
        getContentPane().add(lblVotosPamela);

        JLabel lblVotosCarol = new JLabel("Votos Carol:");
        lblVotosCarol.setBounds(50, 90, 100, 30);
        getContentPane().add(lblVotosCarol);

        JLabel lblVotosFanny = new JLabel("Votos Fanny:");
        lblVotosFanny.setBounds(50, 130, 100, 30);
        getContentPane().add(lblVotosFanny);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(50, 170, 100, 30);
        getContentPane().add(lblResultado);

        txtVotosPamela = new JTextField();
        txtVotosPamela.setBounds(160, 50, 60, 30);
        txtVotosPamela.setHorizontalAlignment(SwingConstants.RIGHT);
        txtVotosPamela.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtVotosPamela);

        txtVotosCarol = new JTextField();
        txtVotosCarol.setBounds(160, 90, 60, 30);
        txtVotosCarol.setHorizontalAlignment(SwingConstants.RIGHT);
        txtVotosCarol.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtVotosCarol);

        txtVotosFanny = new JTextField();
        txtVotosFanny.setBounds(160, 130, 60, 30);
        txtVotosFanny.setHorizontalAlignment(SwingConstants.RIGHT);
        txtVotosFanny.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtVotosFanny);

        txtResultado = new JTextField();
        txtResultado.setBounds(160, 170, 160, 30);
        txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);

        JButton btnCalcular = new JButton("Calcular Resultado");
        btnCalcular.setBounds(120, 210, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularResultado();
            }
        });
    }

    protected void calcularResultado() {
        int votosPamela = Integer.parseInt(txtVotosPamela.getText());
        int votosCarol = Integer.parseInt(txtVotosCarol.getText());
        int votosFanny = Integer.parseInt(txtVotosFanny.getText());

        int totalVotos = votosPamela + votosCarol + votosFanny;
        int votosRequeridos = (totalVotos / 2) + 1;

        int[] votos = { votosPamela, votosCarol, votosFanny };
        String[] nombres = { "Pamela", "Carol", "Fanny" };

        int maxVotos = Math.max(votosPamela, Math.max(votosCarol, votosFanny));
        int segundoMaxVotos = Math.min(Math.max(votosPamela, votosCarol),
                Math.max(Math.max(votosPamela, votosFanny), votosCarol));

        int indicePrimero = (votos[0] == maxVotos ? 0 : (votos[1] == maxVotos ? 1 : 2));
        int indiceSegundo = (votos[0] == segundoMaxVotos && indicePrimero != 0 ? 0
                : (votos[1] == segundoMaxVotos && indicePrimero != 1 ? 1 : 2));

        int esEmpateTriple = (votosPamela == votosCarol && votosCarol == votosFanny) ? 1 : 0;
        int esEmpateSegundo = (votos[indicePrimero] == votos[indiceSegundo]) ? 1 : 0;

        String[] mensajes = {
                "Elección Anulada: Empate entre las tres candidatas",
                "Elección Anulada: Empate por segundo puesto",
                "Ganadora: " + nombres[indicePrimero],
                "Segunda vuelta entre " + nombres[indicePrimero] + " y " + nombres[indiceSegundo]
        };

        int indiceResultado = esEmpateTriple * 0 +
                (1 - esEmpateTriple) * (esEmpateSegundo * 1 +
                        (1 - esEmpateSegundo) * ((votos[indicePrimero] >= votosRequeridos ? 2 : 3)));

        String resultado = mensajes[indiceResultado];
        txtResultado.setText(resultado);
    }
}