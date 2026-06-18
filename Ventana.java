import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Ventana extends JFrame {
    private final int HEIGHT = 400;
    private final int WIDTH = 400;
    private Dibujo dibujo;
    private JPanel panelDatos, panelPunto1;
    private JLabel lblPunto1;
    private JTextField txtPunto1x, txtPunto1y;
    private JButton btnGraficar, btnAgregar, btnCargar;
    private Vector<Point> vectorPuntos;
    private BufferedReader entrada;

    public Ventana() {
        super("Gráficos en Java");
        dibujo = new Dibujo();
        vectorPuntos = new Vector<>();

        // Interfaz de Usuario
        panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(1, 10));    // 1 reglón, 10 columnas
        panelPunto1 = new JPanel();
        panelPunto1.setLayout(new GridLayout(1,2));     // 1 renglón, 2 columnas

        lblPunto1 = new JLabel("Punto 1");

        txtPunto1x = new JTextField("0");
        txtPunto1y = new JTextField("0");

        //btnGraficar = new JButton("¡Graficar!");
        //btnAgregar = new JButton("Agregar Punto");
        btnCargar = new JButton("Cargar puntos");

        panelPunto1.add(txtPunto1x); panelPunto1.add(txtPunto1y);

        panelDatos.add(lblPunto1);
        panelDatos.add(panelPunto1);
        //panelDatos.add(btnAgregar);

        setLayout(new BorderLayout());
        //add(panelDatos, "North");
        add(dibujo, "Center");
        add(btnCargar, "South");

        // Gestión de Eventos
        //btnGraficar.addActionListener(new BotonGrafica());
        //btnAgregar.addActionListener(new BotonAgregar());
        btnCargar.addActionListener(new BotonCargar());

        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private class BotonGrafica implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            dibujo.asignaPuntos(vectorPuntos);
            repaint();
            
        }
    }

    private class BotonAgregar implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent e) {
           vectorPuntos.add(new Point(Integer.parseInt(txtPunto1x.getText()), 
                                      Integer.parseInt(txtPunto1y.getText())));
        }
    }

    private class BotonCargar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String c, cad1, cad2;
            StringTokenizer token;

            vectorPuntos = new Vector<Point>();
            try {
                entrada = new BufferedReader(new FileReader("coordenadas.txt"));
                while ((c = entrada.readLine()) != null) {
                    token = new StringTokenizer(c, ",");
                    cad1 = token.nextToken();
                    cad2 = token.nextToken();

                    vectorPuntos.add(new Point(Integer.parseInt(cad1), 
                                               Integer.parseInt(cad2)));
                }
                entrada.close();
                dibujo.asignaPuntos(vectorPuntos);
                dibujo.repaint();
            } catch (IOException ex) {
                System.out.println("El Archivo no se pudo abrir.");
            }
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
