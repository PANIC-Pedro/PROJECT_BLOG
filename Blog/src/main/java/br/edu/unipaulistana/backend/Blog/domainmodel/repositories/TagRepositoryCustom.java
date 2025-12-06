package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Tag;

import java.util.Optional;


public interface TagRepositoryCustom <Tag , Long>{
    Optional<br.edu.unipaulistana.backend.Blog.domainmodel.Tag> findByNameCriteria(String name);

    Optional<br.edu.unipaulistana.backend.Blog.domainmodel.Tag> findByIdWithPost (java.lang.Long id);
}
