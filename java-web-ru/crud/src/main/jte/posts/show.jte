@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Все статьи</h1>

            <div class="mb-3">
                <a href="${NamedRoutes.postsPath()}">к постам</a>
            </div>

            <table class="table table-striped">
                    <tr>
                        <td>
                            ${page.getPost().getName()}
                        </td>
                        <td>
                            ${page.getPost().getBody()}
                        </td>
                    </tr>
            </table>
        </main>
    </div>
`
)
