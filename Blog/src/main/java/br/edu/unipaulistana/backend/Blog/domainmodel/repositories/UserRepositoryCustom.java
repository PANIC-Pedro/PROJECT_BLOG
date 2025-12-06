package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryCustom<User, UUID> {
    public Optional<br.edu.unipaulistana.backend.Blog.domainmodel.User> findByIdWithProfileAndPostsCriteria(java.util.UUID id);

    public List<br.edu.unipaulistana.backend.Blog.domainmodel.User> findByMinRolesAndNameLikeCriteria(int minRoles , String name);

   Optional<br.edu.unipaulistana.backend.Blog.domainmodel.User> findByEmailCriteria(String email);

    Optional<br.edu.unipaulistana.backend.Blog.domainmodel.User> findByNameCriteria(String name);

    Optional<br.edu.unipaulistana.backend.Blog.domainmodel.User> findByEmailAndPasswordCriteria(String email, String password);


   public List<br.edu.unipaulistana.backend.Blog.domainmodel.User> findByNameStartingWithAndEndingWithCriteria(String name1, String name2);
}
