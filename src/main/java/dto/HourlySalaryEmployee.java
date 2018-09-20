package dto;

import java.util.Optional;

public class HourlySalaryEmployee extends Employee {

    public HourlySalaryEmployee(Integer id, String name, Integer roleId, String roleName, String roleDescription, Double hourlySalary, Double monthlySalary) {
        super(id, name, roleId, roleName, roleDescription, hourlySalary, monthlySalary);
    }

    @Override
    public Double getAnnualSalary() {
        return Optional.ofNullable(getHourlySalary())
                .map(hourlySalary -> 120 * hourlySalary * 12)
                .orElse(0d);
    }
}
