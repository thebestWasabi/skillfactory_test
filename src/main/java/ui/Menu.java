package ui;

import file.TxtParser;
import method.EmployeeMethods;
import repository.DataSource;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    EmployeeMethods methods;

    private final TxtParser txtParser;
    private final DataSource dataSource;

    public Menu(TxtParser txtParser, DataSource dataSource) {
        this.txtParser = txtParser;
        this.dataSource = dataSource;
    }

    public void printMenu() {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                                        
                    1. Добавить новых работников в лист
                    2. Показать список работников из листа
                    3. Добавить сотрудника в лист
                    4. Удалить сотрудника
                    5. Привязать сотрудника к менеджеру
                    6. Выход
                    """);

            int command = scanner.nextInt();
            switch (command) {
                case 1 -> addNewEmployees();
                case 2 -> printEmployeeList();
                case 3 -> addEmployee();
                case 4 -> deleteEmployee();
                case 6 -> System.exit(0);
            }
        }
    }

    private void addNewEmployees() {
        methods = new EmployeeMethods(txtParser, dataSource);
        methods.openFileAndAddEmployeesInList();
    }

    private void printEmployeeList() {
        methods = new EmployeeMethods(txtParser, dataSource);
        methods.prettyPrintEmployees();
    }

    private void addEmployee() {
        methods = new EmployeeMethods(txtParser, dataSource);
        methods.addEmployee();
    }

    private void deleteEmployee() {
        System.out.println("Введите id сотрудника, которого хотите удалить из списка");
        methods = new EmployeeMethods(txtParser, dataSource);
        methods.delete(scanner.nextLong());
    }
}
