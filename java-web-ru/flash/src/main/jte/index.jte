@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    content = @`
        <h2>Welcome to Hexlet</h2>
    @for(var post : page.getPosts())
        <p>${post.getName()}</p>
        <p>${post.getBody()}</p>
    @endfor
    `
)
