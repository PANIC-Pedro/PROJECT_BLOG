package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.reflect.Typed;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom<Post, Long> {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<Post> findByTitleCriteria(String title){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> root = criteriaQuery.from(Post.class);

        criteriaQuery.select(root).distinct(true)
                .where(criteriaBuilder.equal(root.get("title"),title));
        TypedQuery<Post> query = entityManager.createQuery(criteriaQuery);
        List<Post> posts = query.getResultList();
        return posts.stream().findFirst();
    }
    @Override
    public Optional<Post> findByContentCriteria(String content){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> root = criteriaQuery.from(Post.class);

        criteriaQuery.select(root).distinct(true)
                .where(criteriaBuilder.equal(root.get("content"),content));
        TypedQuery<Post> query = entityManager.createQuery(criteriaQuery);
        List<Post> posts = query.getResultList();
        return posts.stream().findFirst();
    }
    @Override
    public Optional<Post> findByIdWithUserAndTagCriteria(Long id){
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
            Root<Post> root = criteriaQuery.from(Post.class);
        Fetch<Post , ?> userFetch=root.fetch("user", JoinType.LEFT);
        Fetch<Post, ?> tagFetch=root.fetch("tag",JoinType.LEFT);

            criteriaQuery.select(root).distinct(true)
                    .where(criteriaBuilder.equal(root.get("id"),id));
        TypedQuery<Post> query = entityManager.createQuery(criteriaQuery);
        List<Post> posts = query.getResultList();
        return posts.stream().findFirst();
    }


}
