package exercise;

import lombok.AllArgsConstructor;

// BEGIN
@AllArgsConstructor
public class Cottage implements Home {
    private double area;
    private int floorCount;

    @Override
    public double getArea() {
        return this.area * this.floorCount;
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
        return this.floorCount + " этажный коттедж площадью " + this.area + " метров";
    }
}
// END
