@param exercise.dto.users.UsersPage page

@template.layout.page(
content= @`
    <h2>salam</h2>
    @for(var user : page.getUsers())
        <div>${user.getFirstName()}</div>
        <div>${user.getLastName()}</div>
        <br>
    @endfor
`
)