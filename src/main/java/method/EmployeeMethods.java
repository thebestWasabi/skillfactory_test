package method;

import comparator.EmployeeComparator;
import comparator.LastNameEmpComparator;
import file.TxtParser;
import model.Department;
import model.Employee;
import model.Manager;
import repository.EmployeeDataSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class EmployeeMethods {

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

//    private final TxtParser txtParser;
//    private final EmployeeDataSource employeeDataSource;
//
//    public EmployeeMethods(TxtParser txtParser, EmployeeDataSource employeeDataSource) {
//        this.txtParser = txtParser;
//        this.employeeDataSource = employeeDataSource;
//    }
//
//    public void openFileAndAddEmployeesInList() {
//        try {
//            List<Employee> result = txtParser.parseFileToObjectList("src/main/resources/employee.txt", " ", Employee.class);
//            for (Employee employee : result) {
//                employeeDataSource.addEmployee(employee);
//            }
//            System.out.println("Работники добавлены в лист");
//        } catch (Exception e) {
//            System.out.println("Ошибка");
//        }
//    }
//
//    public void addEmployee() {
//        var scanner = new Scanner(System.in);
//        var employee = new Employee();
//
//        System.out.println("Введите id работника");
//        employee.setId(scanner.nextLong());
//
//        System.out.println("Введите имя");
//        scanner.nextLine();
//        employee.setFirstName(scanner.nextLine());
//
//        System.out.println("Введите фамилию");
//        employee.setLastName(scanner.nextLine());
//
//        System.out.println("Введите дату рождения (формат dd.mm.yyyy)");
//        employee.setDateOfBirth(LocalDate.parse(scanner.nextLine(), FORMATTER));
//
//        System.out.println("Введите дату устройства на работу (формат dd.mm.yyyy)");
//        employee.setDateOfEmployment(LocalDate.parse(scanner.nextLine(), FORMATTER));
//
//        employeeDataSource.addEmployee(employee);
//    }
//
//    public void delete(Long id) {
//        employeeDataSource.getEmployees().removeIf(employee -> employee.getId().equals(id));
//    }
//
//    public void prettyPrintEmployees() {
//        for (Employee employee : employeeDataSource.getEmployees()) {
//            System.out.println(employee);
//        }
//    }
//
//    public void sortedEmployeeByLastName() {
//        EmployeeComparator comparator = new LastNameEmpComparator();
//        employeeDataSource.getEmployees().stream().sorted(comparator).forEach(System.out::println);
//    }
//
//    public void assignAnEmployeeToAManager(String lastNameManager, String lastNameEmployee) {
//        List<Department> result = new ArrayList<>();
//
//        Manager currentManager = null;
//        Employee currentEmp = null;
//
//        Employee employee = new Employee();
//        employee.findEmployeeByLastName(lastNameEmployee);
//
//        Manager manager = new Manager();
//        manager.findManagerByLastName(lastNameManager);
//
//        result.add(new Department(currentManager, new ArrayList<>((Collection) currentEmp)));
//
//    }
}
