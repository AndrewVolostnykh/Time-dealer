package own.helperapp.timediller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import own.helperapp.timediller.domain.Task;
import own.helperapp.timediller.repository.TaskRepository;

import java.util.Iterator;

@Service
public class TaskService {

    private TaskRepository taskRepos;

    @Autowired
    public TaskService(TaskRepository taskRepos)
    {
        this.taskRepos = taskRepos;
    }

    public Task saveOrUpdateTask(Task task)
    {
        if(task.getStatus() == null || task.getStatus().equals("")){
            task.setStatus("TO_DO");
        }

        return taskRepos.save(task);
    }

    public Iterable<Task> findAll()
    {
        return taskRepos.findAll();
    }

    public Task findById(Long id){
        return taskRepos.getById(id);
    }
}
