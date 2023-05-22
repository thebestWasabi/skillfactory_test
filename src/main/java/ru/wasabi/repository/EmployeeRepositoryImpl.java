package ru.wasabi.repository;

import org.springframework.stereotype.Component;
import ru.wasabi.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    List<Employee> employees = new ArrayList<>();


    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

}
