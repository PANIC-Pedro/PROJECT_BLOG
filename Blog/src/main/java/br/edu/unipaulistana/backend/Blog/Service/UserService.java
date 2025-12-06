package br.edu.unipaulistana.backend.Blog.Service;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.UUID;

public interface UserService extends UserDetailsService {

    List<User> findAll();

    List<User> findUserById(UUID id);

    void deleteById(UUID id);

    User create(User user);

    User update(User user);

    User partialUpdate(User user);

  //  FileChannel findByIdWithProfileAndPosts(UUID id);

    //List<User> findMinPostsAndNameLike(int minRoles, String name);

}
