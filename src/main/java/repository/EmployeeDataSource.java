package repository;

import model.Employee;
import model.Manager;

import java.util.List;

public interface EmployeeDataSource {

    List<Employee> getEmployees();
    void addEmployee(Employee employee);
}
