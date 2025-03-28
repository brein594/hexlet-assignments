package exercise;

//import lombok.Getter;

// BEGIN
//@Getter
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public double getArea() {
        return area + balconyArea;
    }

    public int getFloor() {
        return floor;
    }

    public String toString() {
        var result = String.format("Квартира площадью %.01f метров на %d этаже", getArea(), getFloor());
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
