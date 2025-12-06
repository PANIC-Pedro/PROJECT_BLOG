package br.edu.unipaulistana.backend.Blog.Service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    List<Post> findPostById(long id);

    void deleteById(long id);

    Post create(Post post);

    Post update(Post post);

    Post partialUpdate(Post post);
}
