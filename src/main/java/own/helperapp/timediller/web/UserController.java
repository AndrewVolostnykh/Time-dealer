package own.helperapp.timediller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import own.helperapp.timediller.domain.User;
import own.helperapp.timediller.service.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@RestController
@RequestMapping("/profile")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService injectedUserService)
    {
        userService = injectedUserService;
    }

    @PostMapping
    public ResponseEntity<?> sign_up(@Valid @RequestBody User user, BindingResult results)
    {
        if(results.hasErrors()){
            new LinkedList<>();// dont mind ))
            Map<String, String> errors = new HashMap<>();

            for (FieldError error : results.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        User newUser = userService.saveOrUpdate(user);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    @GetMapping("/{user_id}")
    public ResponseEntity<?> profile(@PathVariable Long user_id)
    {
        User user = userService.getUserById(user_id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
