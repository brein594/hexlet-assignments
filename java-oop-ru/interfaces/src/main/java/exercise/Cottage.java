package exercise;

import lombok.Getter;

// BEGIN
@Getter
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }


    public String toString() {
        var result = String.format("%d этажный коттедж площадью %.01f метров", floorCount, area);
        System.out.println(result);
        return result;
    }

    public int compareTo(Home another) {
        if (another.getArea() < this.area) {
            return 1;
        } else if (another.getArea() == this.area) {
            return 0;
        } else {
            return -1;
        }
    }
}
// END
