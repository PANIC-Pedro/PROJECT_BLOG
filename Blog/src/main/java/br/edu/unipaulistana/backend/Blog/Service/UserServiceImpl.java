package br.edu.unipaulistana.backend.Blog.Service;

import br.edu.unipaulistana.backend.Blog.Infrastructure.dtos.UserDTO;
import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private UserServiceImpl userService;

    @Override
    public List<User> findAll(){

        return this.repository.findAll();
    }

    @Override
    public List<User> findUserById(UUID id) {
        return this.userService.findUserById(id);
    }

    @Override
    public void deleteById(UUID id) {

        this.repository.deleteById(id);
    }

    @Override
    public User create(User user) {
        if(user.getId() == null)
            user.setId(UUID.randomUUID());
            return this.repository.save(user);

    }

    @Override
    public User update(User user) {

        return this.repository.save(user);
    }

    @Override
    public User partialUpdate(User user) {
        return this.repository.save(user);
    }

    //@Override
    //public FileChannel findByIdWithProfileAndPosts(UUID id) {
      //  return null;
    //}

    //@Override
   // public List<User> findMinPostsAndNameLike(int minRoles, String name) {
        //return List.of();
    //}


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByName(username).get();
    }
}
