package controller;

import dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import repository.EmployeeRepository;

import java.util.List;

@RestController
@EnableAutoConfiguration
@ComponentScan("repository,factory")
@SpringBootApplication
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to Employees API!";
    }

    @RequestMapping("/employees")
    @ResponseBody
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeController.class, args);
    }
}
