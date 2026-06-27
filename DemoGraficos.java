import java.util.Vector;
import java.awt.Point;

public class DemoGraficos {
    private int incremento;

    public DemoGraficos() {
        incremento = 1;
    }

    public void setIncremento(int incremento) {
        this.incremento = incremento;
    }

    public float getIncremento() {
        return incremento;
    }

    // Métodos para gráficos
    public Vector<Point> lineaUno(int x1, int x2) {
        Vector<Point> nuevoVector = new Vector<>();
        for(int i = x1; i < x2; i += incremento ) {
            Point point = new Point(i, i);
            nuevoVector.add(point);
        }
        return nuevoVector;
    }

        public Vector<Point> lineaDos(int x1, int x2) {
            Vector<Point> nuevoVector = new Vector<>();
            for(int i = x1; i < x2; i += incremento ) {
                Point point = new Point(-i, -i);
                nuevoVector.add(point);
            }
            return nuevoVector;
        }
}
