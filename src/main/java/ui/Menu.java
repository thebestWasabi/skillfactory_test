package ui;

import lombok.extern.slf4j.Slf4j;
import model.Employee;

import java.util.Scanner;

@Slf4j
public class Menu {

    private final Employee employee;

    public Menu() {
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
                    5. Сортировать список работников по фамилии
                    6. Сортировать список работников по дате принятия на работу
                    7. Поменять тип сотрудника
                    8. Выход
                    """);
            System.out.print("Введите свой выбор сюда -> ");
            int command = scanner.nextInt();
            switch (command) {
                case 1 -> addEmployeeInList();
                case 2 -> printEmployees();
                case 3 -> removeEmployeeFromTheList();
                case 4 -> getEmployeeByLastName();
                case 5 -> sortedEmployeeByLastName();
                case 6 -> sortedEmployeeByDateOfEmployment();
                case 7 -> changeEmployeeType();
                case 8 -> System.exit(0);
            }
        }
    }

    private void addEmployeeInList() {
        employee.addEmployeesInList();
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

    private void sortedEmployeeByLastName() {
        employee.sortedEmployeeByLastName();
    }

    private void sortedEmployeeByDateOfEmployment() {
        employee.sortedEmployeeByDateOfEmployment();
    }

    private void changeEmployeeType() {

    }
}
