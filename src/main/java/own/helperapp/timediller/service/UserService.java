package own.helperapp.timediller.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import own.helperapp.timediller.domain.User;
import own.helperapp.timediller.repository.UserRepository;

@Service
@Slf4j
public class UserService {
    private UserRepository repos;

    @Autowired
    public UserService(UserRepository injectedRepos){
        repos = injectedRepos;
    }

    public User getUserById(Long id)
    {
        return repos.getById(id);
    }

    public User saveOrUpdate(User user)
    {
        return repos.save(user);
    }

    public User findByUserName(String name)
    {
        return repos.findByUserName(name);
    }

    void deleteUser(Long id)
    {
        User user = repos.getById(id);
        repos.delete(user);
    }
}
