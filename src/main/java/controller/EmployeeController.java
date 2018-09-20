package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class EmployeeController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Welcome to Employees API!";
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeController.class, args);
    }
}
