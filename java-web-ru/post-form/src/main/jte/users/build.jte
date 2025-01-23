@import exercise.dto.users.UsersPage
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
    <label>
        firstName
        <input type="text" name="firstName" value="" />
    </label>
    <label>
        lastName
        <input type="text" name="lastName" value="" />
    </label>
    <label>
        email
        <input type="email" name="email" value="" />
    </label>
    <label>
        password
        <input type="password" name="password" value="" />
    </label>
</form>
<br>
</body>
</html>