package exercise;
import java.lang.Math;

// BEGIN
public class Circle {
    private Point point;
    private int radius;

    public Circle(Point point, int radius){
        this.point = new Point(point.getX(), point.getY());
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
       if (radius < 0) throw new NegativeRadiusException("Не удалось посчитать площадь");
       return radius * radius * Math.PI;
    }


}
// END
