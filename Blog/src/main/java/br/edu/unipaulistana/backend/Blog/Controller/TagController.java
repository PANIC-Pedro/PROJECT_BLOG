package br.edu.unipaulistana.backend.Blog.Controller;

import br.edu.unipaulistana.backend.Blog.Service.TagService;
import br.edu.unipaulistana.backend.Blog.domainmodel.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.List;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping
    public ResponseEntity<List<Tag>> findAll(){
        return ResponseEntity.ok(tagService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tag> findTagById(@PathVariable long id){
        return ResponseEntity.ok((Tag) tagService.findTagById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteTagById(@PathVariable long id){
        this.tagService.deleteById(id);
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Tag> CreateTag (@RequestBody Tag tag){
        return new ResponseEntity<>(tagService.create(tag), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Tag> UpdateTag(@RequestBody Tag tag){
        return new ResponseEntity<>(tagService.update(tag),HttpStatus.CREATED);
    }
    @PatchMapping
    public ResponseEntity<Tag> PatchTag(@RequestBody Tag tag){
        return new ResponseEntity<>(tagService.partialUpdate(tag),HttpStatus.CREATED);
    }


}
