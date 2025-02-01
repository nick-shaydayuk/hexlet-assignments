package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (var method : Address.class.getMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                var name = method.getName();
                var type = method.getReturnType().getSimpleName();
                System.out.printf("Method %s returns a value of type %s%n", name, type);

            }
        }
        // END
    }
}
