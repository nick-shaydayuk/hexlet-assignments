package exercise;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;
import java.util.List;
import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import exercise.repository.ArticleRepository;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/articles/build", ctx -> {
            ctx.render("articles/build.jte", model("page", new BuildArticlePage()));
        });
        app.post("/articles", ctx -> {

            try {
                var title = ctx.formParamAsClass("title", String.class)
                        .check(val -> val.length() >= 2, "Название не должно быть короче двух символов")
                        .check(val -> ArticleRepository.findByTitle(val).isEmpty(), "Статья с таким названием уже существует");
                var content = ctx.formParamAsClass("content", String.class)
                        .check(val -> val.length() >= 10, "Статья должна быть не короче 10 символов");
                var article = new Article(title.get(), content.get());
                ArticleRepository.save(article);
                ctx.status(302);
                ctx.redirect("/articles");
            } catch (ValidationException e) {
                var title = ctx.formParam("title");
                var content = ctx.formParam("content");
                var page = new BuildArticlePage(title, content, e.getErrors());
                ctx.status(422);
                ctx.render("articles/build.jte", model("page", page));
            }
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
