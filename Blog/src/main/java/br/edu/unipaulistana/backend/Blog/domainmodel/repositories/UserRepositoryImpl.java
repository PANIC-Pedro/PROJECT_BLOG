package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom<User, UUID> {

    @PersistenceContext
    private final EntityManager entitymanger;

    @Override
    public Optional<User> findByIdWithProfileAndPostsCriteria(UUID id){
        CriteriaBuilder criteriaBuilder = entitymanger.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        Fetch<User , ?> profileFetch = root.fetch("profile", JoinType.LEFT);
        Fetch<User , ?> rolesFetch = root.fetch("roles", JoinType.LEFT);

        criteriaQuery.select(root).distinct(true)
                .where(criteriaBuilder.equal(root.get("id"), id));


        TypedQuery<User> query = entitymanger.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        return users.stream().findFirst();
    }



    @Override
    public List<User> findByMinRolesAndNameLikeCriteria(int minRoles , String name){
        CriteriaBuilder criteriaBuilder = entitymanger.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> root= criteriaQuery.from(User.class);

        criteriaQuery.select(root)
                .where(
                        criteriaBuilder.and(
                                criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.size(root.get("roles")),minRoles),
                                criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%"+name+"%")
                        )
                )
                .orderBy(criteriaBuilder.asc(root.get("name")));
        return this.entitymanger.createQuery(criteriaQuery).getResultList();
    }
    @Override
    public Optional<User> findByEmailCriteria(String email){
        CriteriaBuilder criteriaBuilder = entitymanger.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);

        criteriaQuery.select(root).distinct(true)
                .where(criteriaBuilder.equal(root.get("email"),email));

        TypedQuery<User> query= entitymanger.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        return users.stream().findFirst();
    }
    @Override
    public Optional<User> findByNameCriteria(String name){
        CriteriaBuilder criteriaBuilder = entitymanger.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root =  criteriaQuery.from(User.class);

        criteriaQuery.select(root).distinct(true)
                .where(criteriaBuilder.equal(root.get("name"),name));
        TypedQuery<User> query = entitymanger.createQuery(criteriaQuery);
        List<User> users= query.getResultList();
        return users.stream().findFirst();
    }
    @Override
    public Optional<User> findByEmailAndPasswordCriteria(String email, String password) {
        CriteriaBuilder criteriaBuilder = entitymanger.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);

        criteriaQuery.select(root).distinct(true)
                .where(
                        criteriaBuilder.equal(root.get("password"),password),
                        criteriaBuilder.equal(root.get("email"),email)
                );
        TypedQuery<User> query = entitymanger.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        return users.stream().findFirst();
    }


    @Override
    public List<User> findByNameStartingWithAndEndingWithCriteria(String name1, String name2){
        CriteriaBuilder criteriaBuilder = entitymanger.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);

        criteriaQuery.select(root).where(
                criteriaBuilder.like(root.get("name1"),name1+"%"),
                criteriaBuilder.like(root.get("name2"), "%"+name2)
        ).orderBy(criteriaBuilder.asc(root.get("name")));
        return this.entitymanger.createQuery(criteriaQuery).getResultList();

    }

}
