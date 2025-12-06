package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepositoryCustom<Role,Long>{
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<Role> findByNameCriteria(String name){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> criteriaQuery = criteriaBuilder.createQuery(Role.class);
        Root<Role> root = criteriaQuery.from(Role.class);

        criteriaQuery.select(root).distinct(true)
                .where(criteriaBuilder.equal(root.get("name"),name));
        TypedQuery<Role> query = entityManager.createQuery(criteriaQuery);
        List<Role>roles = query.getResultList();
        return roles.stream().findFirst();
    }
    @Override
    public Optional<Role> findByIdWithUserCriteria(Long id){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Role.class);
        Root<Role> root = criteriaQuery.from(Role.class);
        Fetch<Role , ?> userFetch = root.fetch("user", JoinType.LEFT);

        criteriaQuery.select(root).distinct(true)
                .where(criteriaBuilder.equal(root.get("id"),id));

        TypedQuery<Role> query = entityManager.createQuery(criteriaQuery);
        List<Role> roles    = query.getResultList();
        return roles.stream().findFirst();
    }


}
