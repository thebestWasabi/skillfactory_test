package ru.wasabi.model;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.wasabi.parser.Parser;
import ru.wasabi.repository.EmployeeRepository;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

@Slf4j
@RequiredArgsConstructor
@Component
public class Department {

    private Scanner scanner;
    private static final String TXT_FAIL_EMPLOYEE = "src/main/resources/employee.txt";
    private final EmployeeRepository employeeRepository;


    public Employee findEmployeeByLastName(String lastName) {
        Employee currentEmployee = null;
        for (Employee employee : employeeRepository.getEmployees()) {
            if (employee.getLastName().equals(lastName)) {
                currentEmployee = employee;
                break;
            }
        }
        return currentEmployee;
    }

    public void prettyPrintAllEmployees() {
        for (Employee employee : employeeRepository.getEmployees()) {
            log.info("{}", employee);
        }
    }

    public void printOneEmployee() {
        log.info("Введите фамилию работника информацию о котором хотите вывести на экран: ");
        scanner = new Scanner(System.in);
        Employee employeeByLastName = findEmployeeByLastName(scanner.nextLine());

        if (employeeByLastName == null) {
            log.info("Такого работника нет");
        } else {
            log.info("{}", employeeByLastName);
            for (Employee employee : employeeByLastName.getEmployeesList()) {
                log.info("работник прикрепленный к данному менеджеру - {}", employee.getLastName());
            }
        }
    }

    public void addEmployeesInList() {
        try {
            List<Employee> result = Parser.parseFileToObjectList(TXT_FAIL_EMPLOYEE);
            for (Employee employee : result) {
                employeeRepository.addEmployee(employee);
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

        if (employeeByLastName == null) {
            log.info("Такого работника нет");
        } else {
            employeeRepository.getEmployees().remove(employeeByLastName);
            log.info("Работник удален из списка: {}", employeeByLastName.getLastName());
        }
    }

    public void sortedEmployeeByLastName() {
        employeeRepository.getEmployees().sort(((o1, o2) -> o1.getLastName().compareToIgnoreCase(o2.getLastName())));
        prettyPrintAllEmployees();
    }

    public void sortedEmployeeByDateOfEmployment() {
        employeeRepository.getEmployees().sort((Comparator.comparing(Employee::getDateOfEmployment)));
        prettyPrintAllEmployees();
    }

    public void sortEmployeeByDateOfBirth() {
        employeeRepository.getEmployees().sort(Comparator.comparing(Employee::getDateOfBirth));
        prettyPrintAllEmployees();
    }

    public void changeEmployeeType() {
        log.info("Введите фамилию работника, должность которого вы хотите изменить");
        scanner = new Scanner(System.in);
        Employee employee = findEmployeeByLastName(scanner.nextLine());

        if (employee == null) {
            log.info("Такого работника нет");
        } else {
            if (employee.getEmployeeType() == EmployeeType.WORKER) {
                employee.setEmployeeType(EmployeeType.MANAGER);
                log.info("Вы повысили работника до менеджера: {}", employee.getLastName());
            } else if (employee.getEmployeeType() == EmployeeType.MANAGER) {
                employee.setEmployeeType(EmployeeType.WORKER);
                employee.getEmployeesList().clear();
                log.info("Вы понизили менеджера до рядового работника: {}", employee.getLastName());
            }
        }
    }


    public void addEmployeeToTheManager() {
        log.info("Введите фамилию менеджера к которому хотите прикрепить работника");
        scanner = new Scanner(System.in);
        Employee manager = findEmployeeByLastName(scanner.nextLine());

        if (manager == null) {
            log.info("Такого менеджера нет");
        } else {
            if (manager.getEmployeeType() == EmployeeType.MANAGER) {
                log.info("Введите фамилию работника, которого хотите прикрепить к менеджеру: {}", manager.getLastName());
                Employee currentEmp = findEmployeeByLastName(scanner.nextLine());
                manager.addEmployeeToManager(currentEmp);
                log.info("Работник {} прикреплен к менеджеру {}", currentEmp.getLastName(), manager.getLastName());
            } else {
                log.info("{} {} - это рядовой сотрудник, а не менеджер", manager.getLastName(), manager.getFirstName());
            }
        }
    }
}
