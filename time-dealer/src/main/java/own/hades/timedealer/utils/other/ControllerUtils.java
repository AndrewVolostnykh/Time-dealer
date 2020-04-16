package own.hades.timedealer.utils.other;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

public class ControllerUtils {

    public static Map<String, String> bindingResultGetErrors(BindingResult results)
    {
        Map<String, String> errors = new HashMap<>();
        if(results != null){
            for(FieldError error : results.getFieldErrors()){
                errors.put(error.getField(), error.getDefaultMessage());
            }
        }

        return errors;
    }

}
