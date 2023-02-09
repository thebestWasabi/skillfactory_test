package ui;

import model.Employee;

import java.util.Scanner;

public class SortedEmployeeMenu {

    private final Employee employee;

    public SortedEmployeeMenu(Employee employee) {
        this.employee = employee;
    }

    public void sortedMenu() {

        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.println("""
                                        
                    1. Сортировать работников по фамилии
                    2. Сортировка работников по дате принятия на работу
                    3. Назад
                    """);
            System.out.print("Введите свой выбор сюда -> ");
            command = scanner.nextLine();
            switch (command) {
                case "1" -> sortedEmployeeByLastName();
                case "2" -> sortedEmployeeByDateOfEmployment();
                case "3" -> System.out.println("exit");
                default -> System.err.println("Не корректная команда" + "\n");
            }
        } while (!command.equals("3"));
    }

    private void sortedEmployeeByLastName() {
        employee.sortedEmployeeByLastName();
    }

    private void sortedEmployeeByDateOfEmployment() {
        employee.sortedEmployeeByDateOfEmployment();
    }
}
