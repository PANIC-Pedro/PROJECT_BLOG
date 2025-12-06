package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long>,
        QuerydslPredicateExecutor<Post>,
        PostRepositoryCustom<Post,Long> {

        public Optional<Post> findByTitle(String title);
    public Optional<Post> findByContent(String content);

    @Query("""
            select distinct p
            from Post p  
            left join fetch p.user
            left join fetch p.tag
            where p.id = :id
            
            """)
    Optional<Post> findByIdWithUserAndTag(@Param("id")Long id);





}
