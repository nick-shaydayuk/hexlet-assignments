@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin</title>
</head>
<body>
<br>
@if (page.getErrors() != null)
    @for (var validator : page.getErrors().values())
        @for (var e : validator)
            <li>${e.getMessage()}</li>
        @endfor
    @endfor
@endif
<br>
<form action="/articles" method="post">
    <label>
        title
        <input type="text" name="title" value="${page.getTitle() != null ? page.getTitle() : ""}" />
    </label>
    <label>
        content
        <input type="text" name="content" value="${page.getContent() != null ? page.getContent() : ""}" />
    </label>
</form>
<br>
</body>
</html>