package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int sublist) {
        if (apartments.isEmpty()) {
            return new ArrayList<>();
        }
        var newList = apartments.stream().sorted((a, b) -> (int) (a.getArea() - b.getArea())).map(Object::toString).toList();

        return newList.subList(0, sublist);
    }
}
// END
