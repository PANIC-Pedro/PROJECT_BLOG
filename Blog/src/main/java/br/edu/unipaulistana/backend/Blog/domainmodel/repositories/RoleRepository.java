package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long>,
        QuerydslPredicateExecutor<Role>,
        RoleRepositoryCustom<Role , Long>
{
    public Optional<Role> findByName(String name);

    @Query("""
            select distinct r
            from Role r 
            left join fetch r.user
            where r.id = :id
            """)
    Optional<Role> findByIdWithUser (@Param("id") Long id);

}
