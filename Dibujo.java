import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Vector;

public class Dibujo extends JPanel {
    private Vector<Point> vectorPuntos;
    
    public Dibujo() {

    }

    public void asignaPuntos(Vector<Point> vector) {
        this.vectorPuntos = vector;
    }

    private void planoCoordenado(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        setBackground(new Color(0xAA, 0xCC, 0xD6));
        int h = getSize().height / 2;
        int w = getSize().width / 2;
        g2d.translate(w, h);
        g2d.setStroke(new BasicStroke(2.0f));
        g2d.setColor(new Color(0x43, 0x82, 0xDF));
        for (int i = 0; i > -w; i-= 20) {
            g2d.draw(new Line2D.Float(i,-h,i,h));
        }
        for (int i = 0; i > -h; i-= 20) {
            g2d.draw(new Line2D.Float(-w,i,w,i));
        }
        for (int i = 0; i < w; i+= 20) {
            g2d.draw(new Line2D.Float(i,-h,i,h));
        }
        for (int i = 0; i < h; i+= 20) {
            g2d.draw(new Line2D.Float(-w,i,w,i));
        }
        g2d.setStroke(new BasicStroke(3.0f));
        g2d.setColor(new Color(0x46, 0x47, 0xAE));
        g2d.draw(new Line2D.Float(-w,0,w,0));
        g2d.draw(new Line2D.Float(0, -h, 0, h));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Graficamos el plano coordenado
        planoCoordenado(g);
        // Graficamos nuestros puntos
        g2d.setColor(new Color(0x11, 0x2E, 0x81));
        g2d.setStroke(new BasicStroke(2.5f));
        int i;
        if (vectorPuntos != null && vectorPuntos.size() > 2) {
            for (i = 0; i < vectorPuntos.size() - 1; i++) {
                g2d.draw(new Line2D.Float(vectorPuntos.get(i), vectorPuntos.get(i + 1)));
            }
            g2d.draw(new Line2D.Float(vectorPuntos.get(i), vectorPuntos.get(0)));

        }

    }
}
