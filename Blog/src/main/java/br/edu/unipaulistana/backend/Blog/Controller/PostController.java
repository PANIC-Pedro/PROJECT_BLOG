package br.edu.unipaulistana.backend.Blog.Controller;

import br.edu.unipaulistana.backend.Blog.Service.PostService;
import br.edu.unipaulistana.backend.Blog.domainmodel.Post;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable long id){
        return ResponseEntity.ok((Post) postService.findPostById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable long id){
    this.postService.deleteById(id);
    return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        return new ResponseEntity<>(postService.create(post), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Post> modifyPost(@RequestBody Post post){
        return new ResponseEntity<>(postService.update(post), HttpStatus.CREATED);
    }
    @PatchMapping
    public ResponseEntity<Post> patchPost(@RequestBody Post post){
        return new ResponseEntity<>(postService.partialUpdate(post), HttpStatus.CREATED);
    }


}
