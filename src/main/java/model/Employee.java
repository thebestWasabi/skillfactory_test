package model;

import comparator.EmployeeComparator;
import comparator.LastNameEmpComparator;
import file.Parser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import repository.EmployeeDataSource;
import repository.EmployeeDataSourceImpl;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Employee {

    private EmployeeDataSource employeeDataSource;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfEmployment;

    public Employee() {
        this.employeeDataSource = new EmployeeDataSourceImpl();
    }

    public Employee(String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateOfEmployment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfEmployment = dateOfEmployment;
    }

    public void findEmployeeByLastName(String lastName) {
        Employee currentEmployee = null;
        for (Employee employee : employeeDataSource.getEmployees()) {
            if (employee.lastName.equals(lastName)) {
                currentEmployee = employee;
                System.out.println(currentEmployee);
                break;
            }
        }
    }

    public void prettyPrintEmployee() {
        for (Employee employee : employeeDataSource.getEmployees()) {
            System.out.println(employee);
        }
    }

    public void addEmployeesInList() {
        try {
            List<Employee> result = Parser.parseFileToObjectList();
            for (Employee employee : result) {
                employeeDataSource.addEmployee(employee);
            }
            System.out.println("Работники добавлены в список");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }

    public void removeEmployee(String lastName) {
        employeeDataSource.getEmployees().removeIf(employee -> employee.lastName.equals(lastName));
    }

    public void sortedEmployeeByLastName() {
        EmployeeComparator comparator = new LastNameEmpComparator();
        employeeDataSource.getEmployees().stream().sorted(comparator).forEach(System.out::println);
    }



    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
    }
}
