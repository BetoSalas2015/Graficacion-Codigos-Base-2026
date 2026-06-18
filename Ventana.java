import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ventana extends JFrame {
    private final int HEIGHT = 400;
    private final int WIDTH = 400;
    private Dibujo dibujo;
    private JPanel panelDatos, panelPunto1, panelPunto2;
    private JLabel lblPunto1, lblPunto2;
    private JTextField txtPunto1x, txtPunto1y, txtPunto2x, txtPunto2y;
    private JButton btnGraficar;

    public Ventana() {
        super("Gráficos en Java");
        dibujo = new Dibujo();

        // Interfaz de Usuario
        panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(1, 10));    // 1 reglón, 10 columnas
        panelPunto1 = new JPanel();
        panelPunto1.setLayout(new GridLayout(1,2));     // 1 renglón, 2 columnas
        panelPunto2 = new JPanel();
        panelPunto2.setLayout(new GridLayout(1, 2));    // 1 reglon, 2 columnas

        lblPunto1 = new JLabel("Punto 1");
        lblPunto2 = new JLabel("Punto 2");

        txtPunto1x = new JTextField("0");
        txtPunto1y = new JTextField("0");
        txtPunto2x = new JTextField("0");
        txtPunto2y = new JTextField("0");

        btnGraficar = new JButton("¡Graficar!");

        panelPunto1.add(txtPunto1x); panelPunto1.add(txtPunto1y);
        panelPunto2.add(txtPunto2x); panelPunto2.add(txtPunto2y);

        panelDatos.add(lblPunto1);
        panelDatos.add(panelPunto1);
        panelDatos.add(lblPunto2);
        panelDatos.add(panelPunto2);

        setLayout(new BorderLayout());
        add(panelDatos, "North");
        add(dibujo, "Center");
        add(btnGraficar, "South");

        // Gestión de Eventos
        btnGraficar.addActionListener(new BotonGrafica());

        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    private class BotonGrafica implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Punto punto1 = new Punto(Integer.parseInt(txtPunto1x.getText()), 
                                      Integer.parseInt(txtPunto1y.getText()));
            Punto punto2 = new Punto(Integer.parseInt(txtPunto2x.getText()), 
                                     Integer.parseInt(txtPunto2y.getText()));

            dibujo.asignaPuntos(punto1, punto2);
            repaint();
            
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana();
            }
        });
    }
}
