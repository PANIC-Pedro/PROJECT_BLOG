package br.edu.unipaulistana.backend.Blog.Controller;

import br.edu.unipaulistana.backend.Blog.Service.UserService;
import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//http://localhost:8080/users
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "Usuarios", description="Operações relativas à usuários")
public class UserController {


    private final UserService userService;


    @GetMapping
    @Operation(method = "GET", summary = "Listar todos os fucking usuários")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());

    }
    //@GetMapping
    //public ResponseEntity<List<User>> ListUser(@RequestParam ("minROles") int minRoles ,@RequestParam("name")String name){
      //  List<User> users= userService.findMinPostsAndNameLike(minRoles,name);
        //return ResponseEntity.ok(users);

    //}



    //@GetMapping("/{id}")
    //public ResponseEntity<User> DetailUser(@PathVariable UUID id){
      //  return userService.findByIdWithProfileAndPosts(id)
        //        .map(ResponseEntity::ok)
          //      .orElse(ResponseEntity.notFound().build());
    //}

    //http://localhost:8080/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable UUID id) {
        return ResponseEntity.ok((User) userService.findUserById(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserByYd(@PathVariable UUID id) {
        this.userService.deleteById(id);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
         return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }
        @PutMapping
    public ResponseEntity<User> modifyUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.update(user), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<User> patchUser(@RequestBody User user) {
      return new ResponseEntity<>(userService.partialUpdate(user), HttpStatus.CREATED);

    }

}
