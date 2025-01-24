package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        var currentPage = 1;
        if (ctx.queryParam("page") != null) {
            currentPage = ctx.queryParamAsClass("page", Integer.class).get();
        }
        var firstEl = (currentPage - 1) * 5;
        var posts = PostRepository.getEntities().subList(firstEl, firstEl + 5);

        var page = new PostsPage(posts, currentPage);
        ctx.render("posts/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }

    public static void build(Context ctx) {
        ctx.render("posts/build.jte");
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var body = ctx.formParam("body");

        var post = new Post(name, body);
        PostRepository.save(post);
        ctx.redirect(NamedRoutes.postsPath());
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found."));
        var page = new PostPage(post);
        ctx.render("posts/edit.jte", model("page", page));
    }


    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var name = ctx.formParam("name");
        var body = ctx.formParam("body");

        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        post.setName(name);
        post.setBody(body);
        PostRepository.save(post);
        ctx.redirect(NamedRoutes.postsPath());
    }

//    public static void destroy(Context ctx) {
//        var id = ctx.pathParamAsClass("id", Long.class).get();
//        PostRepository.delete(id);
//        ctx.redirect(NamedRoutes.postsPath());
//    }
    // END
}
