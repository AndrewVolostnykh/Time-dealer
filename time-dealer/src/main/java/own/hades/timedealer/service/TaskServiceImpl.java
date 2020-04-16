package own.hades.timedealer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import own.hades.timedealer.model.Task;
import own.hades.timedealer.repos.TaskRepository;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    private UserServiceImpl userService;

    @Autowired
    public TaskServiceImpl(TaskRepository injectedRepos,
                           UserServiceImpl injectUserService)
    {
        taskRepository = injectedRepos;
        userService = injectUserService;
    }

    @Override
    public List<Task> getAllForUser(Long userId) {
        return taskRepository.findByTaskOwner(userService.getById(userId));
    }

    @Override
    public Task addTask(Task task) {
        if(task.getStatus() == null || task.getStatus().equals(""))
        {
            task.setStatus("TO_DO");
        }

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task getById(Long id) {
        return taskRepository.getOne(id);
    }

    public List<Task> getAll(){
        return taskRepository.findAll();
    }
}
