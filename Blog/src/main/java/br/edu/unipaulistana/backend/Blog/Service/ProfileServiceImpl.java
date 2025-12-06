package br.edu.unipaulistana.backend.Blog.Service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Profile;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService{

    private ProfileRepository repository;
    private ProfileServiceImpl profileService;

    @Override
    public List<Profile> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Profile>findByProfileId(long id) {
        return this.profileService.findByProfileId(id);
    }

    @Override
    public void deleteById(long id) {
    this.repository.deleteById(id);
    }

    @Override
    public Profile create(Profile profile) {
        return this.repository.save(profile);
    }

    @Override
    public Profile update(Profile profile) {
        return this.repository.save(profile);
    }

    @Override
    public Profile partialUpdate(Profile profile) {
        return this.repository.save(profile);
    }
}
