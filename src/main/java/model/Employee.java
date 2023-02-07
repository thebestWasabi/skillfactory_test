package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import repository.DataSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class Employee extends Person {

    final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    LocalDate dateOfEmployment;

    public Employee(Long id, String firstName, String lastName, LocalDate dateOfBirth, DataSource dataSource, LocalDate dateOfEmployment) {
        super(id, firstName, lastName, dateOfBirth, dataSource);
        this.dateOfEmployment = dateOfEmployment;
    }

    public Employee(String[] args) {
        this.id = Long.valueOf(args[0]);
        this.firstName = args[1];
        this.lastName = args[2];
        this.dateOfBirth = LocalDate.parse(args[3], FORMATTER);
        this.dateOfEmployment = LocalDate.parse(args[4], FORMATTER);
    }

    public Employee findEmployeeById(long id) {
        Employee current = null;
        for (Employee employee : dataSource.getEmployees()) {
            if (employee.getId() == id) {
                current = employee;
                break;
            }
        }
        return current;
    }

    public Employee findEmployeeByLastName(String lastName) {
        Employee current = null;
        for (Employee employee : dataSource.getEmployees()) {
            if (employee.getLastName().equals(lastName)) {
                current = employee;
                break;
            }
        }
        return current;
    }

    @Override
    public String toString() {
        return "Employee (" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfEmployment=" + dateOfEmployment +
                ')';
    }
}
