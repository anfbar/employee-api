package factory;

import dto.Employee;
import entity.EmployeeEntity;

public interface EmployeeFactory {

    Employee getEmployee(EmployeeEntity employeeEntity);
}
