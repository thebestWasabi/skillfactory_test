package model;

import comparator.ComparatorUTIL;
import comparator.EmployeeComparator;
import comparator.EmployeeComparatorType;
import comparator.LastNameEmpComparator;
import file.Parser;
import lombok.Getter;
import lombok.Setter;
import repository.EmployeeDataSource;
import repository.EmployeeDataSourceImpl;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Employee {
    Scanner scanner;
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

    public Employee findEmployeeByLastName(String lastName) {
        Employee currentEmployee = null;
        for (Employee employee : employeeDataSource.getEmployees()) {
            if (employee.lastName.equals(lastName)) {
                currentEmployee = employee;
                break;
            }
        }
        return currentEmployee;
    }

    public void prettyPrintAllEmployees() {
        for (Employee employee : employeeDataSource.getEmployees()) {
            System.out.println(employee);
        }
    }

    public void printOneEmployee() {
        System.out.print("Введите фамилию работника информацию о котором хотите вывести на экран: ");
        scanner = new Scanner(System.in);
        Employee employeeByLastName = findEmployeeByLastName(scanner.nextLine());
        System.out.println(employeeByLastName);
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

    public void removeEmployee() {
        System.out.print("Введите фамилию работника которого хотите удалить: ");
        scanner = new Scanner(System.in);
        Employee employeeByLastName = findEmployeeByLastName(scanner.nextLine());
        employeeDataSource.getEmployees().remove(employeeByLastName);
    }

    public void sortedEmployeeByLastName() {
        EmployeeComparator comparator = ComparatorUTIL.getEmployeeComparator(EmployeeComparatorType.LAST_NAME);
        employeeDataSource.getEmployees().stream().sorted(comparator).forEach(System.out::println);
    }

    public void sortedEmployeeByDateOfEmployment() {
        EmployeeComparator comparator = ComparatorUTIL.getEmployeeComparator(EmployeeComparatorType.DATE_OF_EMPLOYMENT);
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
