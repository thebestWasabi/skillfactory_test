package file;

import model.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    private static final String PATH = "src/main/resources/employee.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static List<Employee> parseFileToObjectList() throws FileNotFoundException {
        File file = new File(PATH);
        Scanner scanner = new Scanner(file);

        List<Employee> employees = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] employee = scanner.nextLine().split(" ");
            Employee currentEmployee = new Employee(employee[0], employee[1],
                    LocalDate.parse(employee[2], FORMATTER),
                    LocalDate.parse(employee[3], FORMATTER));
            employees.add(currentEmployee);
        }
        return employees;
    }
}
