package dto;

import java.util.Optional;

public class MonthlySalaryEmployee extends Employee {

    public MonthlySalaryEmployee() {

    }

    public MonthlySalaryEmployee(Integer id) {
        super(id);
    }

    @Override
    public Double getAnnualSalary() {
        return Optional.ofNullable(getMonthlySalary())
                .map(monthlySalary -> monthlySalary * 12)
                .orElse(0d);
    }
}
