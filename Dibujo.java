import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Dibujo extends JPanel {
    
    public Dibujo() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Color color = new Color(50, 26, 94);
        g2d.setColor(Color.BLACK);
        g2d.setBackground(Color.black);
        g2d.clearRect(0, 0, getWidth(), getHeight());
        g2d.setStroke(new BasicStroke(4.0f));
        g2d.setColor(Color.GRAY);
        g2d.fill( new Arc2D.Float(68, 68, 170, 179, 35, 280, Arc2D.PIE) );
        g2d.setPaint(new GradientPaint(145, 180, Color.YELLOW, 
                                        50, 50, Color.LIGHT_GRAY, true));
        g2d.fill( new Arc2D.Float(70, 70, 175, 175, 35, 280, Arc2D.PIE) );
        g2d.fill( new Arc2D.Float(70, 70, 175, 175, 35, 200, Arc2D.PIE) );
        g2d.setColor(color);
        g2d.fill(new Ellipse2D.Float(140,110,18,18));
        g2d.setPaint(new GradientPaint(200, 100, new Color(232,214,19), 230, 160, Color.YELLOW, true));
        g2d.fill(new Ellipse2D.Float(200, 145, 30, 30));
        g2d.fill(new Ellipse2D.Float(270, 145, 30, 30));
        g2d.fill(new Ellipse2D.Float(340, 145, 30, 30));

    }
}
