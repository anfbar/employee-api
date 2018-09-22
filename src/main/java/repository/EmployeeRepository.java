package repository;

import dto.Employee;
import entity.EmployeeEntity;
import exception.ResourceNotFoundException;
import factory.EmployeeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class EmployeeRepository {

    private ApplicationContext context;
    private final String url;

    @Autowired
    public EmployeeRepository(ApplicationContext context, @Value("${employees.url}") String url) {
        this.context = context;
        this.url = url;
    }

    public List<Employee> getEmployees() {
        ResponseEntity<EmployeeEntity[]> response = getResponseEntity();
        return Arrays
                .stream(response.getBody())
                .map(this::getEmployee)
                .collect(toList());
    }

    public Employee getEmployee(Integer id) {
        ResponseEntity<EmployeeEntity[]> response = getResponseEntity();
        return Arrays
                .stream(response.getBody())
                .filter(employee -> employee.getId().equals(id))
                .map(this::getEmployee)
                .findAny()
                .orElseThrow(ResourceNotFoundException::new);
    }

    private ResponseEntity<EmployeeEntity[]> getResponseEntity() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url, EmployeeEntity[].class);
    }

    private Employee getEmployee(EmployeeEntity employeeEntity) {
        EmployeeFactory employeeFactory = (EmployeeFactory) context.getBean(employeeEntity.getContractTypeName());
        return employeeFactory.getEmployee(employeeEntity);
    }
}
