package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag,Long>,
        QuerydslPredicateExecutor<Tag>,
        TagRepositoryCustom<Tag , Long> {


    public Optional<Tag> findByName(String name);

     @Query("""
             select distinct t 
             from Tag t 
             left join fetch t.posts
             where t.id = :id
             """)

    public Optional<Tag> findByIdPost(@Param("id")Long id);



}
