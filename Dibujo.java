import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Dibujo extends JPanel {
    int x1, y1, x2, y2;
    
    public Dibujo() {

    }

    public void asignaPuntos(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(x1, y1, x2, y2);

    }
}
