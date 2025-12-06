package br.edu.unipaulistana.backend.Blog.Service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Role;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    private RoleRepository repository;
    private RoleServiceImpl roleService;

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Role> findRoleById(long id) {
        return this.roleService.findRoleById(id);
    }

    @Override
    public void deleteById(long id) {
        this.repository.deleteById(id);

    }

    @Override
    public Role create(Role role) {
        return this.repository.save(role);
    }

    @Override
    public Role update(Role role) {
        return this.repository.save(role);
    }

    @Override
    public Role partialUpdate(Role role) {
        return this.repository.save(role);
    }
}
