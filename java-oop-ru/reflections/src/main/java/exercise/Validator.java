package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Object instance) {
        Class<?> someClass = instance.getClass();
        Field[] fields = someClass.getDeclaredFields();
        return Arrays.stream(fields).filter(field -> {
            return field.isAnnotationPresent(NotNull.class);
        }).filter(field -> {
            try {
                field.setAccessible(true);
                Object value = field.get(instance);
                return value == null;
            } catch (IllegalAccessException e) {
                return false;
            }
        }).map(Field::getName).toList();
    }
}
// END
