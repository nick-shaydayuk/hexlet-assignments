package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        var page = new LoginPage(ctx.sessionAttribute("currentUser"), ctx.sessionAttribute("error"));
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParamAsClass("name", String.class).get();
        var password = ctx.formParamAsClass("password", String.class).get();
        var user = UsersRepository.findByName(name).isPresent() ? UsersRepository.findByName(name).get() : null;
        if (user != null) {
            var encPassword = encrypt(password).hashCode();
            if (user.getName().equals(name) && user.getPassword().hashCode() == encPassword) {
                ctx.sessionAttribute("currentUser", user.getName());
                ctx.status(302);
                ctx.redirect("/");
            } else {
                ctx.sessionAttribute("error", "Wrong username or password");
                ctx.status(400);
                ctx.redirect("sessions/build");
            }
        }

    }
    public static void delete(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
    // END
}
