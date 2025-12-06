package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Profile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProfileRepositoryImpl implements ProfileRepositoryCustom {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<Profile> findByBioCriteria(String bio){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Profile> criteriaQuery = criteriaBuilder.createQuery(Profile.class);
        Root<Profile> root = criteriaQuery.from(Profile.class);

        criteriaQuery.select(root).distinct(true)
                .where(criteriaBuilder.equal(root.get("bio"),bio));
        TypedQuery<Profile> query = entityManager.createQuery(criteriaQuery);
        List<Profile> profiles = query.getResultList();
        return profiles.stream().findFirst();
    }

    @Override
    public Optional<Profile> findByPictureURLCriteria(String pictureURL){
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Profile> criteriaQuery = criteriaBuilder.createQuery(Profile.class);
        Root<Profile> root = criteriaQuery.from(Profile.class);

        criteriaQuery.select(root).distinct(true)
                .where(
                        criteriaBuilder.equal(root.get("pictureURL"),pictureURL)
                );
        TypedQuery<Profile> query = entityManager.createQuery(criteriaQuery);
        List<Profile> profiles = query.getResultList();
        return profiles.stream().findFirst();
    }
    @Override
    public Optional<Profile>  findByIdWithUserCriteria(long id){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Profile> criteriaQuery = criteriaBuilder.createQuery(Profile.class);
        Root<Profile> root= criteriaQuery.from(Profile.class);
        Fetch<Profile , ?> profileFetch= root.fetch("user", JoinType.LEFT);

        criteriaQuery.select(root).distinct(true)
                .where(criteriaBuilder.equal(root.get("id"),id));
        TypedQuery<Profile> query = entityManager.createQuery(criteriaQuery);
        List<Profile> profiles = query.getResultList();
        return  profiles.stream().findFirst();

    }
}
