package ru.wasabi.repository;

import ru.wasabi.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> getEmployees();

    void addEmployee(Employee employee);
}
