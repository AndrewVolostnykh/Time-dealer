package own.hades.timedealer.service;

import own.hades.timedealer.model.Task;
import own.hades.timedealer.model.User;

import java.util.List;

public interface TaskService {
    List<Task> getAllForUser(Long userId);
    Task addTask(Task task);
    void deleteTask(Long taskId);
    Task getById(Long id);
}
