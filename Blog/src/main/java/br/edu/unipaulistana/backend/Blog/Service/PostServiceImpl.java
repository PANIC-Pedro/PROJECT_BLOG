package br.edu.unipaulistana.backend.Blog.Service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Post;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private PostRepository repository;
    private PostServiceImpl postService;

    @Override
    public List<Post> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Post> findPostById(long id) {
        return this.postService.findPostById(id);
    }

    @Override
    public void deleteById(long id) {
this.repository.deleteById(id);
    }

    @Override
    public Post create(Post post) {
        return this.repository.save(post);
    }

    @Override
    public Post update(Post post) {
        return this.repository.save(post);
    }

    @Override
    public Post partialUpdate(Post post) {
        return this.repository.save(post) ;
    }
}
