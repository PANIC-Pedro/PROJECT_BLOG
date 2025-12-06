package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Post;

import java.util.Optional;

public interface PostRepositoryCustom <Post , Long>{
    Optional<br.edu.unipaulistana.backend.Blog.domainmodel.Post> findByTitleCriteria(String title);

    Optional<br.edu.unipaulistana.backend.Blog.domainmodel.Post> findByContentCriteria(String content);

    Optional<br.edu.unipaulistana.backend.Blog.domainmodel.Post> findByIdWithUserAndTagCriteria (java.lang.Long id);
}
