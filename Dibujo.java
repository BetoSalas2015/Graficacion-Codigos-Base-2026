import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Vector;

public class Dibujo extends JPanel {
    private Vector<Punto> vectorPuntos;
    
    public Dibujo() {

    }

    public void asignaPuntos(Vector<Punto> vector) {
        this.vectorPuntos = vector;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int i;
        if (vectorPuntos != null && vectorPuntos.size() > 2) {
            for (i = 0; i < vectorPuntos.size() - 1; i++) {
                g.drawLine(vectorPuntos.get(i).getX(), vectorPuntos.get(i).getY(), 
                            vectorPuntos.get(i + 1).getX(), vectorPuntos.get(i + 1).getY());
            }
            g.drawLine(vectorPuntos.get(i).getX(), vectorPuntos.get(i).getY(), 
                            vectorPuntos.get(0).getX(), vectorPuntos.get(0).getY());
        }

    }
}
