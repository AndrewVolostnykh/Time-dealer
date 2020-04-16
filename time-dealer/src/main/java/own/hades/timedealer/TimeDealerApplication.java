package own.hades.timedealer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("*") // This annotation using for kill conflicts when frontend working on another port
public class TimeDealerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeDealerApplication.class, args);
    }

}
