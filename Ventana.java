import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    private JMenuBar menuBar;
    private JMenu mnuArchivo, mnuGraficar;
    private JMenuItem itemCargar, itemSalir, itemAgregarPunto, itemLineaUno;

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

        // Barra de Menus 
        crearMenu();

        // Gestión de Eventos
        //btnGraficar.addActionListener(new BotonGrafica());
        //btnAgregar.addActionListener(new BotonAgregar());
        itemCargar.addActionListener(new BotonCargar());
        itemSalir.addActionListener(new MenuSalir());
        itemAgregarPunto.addActionListener(new BotonAgregar());
        itemLineaUno.addActionListener(new LineaUno());

        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // Clases para la gestión de eventos
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
            DialogoCoordenada dlgCoordenada = new DialogoCoordenada(Ventana.this);
            if (dlgCoordenada.isOk()) {
                Point p = dlgCoordenada.getResultado();
                vectorPuntos.add(p);
                dibujo.repaint();
            }
        }
        
    }

    private class BotonCargar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String c, cad1, cad2;
            StringTokenizer token;

            File carpetaActual = new File(System.getProperty("user.dir"));

            JFileChooser chooser = new JFileChooser(carpetaActual);
            FileNameExtensionFilter filtroTxt = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
            chooser.setFileFilter(filtroTxt);
            int r = chooser.showOpenDialog(Ventana.this);
            if (r != JFileChooser.APPROVE_OPTION) {
                return;     // El usuario canceló
            }
            File archivo = chooser.getSelectedFile();
            vectorPuntos = new Vector<Point>();
            try {
                entrada = new BufferedReader(new FileReader(archivo));
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
                JOptionPane.showMessageDialog(Ventana.this, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex ) {
                JOptionPane.showMessageDialog(Ventana.this, "El archivo no contiene numeros","Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }

    private class MenuSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    }

    private class LineaUno implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DemoGraficos demo = new DemoGraficos();
            demo.setIncremento(3);
            vectorPuntos = demo.lineaDos(30, 150);
            dibujo.asignaPuntos(vectorPuntos);
            repaint();
        }
        
    }

    // Métodos Generales
    private void crearMenu() {
        // Barra de Menus 
        menuBar = new JMenuBar();
        mnuArchivo = new JMenu("Archivo"); 
        mnuGraficar = new JMenu("Graficar");
        itemCargar = new JMenuItem("Cargar Puntos...");
        itemSalir = new JMenuItem("Salir");
        itemAgregarPunto = new JMenuItem("Agregar Punto...");
        itemLineaUno = new JMenuItem("Linea Uno");

        // Construir el menú "Archivo"
        mnuArchivo.add(itemCargar);
        mnuArchivo.addSeparator(); // El separador queda mejor entre ambos items
        mnuArchivo.add(itemSalir);

        // Construir el menu "Graficar"
        mnuGraficar.add(itemAgregarPunto);
        mnuGraficar.add(itemLineaUno);

        // Agregar los JMenu a la barra de menús
        menuBar.add(mnuArchivo);
        menuBar.add(mnuGraficar);

        // 4. Asignar la barra de menús completada a la ventana (JFrame)
        setJMenuBar(menuBar);

        setJMenuBar(menuBar);
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
