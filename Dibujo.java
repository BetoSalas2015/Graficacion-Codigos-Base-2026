import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Dibujo extends JPanel {
    Punto punto1, punto2;
    
    public Dibujo() {

    }

    public void asignaPuntos(Punto punto1, Punto punto2) {
        this.punto1 = punto1;
        this.punto2 = punto2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (punto1 != null && punto2 != null) {
            g.drawLine(punto1.getX(), punto1.getY(), punto2.getX(), punto2.getY());
        }

    }
}
