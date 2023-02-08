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
                                        
                    1. Добавить работников в список
                    2. Показать список работников
                    3. Удалить работника из листа по фамилии
                    4. Найти конкретного работника по фамилии
                    5. Сортировать список работников по фамилии
                    6. Поменять тип сотрудника
                    7. Выход
                    """);
            System.out.print("Введите свой выбор сюда -> ");
            int command = scanner.nextInt();
            switch (command) {
                case 1 -> addEmployeeInList();
                case 2 -> printEmployees();
                case 3 -> removeEmployeeFromTheList();
                case 4 -> getEmployeeByLastName();
                case 5 -> sortedEmployeeByLastName();
                case 6 -> changeEmployeeType();
                case 7 -> System.exit(0);
            }
        }
    }

    private void addEmployeeInList() {
        employee.addEmployeesInList();
    }

    private void printEmployees() {
        employee.prettyPrintEmployee();
    }

    private void removeEmployeeFromTheList() {
        System.out.print("Введите фамилию работника которого хотите удалить: ");
        scanner = new Scanner(System.in);
        employee.removeEmployee(scanner.nextLine());
    }

    private void getEmployeeByLastName() {
        System.out.print("Введите фамилию работника информацию о котором хотите вывести на экран: ");
        scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();
        employee.findEmployeeByLastName(lastName);
    }

    private void sortedEmployeeByLastName() {
        employee.sortedEmployeeByLastName();
    }

    private void changeEmployeeType() {

    }
}
