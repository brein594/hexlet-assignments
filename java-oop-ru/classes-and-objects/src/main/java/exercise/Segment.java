package exercise;

import lombok.Getter;

// BEGIN
public class Segment {
    @Getter
    private Point beginPoint;
    @Getter
    private Point endPoint;
    private Point midPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getMidPoint() {
        var pointX = endPoint.getX - beginPoint.getX;
        var pointY = endPoint.getY - beginPoint.getY;
        var result = new Point(pointX, pointY);
        midPoint = result;
        return midPoint;
    }
}
// END
