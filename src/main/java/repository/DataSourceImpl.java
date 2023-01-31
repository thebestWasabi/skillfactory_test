package repository;

import model.Employee;
import model.Manager;

import java.util.ArrayList;
import java.util.List;

public class DataSourceImpl implements DataSource {

    private final List<Employee> employees = new ArrayList<>();
    private final List<Manager> managers = new ArrayList<>();

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public List<Manager> getManagers() {
        return managers;
    }

    @Override
    public void addManager(Manager manager) {
        managers.add(manager);
    }
}
