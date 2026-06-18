import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;


public class Ventana extends JFrame {
    private final int HEIGHT = 400;
    private final int WIDTH = 400;
    private Dibujo dibujo;

    public Ventana() {
        super("Gráficos en Java");
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dibujo = new Dibujo();
        setLayout(new BorderLayout());
        add(dibujo, "Center"); 
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
