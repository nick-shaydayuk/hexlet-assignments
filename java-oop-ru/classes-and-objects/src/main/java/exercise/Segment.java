package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
@AllArgsConstructor
@Getter
public class Segment {
    private Point beginPoint;
    private Point endPoint;

    public Point getMidPoint() {
        var x = (this.beginPoint.getX() + this.endPoint.getX()) / 2;
        var y = (this.beginPoint.getY() + this.endPoint.getY()) / 2;

        return new Point(x, y);
    }
}
// END
