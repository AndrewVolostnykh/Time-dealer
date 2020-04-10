package own.helperapp.timediller.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import own.helperapp.timediller.domain.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    Task getById(Long id);
}
