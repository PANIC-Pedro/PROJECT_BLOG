package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Role;
import jakarta.persistence.criteria.Root;

import java.util.Optional;

public interface RoleRepositoryCustom<Role, Long> {
    Optional<br.edu.unipaulistana.backend.Blog.domainmodel.Role> findByNameCriteria(String name);


    Optional<br.edu.unipaulistana.backend.Blog.domainmodel.Role> findByIdWithUserCriteria(java.lang.Long id);
}
