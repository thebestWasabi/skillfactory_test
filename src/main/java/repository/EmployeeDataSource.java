package repository;

import model.Employee;

import java.util.List;

public interface EmployeeDataSource {

    List<Employee> getEmployees();

    void addEmployee(Employee employee);
}
