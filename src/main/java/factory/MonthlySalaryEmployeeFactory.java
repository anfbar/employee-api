package factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Employee;
import dto.MonthlySalaryEmployee;
import entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("MonthlySalaryEmployee")
public class MonthlySalaryEmployeeFactory implements EmployeeFactory {

    private ObjectMapper objectMapper;

    @Autowired
    public MonthlySalaryEmployeeFactory(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Employee getEmployee(EmployeeEntity employeeEntity) {
        return objectMapper.convertValue(employeeEntity, MonthlySalaryEmployee.class);
    }
}
