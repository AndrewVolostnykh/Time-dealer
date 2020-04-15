package own.hades.timedealer.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import own.hades.timedealer.model.Task;
import own.hades.timedealer.model.User;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTaskOwner(User user);
}
