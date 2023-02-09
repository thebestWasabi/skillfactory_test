package ui;

import lombok.extern.slf4j.Slf4j;
import model.Employee;

import java.util.Scanner;

@Slf4j
public class MainMenu {

    private final Employee employee;

    public MainMenu() {
        this.employee = new Employee();
    }

    public void printMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                                        
                    1. Добавить работников в список
                    2. Показать список работников
                    3. Удалить работника из листа по фамилии
                    4. Найти конкретного работника по фамилии
                    5. Сортировать список работников
                    6. Поменять тип сотрудника
                    7. Выход
                    """);
            System.out.print("Введите свой выбор сюда -> ");
            String command = scanner.nextLine();
            switch (command) {
                case "1" -> addEmployeeInList();
                case "2" -> printEmployees();
                case "3" -> removeEmployeeFromTheList();
                case "4" -> getEmployeeByLastName();
                case "5" -> sortedEmployee();
                case "6" -> changeEmployeeType();
                case "7" -> System.exit(0);
                default -> System.err.println("Не корректная команда" + "\n");
            }
        }
    }

    private void addEmployeeInList() {
        employee.openFileAndAddEmployeesInList();
    }

    private void printEmployees() {
        employee.prettyPrintAllEmployees();
    }

    private void removeEmployeeFromTheList() {
        employee.removeEmployee();
    }

    private void getEmployeeByLastName() {
        employee.printOneEmployee();
    }

    private void sortedEmployee() {
        SortedEmployeeMenu menu = new SortedEmployeeMenu(employee);
        menu.sortedMenu();
    }

    private void changeEmployeeType() {

    }
}
