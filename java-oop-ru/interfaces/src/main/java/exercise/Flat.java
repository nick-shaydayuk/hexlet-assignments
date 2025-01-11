package exercise;

import lombok.AllArgsConstructor;

// BEGIN
@AllArgsConstructor
public class Flat implements Home {

    private double area;
    private double balconyArea;
    private int floor;

    @Override
    public double getArea() {
        return this.area + this.balconyArea;
    }

    @Override
    public int compareTo(Home comparable) {
        if (this.getArea() > comparable.getArea()) {
            return 1;
        } else if (this.getArea() < comparable.getArea()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + this.getArea() + " метров на " + this.floor + " этаже";
    }
}
// END
