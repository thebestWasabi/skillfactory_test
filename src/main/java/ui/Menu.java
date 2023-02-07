package ui;

import file.TXTReaderAndParser;
import file.TxtParser;
import lombok.extern.slf4j.Slf4j;
import method.EmployeeMethods;
import repository.DataSource;

import java.util.Scanner;

@Slf4j
public class Menu {

    private Scanner scanner;
    private final EmployeeMethods methods;

    public Menu(TxtParser txtParser, DataSource dataSource) {
        this.methods = new EmployeeMethods(txtParser, dataSource);
    }

    public void printMenu() {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                                        
                    1. Добавить новых работников из txt-файла в ArrayList
                    2. Показать список работников из ArrayList
                    3. Добавить сотрудника в ArrayList
                    4. Удалить сотрудника из ArrayList
                    5. Сортировать список сотрудников по фамилии
                    6. Привязать сотрудника к менеджеру
                    7. Выход
                    """);

            int command = scanner.nextInt();
            switch (command) {
                case 1 -> addNewEmployees();
                case 2 -> printEmployeeList();
                case 3 -> addEmployee();
                case 4 -> deleteEmployee();
                case 5 -> sortEmployeeByLastName();
                case 7 -> System.exit(0);
            }
        }
    }

    private void sortEmployeeByLastName() {
        methods.sortedEmployeeByLastName();
    }

    private  void addNewEmployees() {
        methods.openFileAndAddEmployeesInList();
    }

    private void printEmployeeList() {
        methods.prettyPrintEmployees();
    }

    private void addEmployee() {
        methods.addEmployee();
    }

    private void deleteEmployee() {
        System.out.println("Введите id сотрудника, которого хотите удалить из списка");
        methods.delete(scanner.nextLong());
    }
}
