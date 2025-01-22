@import exercise.dto.users.UsersPage
@import gg.jte.Content
@param Content content
@param UsersPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin</title>
</head>
<body>
<form action="/users" method="get">
    <input type="search" name="term" value="${page.getTerm()}" />
    <input type="submit" value="Search" />
</form>
@if (!page.getUsers().isEmpty())
    @for(var user : page.getUsers())
        <div>${user.getFirstName()}</div>
        <div>${user.getLastName()}</div>
    @endfor
@endif
<br>
${content}
</body>
</html>
