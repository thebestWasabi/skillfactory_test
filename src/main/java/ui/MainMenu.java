package ui;

import lombok.extern.slf4j.Slf4j;
import model.Department;
import model.Employee;

import java.util.Scanner;

@Slf4j
public class MainMenu {

    private final Department department;

    public MainMenu() {
        department = new Department();
    }

    public void printMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                                        
                    1. Добавить работников из txt-файла в список
                    2. Показать список всех работников (подчиненные сотрудники указываться НЕ БУДУТ)
                    3. Удалить работника из листа по фамилии
                    4. Работники (откроется меню с доп возможностями)
                    5. Сортировать список работников (откроется меню с доп возможностями)
                    6. Выход
                    """);
            System.out.println("---");
            String command = scanner.nextLine();
            switch (command) {
                case "1" -> addEmployeeInList();
                case "2" -> printEmployees();
                case "3" -> removeEmployeeFromTheList();
                case "4" -> changeEmployeeType();
                case "5" -> sortedEmployee();
                case "6" -> System.exit(0);
                default -> log.info("Не корректная команда");
            }
        }
    }

    private void addEmployeeInList() {
        department.addEmployeesInList();
    }

    private void printEmployees() {
        department.prettyPrintAllEmployees();
    }

    private void removeEmployeeFromTheList() {
        department.removeEmployee();
    }

    private void changeEmployeeType() {
        ChangeEmployeeType menu = new ChangeEmployeeType(department);
        menu.changeEmployeeType();
    }

    private void sortedEmployee() {
        SortedEmployeeMenu menu = new SortedEmployeeMenu(department);
        menu.sortedMenu();
    }


}
