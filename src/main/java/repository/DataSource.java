package repository;

import model.Employee;
import model.Manager;

import java.util.List;

public interface DataSource {

    List<Employee> getEmployees();
    List<Manager> getManagers();
    void addEmployee(Employee employee);
    void addManager(Manager manager);

}
