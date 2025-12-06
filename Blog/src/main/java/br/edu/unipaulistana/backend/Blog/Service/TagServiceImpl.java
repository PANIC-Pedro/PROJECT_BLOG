package br.edu.unipaulistana.backend.Blog.Service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Tag;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService{

    private TagRepository repository;
    private TagServiceImpl tagService;

    @Override
    public List<Tag> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Tag> findTagById(long id) {
        return this.tagService.findTagById(id);
    }

    @Override
    public void deleteById(long id) {
       this.repository.deleteById(id);
    }

    @Override
    public Tag create(Tag tag) {
        return this.repository.save(tag);
    }

    @Override
    public Tag update(Tag tag) {
        return this.repository.save(tag);
    }

    @Override
    public Tag partialUpdate(Tag tag) {
        return this.repository.save(tag);
    }
}
