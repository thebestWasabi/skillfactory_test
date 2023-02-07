package file;

import model.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TXTReaderAndParser {

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final String PATH = "src/main/resources/worker.txt";

    public static List<Employee> parseFileToObjectList() {
        File file = new File(PATH);
        try (Scanner scanner = new Scanner(file)) {
            List<Employee> employees = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] employee = scanner.nextLine().split(" ");
                Employee currentEmployee = new Employee(Long.parseLong(employee[0]), employee[1], employee[2],
                        LocalDate.parse(employee[3], FORMATTER), LocalDate.parse(employee[4], FORMATTER));
                employees.add(currentEmployee);
            }
            return employees;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        return null;
    }
}
