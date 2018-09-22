package dto;

import java.util.Optional;

public class HourlySalaryEmployee extends Employee {

    public HourlySalaryEmployee() {

    }

    public HourlySalaryEmployee(Integer id) {
        super(id);
    }

    @Override
    public Double getAnnualSalary() {
        return Optional.ofNullable(getHourlySalary())
                .map(hourlySalary -> 120 * hourlySalary * 12)
                .orElse(0d);
    }
}
