package controller;

import dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
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
    private String message;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, @Value("${employees.message}") String message) {
        this.employeeRepository = employeeRepository;
        this.message = message;
    }

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return message;
    }

    @RequestMapping("/employees")
    @ResponseBody
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    @RequestMapping("/employees/{id}")
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") Integer id) {
        return employeeRepository.getEmployee(id);
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeController.class, args);
    }
}
