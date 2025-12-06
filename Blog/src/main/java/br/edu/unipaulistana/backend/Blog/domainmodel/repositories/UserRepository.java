package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import jakarta.persistence.criteria.From;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>,
   // QuerydslPredicateExecutor<User>,
    UserRepositoryCustom<User , UUID> {

    @Query("SELECT u FROM User u WHERE u.email= :email")
    public Optional<User> findByEmail(String email);

    //@Query("SELECT u FROM User u WHERE u.name= :name")
    //public Optional<User> findByName(String name);

    public Optional<User> findByName(String name);
    public Optional<User> findByEmailAndPassword(String email, String password);

    @Query("""
            SELECT u FROM User u  WHERE u.name LIKE CONCAT(:name1, '%') AND  u.name LIKE CONCAT('%',:name2)
            """)
    public List<User> findByNameStartingWithAndNameEndingWith(@Param("name")String name1 ,@Param("name2") String name2);

    //Q1 JPQL BUSCA O USER POR ID E FAZ FETCH COM PROFILE E POST
   @Query(
           """
                   select distinct u
                   from User u 
                   left join fetch u.profile 
                   left join fetch u.roles
                   where u.id = :id
                   """
   )
    Optional<User> findByIdWithProfileAndPosts(@Param("id")UUID id);

   //Q2 LPQL USUARIOS CUJO O NOME CONTEM UM PARAMETRO QUE TENHA PELO MENOS N ROLES.
   @Query(
           """
       select u
       from User u
       where size(u.roles) >= :minRoles
       and lower(u.name) like lower(concat('%', :namePart, '%'))
       order by u.name asc
"""
   )
   List<User> findMinPostsAndNameLike(@Param("minPosts") int minPosts, @Param("namePart") String namePart);


}

