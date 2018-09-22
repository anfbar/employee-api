package factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Employee;
import dto.HourlySalaryEmployee;
import entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("HourlySalaryEmployee")
public class HourlySalaryEmployeeFactory implements EmployeeFactory {

    private ObjectMapper objectMapper;

    @Autowired
    public HourlySalaryEmployeeFactory(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Employee getEmployee(EmployeeEntity employeeEntity) {
        return objectMapper.convertValue(employeeEntity, HourlySalaryEmployee.class);
    }
}
