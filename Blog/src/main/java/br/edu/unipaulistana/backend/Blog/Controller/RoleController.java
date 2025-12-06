package br.edu.unipaulistana.backend.Blog.Controller;

import br.edu.unipaulistana.backend.Blog.Service.RoleService;
import br.edu.unipaulistana.backend.Blog.domainmodel.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> findAll(){
        return ResponseEntity.ok(roleService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable long id){
        return  ResponseEntity.ok((Role) roleService.findRoleById(id));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteRoleById(@PathVariable long id){
        this.roleService.deleteById(id);
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return new ResponseEntity<>(roleService.create(role), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Role> UpdateRole(@RequestBody Role role){
        return new ResponseEntity<>(roleService.update(role),HttpStatus.CREATED);
    }
    @PatchMapping
    public ResponseEntity<Role> PartialUpdate(@RequestBody Role role){
        return new ResponseEntity<>(roleService.partialUpdate(role), HttpStatus.CREATED);
    }


}
