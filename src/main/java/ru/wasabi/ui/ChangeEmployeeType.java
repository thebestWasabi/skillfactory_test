package ru.wasabi.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.wasabi.model.Department;

import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class ChangeEmployeeType {

    private final Department department;


    public void changeEmployeeType() {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.println("""

                    1. Найти работника и его подчиненных (если они есть) по фамилии
                    2. Изменить должность сотрудника
                    3. Привязать рабочего к менеджеру
                    4. Отвязать рабочего от менеджера
                    5. Назад
                    """);
            command = select(scanner);
        } while (!command.equals("5"));
    }


    private String select(Scanner scanner) {
        String command;
        System.out.println("---");
        command = scanner.nextLine();
        switch (command) {
            case "1" -> getEmployeeByLastName();
            case "2" -> changeEmployeeTypeByLastName();
            case "3" -> addEmployeeToTheManager();
            case "4" -> removeEmployeeToTheManager();
            case "5" -> System.out.println("Главное меню:");
            default -> System.err.println("Не корректная команда" + "\n");
        }
        return command;
    }


    private void getEmployeeByLastName() {
        department.printOneEmployee();
    }

    private void changeEmployeeTypeByLastName() {
        department.changeEmployeeType();
    }

    private void addEmployeeToTheManager() {
        department.addEmployeeToTheManager();
    }

    private void removeEmployeeToTheManager() {
        department.removeEmployeeToTheManager();
    }

}
