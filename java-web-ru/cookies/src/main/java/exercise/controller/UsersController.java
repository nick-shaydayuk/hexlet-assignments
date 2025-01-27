package exercise.controller;

import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
            var firstName = ctx.formParamAsClass("firstName", String.class).get();
            var lastName = ctx.formParamAsClass("lastName", String.class).get();
            var email = ctx.formParamAsClass("email", String.class).get();
            var password = ctx.formParamAsClass("password", String.class).get();
            var token = Security.generateToken();
            ctx.cookie("token", String.valueOf(token));

            var user = new User(firstName, lastName, email, Security.encrypt(password), token);
            UserRepository.save(user);
            ctx.redirect("/users/" + user.getId().toString());
    }
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Post not found"));
        if (!user.getToken().equals(ctx.cookie("token"))) {
            ctx.redirect("build");
        }
        System.out.println(user);
        System.out.println(ctx.cookie("token"));
        System.out.println(user.getToken().equals(ctx.cookie("token")));
        var page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));
    }
    // END
}
