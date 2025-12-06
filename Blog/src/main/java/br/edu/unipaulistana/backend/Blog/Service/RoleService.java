package br.edu.unipaulistana.backend.Blog.Service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    List<Role>findRoleById(long id);

    void deleteById(long id);

    Role create(Role role);


    Role update(Role role);

    Role partialUpdate(Role role);
}
