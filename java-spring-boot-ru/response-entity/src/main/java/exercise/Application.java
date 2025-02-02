package exercise;

import java.net.URI;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok().header("X-Total-Count", String.valueOf(this.posts.size())).body(posts);
    }
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable String id) {
        var post = this.posts.stream().filter(p -> p.getId().equals(id)).findFirst();
        return post.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        this.posts.add(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable String id, @RequestBody Post post) {
        var updatedPost = this.posts.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (updatedPost.isPresent()) {
            updatedPost.get().setTitle(post.getTitle());
            updatedPost.get().setBody(post.getBody());
            return ResponseEntity.ok().body(updatedPost.get());
        } else {
            return ResponseEntity.status(204).build();
        }
    }
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
