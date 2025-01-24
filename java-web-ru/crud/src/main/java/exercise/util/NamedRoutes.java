package exercise.util;

import gg.jte.TemplateOutput;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPath() { return "/posts"; }

    public static String postPath(Long id) { return String.format("/posts/{%s}", id); }
    // END
}
