package ui;

import lombok.extern.slf4j.Slf4j;
import model.Employee;

import java.util.Scanner;

@Slf4j
public class Menu {

    private Scanner scanner;
    private final Employee employee;

    public Menu() {
        this.employee = new Employee();
    }

    public void printMenu() {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                                        
                    1. Показать список работников
                    2. Добавить работника в список
                    3. Удалить работника из листа
                    4. Сортировать список работников по фамилии
                    5. Поменять тип сотрудника
                    6. Выход
                    """);
            System.out.print("Введите свой выбор сюда -> ");
            int command = scanner.nextInt();
            switch (command) {
                case 1 -> printEmployees();
                case 2 -> addEmployeeInList();
                case 3 -> removeEmployeeFromTheList();
                case 4 -> sortedEmployeeByLastName();
                case 5 -> changeEmployeeType();
                case 6 -> System.exit(0);
            }
        }
    }

    private void printEmployees() {
        employee.prettyPrintEmployee();
    }

    private void addEmployeeInList() {
        employee.addEmployeesInList();
    }

    private void removeEmployeeFromTheList() {
        System.out.print("Введите фамилию работника которого хотите удалить: ");
        scanner = new Scanner(System.in);
        employee.removeEmployee(scanner.nextLine());
    }

    private void sortedEmployeeByLastName() {
        employee.sortedEmployeeByLastName();
    }

    private void changeEmployeeType() {

    }
}
