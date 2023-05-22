package ru.wasabi.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.wasabi.model.Department;

import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class SortedEmployeeMenu {

    private final Department department;


    public void sortedMenu() {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.println("""
                    
                    1. Сортировать работников по фамилии
                    2. Сортировать работников по дате рождения
                    3. Сортировка работников по дате принятия на работу
                    4. Назад
                    """);

            command = selectSorting(scanner);
        } while (!command.equals("4"));
    }


    private String selectSorting(Scanner scanner) {
        String command;
        System.out.println("---");

        command = scanner.nextLine();
        switch (command) {
            case "1" -> sortedEmployeeByLastName();
            case "2" -> sortEmployeeByBirth();
            case "3" -> sortedEmployeeByDateOfEmployment();
            case "4" -> System.out.println("Главное меню:");
            default -> System.err.println("Не корректная команда" + "\n");
        }
        return command;
    }


    private void sortedEmployeeByLastName() {
        department.sortedEmployeeByLastName();
    }

    private void sortEmployeeByBirth() {
        department.sortEmployeeByDateOfBirth();
    }

    private void sortedEmployeeByDateOfEmployment() {
        department.sortedEmployeeByDateOfEmployment();
    }
}
