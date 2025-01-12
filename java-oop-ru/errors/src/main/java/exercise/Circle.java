package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
@AllArgsConstructor
@Getter
public class Circle {
    private Point point;
    private int radius;

    public double getSquare() throws NegativeRadiusException {
        var r = getRadius();
        if (r < 0) {
            throw new NegativeRadiusException("");
        }
        return Math.PI * r * r;
    }
}
// END
