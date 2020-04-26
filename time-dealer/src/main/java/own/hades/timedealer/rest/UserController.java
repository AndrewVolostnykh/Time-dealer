package own.hades.timedealer.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import own.hades.timedealer.model.User;
import own.hades.timedealer.service.UserServiceImpl;
import own.hades.timedealer.utils.other.ControllerUtils;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    // There is simple implementation of Logger. Don`t mind pls
    private static final Logger log = Logger.getLogger(UserController.class);

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl injectService)
    {
        userService = injectService;
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<User> getUserProfile(@PathVariable Long id)
    {

        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = this.userService.getById(id);

        if(user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewUser(/*@Valid*/ @RequestBody User user, BindingResult result)
    {
        if(result.hasErrors()){ // handing blank fields and other
            Map<String, String> errors = ControllerUtils.bindingResultGetErrors(result);

            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        if(user == null) {
            System.err.println("(UserController::createNewUser):USER == NULL!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User newUser = this.userService.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update") // this method does not work!!!
    public ResponseEntity<?> updateUser(@Valid @RequestBody User user, BindingResult result)
    {
        if(user == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if(result.hasErrors())
            return new ResponseEntity<>(ControllerUtils.bindingResultGetErrors(result), HttpStatus.BAD_REQUEST);

        this.userService.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){

        if(userId == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(this.userService.getById(userId) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        this.userService.delete(userId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // test method ->

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers(){
        Iterable<User> users = userService.getAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
