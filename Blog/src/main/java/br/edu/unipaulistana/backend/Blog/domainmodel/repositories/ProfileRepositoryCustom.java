package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Profile;

import java.util.Optional;

public interface ProfileRepositoryCustom<Profile , Long> {
    Optional<br.edu.unipaulistana.backend.Blog.domainmodel.Profile> findByBioCriteria(String bio);

    Optional<br.edu.unipaulistana.backend.Blog.domainmodel.Profile> findByPictureURLCriteria(String pictureURL);

    Optional<br.edu.unipaulistana.backend.Blog.domainmodel.Profile>  findByIdWithUserCriteria(long id);
}
