package dto;

import java.util.Objects;

public abstract class Employee {
    private Integer id;
    private String name;
    private Integer roleId;
    private String roleName;
    private String roleDescription;
    private Double hourlySalary;
    private Double monthlySalary;

    Employee(Integer id, String name, Integer roleId, String roleName, String roleDescription, Double hourlySalary, Double monthlySalary) {
        this.id = id;
        this.name = name;
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.hourlySalary = hourlySalary;
        this.monthlySalary = monthlySalary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public Double getHourlySalary() {
        return hourlySalary;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public abstract Double getAnnualSalary();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getId(), employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
