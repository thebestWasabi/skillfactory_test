package model;

import comparator.ComparatorUTIL;
import comparator.EmployeeComparator;
import comparator.EmployeeComparatorType;
import lombok.extern.slf4j.Slf4j;
import parser.Parser;
import repository.EmployeeDataSource;
import repository.EmployeeDataSourceImpl;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class Department {

    private static final String TXT_FAIL_EMPLOYEE = "src/main/resources/employee.txt";
    private Scanner scanner;

    private final EmployeeDataSource employeeDataSource;

    public Department() {
        employeeDataSource = new EmployeeDataSourceImpl();
    }

    public Employee findEmployeeByLastName(String lastName) {
        Employee currentEmployee = null;
        for (Employee employee : employeeDataSource.getEmployees()) {
            if (employee.getLastName().equals(lastName)) {
                currentEmployee = employee;
                break;
            }
        }
        return currentEmployee;
    }

    public void prettyPrintAllEmployees() {
        for (Employee employee : employeeDataSource.getEmployees()) {
            log.info("{}", employee);
        }
    }

    public void printOneEmployee() {
        log.info("Введите фамилию работника информацию о котором хотите вывести на экран: ");
        scanner = new Scanner(System.in);
        Employee employeeByLastName = findEmployeeByLastName(scanner.nextLine());
        if (employeeByLastName != null) {
            log.info("{}", employeeByLastName);
            for (Employee employee : employeeByLastName.getEmployeesList()) {
                log.info("работник прикрепленный к данному менеджеру - {}", employee);
            }
        } else {
            log.info("Такого работника нет");
        }
    }

    public void addEmployeesInList() {
        try {
            List<Employee> result = Parser.parseFileToObjectList(TXT_FAIL_EMPLOYEE);
            for (Employee employee : result) {
                employeeDataSource.addEmployee(employee);
            }
            log.info("Работники добавлены в список");
        } catch (FileNotFoundException e) {
            log.error("Файл не найден: {}", e.getMessage());
        }
    }

    public void removeEmployee() {
        log.info("Введите фамилию работника которого хотите удалить: ");
        scanner = new Scanner(System.in);
        Employee employeeByLastName = findEmployeeByLastName(scanner.nextLine());
        employeeDataSource.getEmployees().remove(employeeByLastName);
        log.info("Работник {} удален из списка", employeeByLastName);
    }

    public void sortedEmployeeByLastName() {
        EmployeeComparator comparator = ComparatorUTIL.getEmployeeComparator(EmployeeComparatorType.LAST_NAME);
        employeeDataSource.getEmployees().stream().sorted(comparator).forEach(System.out::println);
    }

    public void sortedEmployeeByDateOfEmployment() {
        EmployeeComparator comparator = ComparatorUTIL.getEmployeeComparator(EmployeeComparatorType.DATE_OF_EMPLOYMENT);
        employeeDataSource.getEmployees().stream().sorted(comparator).forEach(System.out::println);
    }

    public void changeEmployeeType() {
        prettyPrintAllEmployees();
        System.out.println("---");
        log.info("Введите фамилию работника, должность которого вы хотите изменить");
        scanner = new Scanner(System.in);

        Employee employee = findEmployeeByLastName(scanner.nextLine());
        if (employee != null) {
            if (employee.getEmployeeType() == EmployeeType.WORKER) {
                employee.setEmployeeType(EmployeeType.MANAGER);

                log.info("Вы повысили работника {} {} до менеджера",
                        employee.getLastName(), employee.getFirstName());

            } else if (employee.getEmployeeType() == EmployeeType.MANAGER) {
                employee.setEmployeeType(EmployeeType.WORKER);
                employee.getEmployeesList().clear();

                log.info("Вы понизили менеджера {} {} до рядового работника",
                        employee.getLastName(), employee.getFirstName());
            }
        } else {
            log.info("Такого сотрудника нет");
        }
    }

    public void addEmployeeToTheManager() {
        prettyPrintAllEmployees();
        System.out.println("---");
        log.info("Введите фамилию менеджера к которому хотите прикрепить работника");
        scanner = new Scanner(System.in);

        Employee manager = findEmployeeByLastName(scanner.nextLine());
        if (manager != null) {
            if (manager.getEmployeeType() == EmployeeType.MANAGER) {

                log.info("Введите фамилию работника, которого хотите прикрепить к менеджеру {} {}",
                        manager.getLastName(), manager.getFirstName());

                Employee currentEmp = findEmployeeByLastName(scanner.nextLine());
                manager.addEmployeeToManager(currentEmp);

                log.info("Работник {} {} прикреплен к менеджеру {} {}",
                        currentEmp.getLastName(), currentEmp.getFirstName(),
                        manager.getLastName(), manager.getFirstName());
            } else {
                log.info("{} {} - это рядовой сотрудник, а не менеджер", manager.getLastName(), manager.getFirstName());
            }
        } else {
            log.info("Такого менеджера нет");
        }
    }


}

