package own.helperapp.timediller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import own.helperapp.timediller.domain.Task;
import own.helperapp.timediller.service.TaskService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/tasks/board")
@CrossOrigin
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService injectedTaskService)
    {
        taskService = injectedTaskService;
    }

    @GetMapping("/all")
    public Iterable<Task> getAllTasks()
    {
        return taskService.findAll();
    }

    @GetMapping("/{task_id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long task_id)
    {
        Task task = taskService.findById(task_id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addTaskToBoard(@Valid @RequestBody Task task, BindingResult result)
    {
        if(result.hasErrors()){
            Map<String, String> errors = new HashMap<>();

            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        Task newTask = taskService.saveOrUpdateTask(task);

        return new ResponseEntity<Task>(newTask, HttpStatus.CREATED);
    }

}
