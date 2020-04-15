package own.hades.timedealer.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import own.hades.timedealer.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
