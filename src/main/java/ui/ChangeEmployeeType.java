package ui;

import model.Department;

import java.util.Scanner;

public class ChangeEmployeeType {

    private final Department department;

    public ChangeEmployeeType(Department department) {
        this.department = department;
    }

    public void changeEmployeeType() {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.println("""

                    1. Найти работника и его подчиненных (если они есть) по фамилии
                    2. Изменить должность сотрудника
                    3. Привязать работника к менеджеру
                    4. Назад
                    """);
            System.out.print("---");
            command = scanner.nextLine();
            switch (command) {
                case "1" -> getEmployeeByLastName();
                case "2" -> changeEmployeeTypeByLastName();
                case "3" -> addEmployeeToTheManager();
                case "4" -> System.out.println("exit");
                default -> System.err.println("Не корректная команда" + "\n");
            }
        } while (!command.equals("4"));
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
}
