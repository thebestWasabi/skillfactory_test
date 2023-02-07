package method;

import file.TxtParser;
import model.Department;
import model.Employee;
import model.Manager;
import repository.DataSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class EmployeeMethods {

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private final TxtParser txtParser;
    private final DataSource dataSource;

    public EmployeeMethods(TxtParser txtParser, DataSource dataSource) {
        this.txtParser = txtParser;
        this.dataSource = dataSource;
    }

    public void openFileAndAddEmployeesInList() {
        try {
            List<Employee> result = txtParser.parseFileToObjectList("src/main/resources/worker.txt", " ", Employee.class);
            for (Employee employee : result) {
                dataSource.addEmployee(employee);
            }
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }

    public void addEmployee() {
        var scanner = new Scanner(System.in);
        var employee = new Employee();

        System.out.println("Введите id работника");
        employee.setId(scanner.nextLong());

        System.out.println("Введите имя");
        scanner.nextLine();
        employee.setFirstName(scanner.nextLine());

        System.out.println("Введите фамилию");
        employee.setLastName(scanner.nextLine());

        System.out.println("Введите дату рождения (формат dd.mm.yyyy)");
        employee.setDateOfBirth(LocalDate.parse(scanner.nextLine(), FORMATTER));

        System.out.println("Введите дату устройства на работу (формат dd.mm.yyyy)");
        employee.setDateOfEmployment(LocalDate.parse(scanner.nextLine(), FORMATTER));

        dataSource.addEmployee(employee);
    }

    public void delete(Long id) {
        dataSource.getEmployees().removeIf(employee -> employee.getId().equals(id));
    }

    public void prettyPrintEmployees() {
        for (Employee employee : dataSource.getEmployees()) {
            System.out.println(employee);
        }
    }

    public Employee findEmployeeByLastName(String lastName) {
        Employee current = null;
        for (Employee employee : dataSource.getEmployees()) {
            if (employee.getLastName().equals(lastName)) {
                current = employee;
                break;
            }
        }
        return current;
    }

    public Manager findManagerByLastName(String lastName) {
        Manager current = null;
        for (Manager manager : dataSource.getManagers()) {
            if (manager.getLastName().equals(lastName)) {
                current = manager;
                break;
            }
        }
        return current;
    }

    public Employee findEmployeeById(long id) {
        Employee current = null;
        for (Employee employee : dataSource.getEmployees()) {
            if (employee.getId() == id) {
                current = employee;
                break;
            }
        }
        return current;
    }



    public void assignAnEmployeeToAManager(String lastNameManager, String lastNameEmployee) {
        List<Department> result = new ArrayList<>();

        Manager currentManager = null;
        Employee currentEmp = null;
        findManagerByLastName(lastNameManager);
        findEmployeeByLastName(lastNameEmployee);

        result.add(new Department(currentManager, new ArrayList<>((Collection) currentEmp)));

    }
}
