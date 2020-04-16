package own.hades.timedealer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import own.hades.timedealer.model.User;
import own.hades.timedealer.repos.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository injectRepos)
    {
        repository = injectRepos;
    }

    @Override
    public User getById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
