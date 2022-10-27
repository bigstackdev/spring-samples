package dev.bigstack.springboot;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
@ComponentScan("dev.bigstack.springboot")
public class StudentServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentServicesApplication.class, args);
    }
    
    // spring calls after the initialization of bean properties
    @PostConstruct
    private void initDb() {
//      User user = new User();
//      user.setUserType(UserType.STUDENT);
//      user.setUserName("PeterM");
//      user.setPassword("ABC123abc*");
//      user.setDateofBirth(new Date());
//      user.setCreationTime(new Date());
//      userRepository.save(user);
    }

}
