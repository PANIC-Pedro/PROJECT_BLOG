package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.yaml.snakeyaml.events.Event;

import java.util.Optional;
import java.util.Spliterator;

public interface ProfileRepository extends JpaRepository<Profile,Long>,
        QuerydslPredicateExecutor<Profile>,
        ProfileRepositoryCustom<Profile,Long>{

    Optional<Profile> findByBio(String bio);

    Optional<Profile> findByPictureURL (String picturaURL);

    //Minha ideia é quando o usuário buscar um perfil traga junto o user
    @Query("""
            select distinct p from Profile p 
            left join fetch p.user 
            where p.id = :id
            """)
    Optional<Profile> findByIdWithUser(@Param("id")Long id);




}
