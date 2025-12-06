package br.edu.unipaulistana.backend.Blog.Service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAll();

    List<Tag> findTagById(long id);

    void deleteById(long id);

    Tag create(Tag tag);

    Tag update(Tag tag);

    Tag partialUpdate(Tag tag);
}
