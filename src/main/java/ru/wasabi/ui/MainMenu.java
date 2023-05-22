package ru.wasabi.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.wasabi.model.Department;

import java.util.Scanner;

@Slf4j
@RequiredArgsConstructor
@Component
public class MainMenu {

    private final Department department;
    private final ChangeEmployeeType changeEmployeeType;
    private final SortedEmployeeMenu sortedEmployeeMenu;


    public void printMenu() {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.println("""
                                        
                    1. Добавить работников из txt-файла в список
                    2. Показать список всех работников (подчиненные сотрудники указываться НЕ БУДУТ)
                    3. Удалить работника из листа по фамилии
                    4. Работники (откроется меню с доп возможностями)
                    5. Сортировать список работников (откроется меню с доп возможностями)
                    6. Выход
                    """);

            command = select(scanner);
        } while (!command.equals("6"));
    }


    private String select(Scanner scanner) {
        String command;
        System.out.println("---");

        command = scanner.nextLine();
        switch (command) {
            case "1" -> addEmployeeInList();
            case "2" -> printEmployees();
            case "3" -> removeEmployeeFromTheList();
            case "4" -> changeEmployeeType();
            case "5" -> sortedEmployee();
            case "6" -> System.out.println("выход");
            default -> log.info("Не корректная команда");
        }
        return command;
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
        changeEmployeeType.changeEmployeeType();
    }

    private void sortedEmployee() {
        sortedEmployeeMenu.sortedMenu();
    }
}
