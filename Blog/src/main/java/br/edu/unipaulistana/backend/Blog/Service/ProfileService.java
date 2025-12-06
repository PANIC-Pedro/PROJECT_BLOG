package br.edu.unipaulistana.backend.Blog.Service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> findAll();


    List<Profile> findByProfileId(long id);

    void deleteById(long id);

    Profile create(Profile profile);

    Profile update(Profile profile);

    Profile partialUpdate(Profile profile);
}