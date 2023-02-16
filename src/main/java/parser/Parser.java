package parser;

import model.Employee;
import model.EmployeeType;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static List<Employee> parseFileToObjectList(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        List<Employee> employees = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] employee = scanner.nextLine().split(" ");
            Employee currentEmployee = new Employee(employee[0], employee[1],
                    LocalDate.parse(employee[2], FORMATTER),
                    LocalDate.parse(employee[3], FORMATTER),
                    EmployeeType.valueOf(employee[4]));
            employees.add(currentEmployee);
        }
        return employees;
    }
}
