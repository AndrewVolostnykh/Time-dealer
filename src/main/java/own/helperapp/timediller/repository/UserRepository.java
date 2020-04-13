package own.helperapp.timediller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import own.helperapp.timediller.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User getById(Long id);
    User findByUserName(String name);
}
