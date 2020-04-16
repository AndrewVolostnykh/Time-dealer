package own.hades.timedealer.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import own.hades.timedealer.model.Task;
import own.hades.timedealer.service.TaskServiceImpl;
import own.hades.timedealer.service.UserServiceImpl;
import own.hades.timedealer.utils.other.ControllerUtils;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskServiceImpl taskService;
    private UserServiceImpl userService;

    public TaskController(TaskServiceImpl injectedTaskService, UserServiceImpl injectedUserServiceImpl)
    {
        taskService = injectedTaskService;
        userService = injectedUserServiceImpl;
    }

    @GetMapping("/all/{userId}") // test attempt show all user tasks
    public ResponseEntity<?> getAllByUserId(@PathVariable Long userId){
        if(userId == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Iterable<Task> resultTasks = taskService.getAllForUser(userId);

        if(resultTasks == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(resultTasks, HttpStatus.OK);
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<?> addNewTask(@Valid @RequestBody Task task, @PathVariable Long userId, BindingResult result)
    {

        Map<String, String> errors;
        if(result.hasErrors())
        {
            errors = ControllerUtils.bindingResultGetErrors(result);
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        if(task == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(userId == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        task.setTaskOwner(userService.getById(userId));
        Task resultTask = taskService.addTask(task);

        if(resultTask == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(resultTask, HttpStatus.CREATED);
    }

    /**Task can be replaced with path variable taskID*/
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTask(@Valid @RequestBody Long taskId){

        if(taskId == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(taskService.getById(taskId) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        taskService.deleteTask(taskId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update") // very important to send ID here
    public ResponseEntity<?> updateTask(@Valid @RequestBody Task task, BindingResult result)
    {
        if(task == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(result.hasErrors())
        {
            return new ResponseEntity<>(ControllerUtils.bindingResultGetErrors(result), HttpStatus.BAD_REQUEST);
        }

        Task newTask = taskService.addTask(task);

        return new ResponseEntity<>(newTask, HttpStatus.OK);
    }

}
