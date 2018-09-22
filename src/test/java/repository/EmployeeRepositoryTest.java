package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Employee;
import dto.HourlySalaryEmployee;
import dto.MonthlySalaryEmployee;
import entity.EmployeeEntity;
import factory.HourlySalaryEmployeeFactory;
import factory.MonthlySalaryEmployeeFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

public class EmployeeRepositoryTest {

    private static final String URL = "http://masglobaltestapi.azurewebsites.net/api/employees";
    private static final int HOURLY_EMPLOYEE_ID = 1;
    private static final int MONTHLY_EMPLOYEE_ID = 2;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private ApplicationContext context;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldGetEmployees() {
        //Given
        when(context.getBean("MonthlySalaryEmployee"))
                .thenReturn(new MonthlySalaryEmployeeFactory(objectMapper));
        when(context.getBean("HourlySalaryEmployee"))
                .thenReturn(new HourlySalaryEmployeeFactory(objectMapper));
        when(objectMapper.convertValue(new EmployeeEntity(HOURLY_EMPLOYEE_ID), HourlySalaryEmployee.class))
                .thenReturn(new HourlySalaryEmployee(HOURLY_EMPLOYEE_ID));
        when(objectMapper.convertValue(new EmployeeEntity(MONTHLY_EMPLOYEE_ID), MonthlySalaryEmployee.class))
                .thenReturn(new MonthlySalaryEmployee(MONTHLY_EMPLOYEE_ID));

        //When
        EmployeeRepository employeeRepository = new EmployeeRepository(context, URL);
        List<Employee> employees = employeeRepository.getEmployees();

        //Then
        assertFalse(employees.isEmpty());
    }
}
