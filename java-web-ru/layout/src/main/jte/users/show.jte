@param exercise.dto.users.UserPage page

@template.layout.page(
content = @`
    <h2>salam aleykum</h2>
        <div>${page.getUser().getFirstName()}</div>
        <div>${page.getUser().getLastName()}</div>
        <br>
`
)