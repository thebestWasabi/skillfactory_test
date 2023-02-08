package model;

import comparator.ComparatorUTIL;
import comparator.EmployeeComparator;
import comparator.EmployeeComparatorType;
import comparator.LastNameEmpComparator;
import file.Parser;
import file.TxtParser;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import repository.EmployeeDataSource;
import repository.EmployeeDataSourceImpl;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@Slf4j
public class Employee {

    private final String TXT_FAIL_EMPLOYEE = "src/main/resources/employee.txt";
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

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

    public Employee(String[] args) {
        this.firstName = args[0];
        this.lastName = args[1];
        this.dateOfBirth = LocalDate.parse(args[2], FORMATTER);
        this.dateOfEmployment = LocalDate.parse(args[3], FORMATTER);
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
        log.info("Введите фамилию работника информацию о котором хотите вывести на экран: ");
        scanner = new Scanner(System.in);
        Employee employeeByLastName = findEmployeeByLastName(scanner.nextLine());
        log.info("{}", employeeByLastName);
    }

    public void addEmployeesInList() {
        try {
            List<Employee> result = Parser.parseFileToObjectList();
            for (Employee employee : result) {
                employeeDataSource.addEmployee(employee);
            }
            log.info("Работники добавлены в список");
        } catch (FileNotFoundException e) {
            log.error("Файл не найден");
        }
    }

    /**
     * Добавление сотрудников из txt файла через конструктор и parser
     */
    public void openFileAndAddEmployeesInList() {
        try {
            List<Employee> result = TxtParser.parseFileToObjectList(TXT_FAIL_EMPLOYEE, " ", Employee.class);
            for (Employee employee : result) {
                employeeDataSource.addEmployee(employee);
            }
            log.info("Работники добавлены в список");
        } catch (Exception e) {
            log.error("Файл не найден");
        }
    }

    public void removeEmployee() {
        log.info("Введите фамилию работника которого хотите удалить: ");
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
