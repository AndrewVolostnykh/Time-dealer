package own.hades.timedealer.service;

import own.hades.timedealer.model.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    User save(User user);

    void delete(Long id);

    List<User> getAll(); // test method
}
