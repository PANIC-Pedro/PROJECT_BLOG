package br.edu.unipaulistana.backend.Blog.Controller;

import br.edu.unipaulistana.backend.Blog.Service.ProfileService;
import br.edu.unipaulistana.backend.Blog.domainmodel.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileservice;

    @GetMapping
    public ResponseEntity<List<Profile>> findAll(){
        return  ResponseEntity.ok(profileservice.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Profile> findByProfileId(@PathVariable long id){
        return  ResponseEntity.ok((Profile) profileservice.findByProfileId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByProfileId(@PathVariable long id){
        this.profileservice.deleteById(id);
        return ResponseEntity.notFound().build();
    }
@PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile){
        return new ResponseEntity<>(profileservice.create(profile), HttpStatus.CREATED);
}
@PutMapping
    public ResponseEntity<Profile> modifyProfile(@RequestBody Profile profile){
        return new ResponseEntity<>(profileservice.update(profile), HttpStatus.CREATED);
}
@PatchMapping
    public ResponseEntity<Profile> patchProfile(@RequestBody Profile profile){
        return new ResponseEntity<>(profileservice.partialUpdate(profile), HttpStatus.CREATED);

}


}


