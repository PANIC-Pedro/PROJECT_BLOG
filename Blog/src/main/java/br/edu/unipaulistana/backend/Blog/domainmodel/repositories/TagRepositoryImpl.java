package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Tag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TagRepositoryImpl implements TagRepositoryCustom<Tag , Long>{
    @PersistenceContext
    private  final EntityManager entityManager;

    @Override
    public Optional<Tag> findByNameCriteria(String name){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteriaQuery = criteriaBuilder.createQuery(Tag.class);
        Root<Tag> root = criteriaQuery.from(Tag.class);

        criteriaQuery.select(root).distinct(true)
                .where( criteriaBuilder.equal(root.get("name"),name));
        TypedQuery<Tag> query = entityManager.createQuery(criteriaQuery);
        List<Tag> tags = query.getResultList();
        return tags.stream().findFirst();
    }

    @Override
    public Optional<Tag> findByIdWithPost(Long id){
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Tag> criteriaQuery = criteriaBuilder.createQuery(Tag.class);
    Root<Tag> root = criteriaQuery.from(Tag.class);
        Fetch<Tag,?> postFetch=root.fetch("post", JoinType.LEFT);
        criteriaQuery.select(root).distinct(true)
                .where(criteriaBuilder.equal(root.get("id"),id));

        TypedQuery<Tag> query = entityManager.createQuery(criteriaQuery);
        List<Tag> tags = query.getResultList();
        return tags.stream().findFirst();

    }


}
