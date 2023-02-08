package repository;

import model.Employee;
import model.Manager;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDataSourceImpl implements EmployeeDataSource {

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
