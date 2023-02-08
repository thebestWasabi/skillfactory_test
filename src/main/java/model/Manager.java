package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import repository.EmployeeDataSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Manager {

    final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
}
