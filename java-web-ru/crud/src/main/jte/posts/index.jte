@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Все статьи</h1>

            <div class="mb-3">
                <a href="/posts/build">Создать новый пост</a>
            </div>
            <a href="?page=${page.getPage() + 1}" >некст</a>
            <a href="?page=${page.getPage() - 1}" >prev</a>
            <table class="table table-striped">
                @for(var article : page.getPosts())
                    <tr>
                        <td>
                            <a href="${NamedRoutes.postPath(article.getId())}">ssilka</a>
                        </td>
                        <td>
                            ${article.getName()}
                        </td>
                        <td>
                            ${article.getBody()}
                        </td>
                    </tr>
                @endfor
            </table>
        </main>
    </div>
`
)
