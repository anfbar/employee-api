package dto;

import java.util.Optional;

public class MonthlySalaryEmployee extends Employee {

    public MonthlySalaryEmployee(Integer id, String name, Integer roleId, String roleName, String roleDescription, Double hourlySalary, Double monthlySalary) {
        super(id, name, roleId, roleName, roleDescription, hourlySalary, monthlySalary);
    }

    @Override
    public Double getAnnualSalary() {
        return Optional.ofNullable(getMonthlySalary())
                .map(monthlySalary -> monthlySalary * 12)
                .orElse(0d);
    }
}
