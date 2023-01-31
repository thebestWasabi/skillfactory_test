package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class Employee extends Person {

    final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    LocalDate dateOfEmployment;

    public Employee(Long id, String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateOfEmployment) {
        super(id, firstName, lastName, dateOfBirth);
        this.dateOfEmployment = dateOfEmployment;
    }

    public Employee(String[] args) {
        this.id = Long.valueOf(args[0]);
        this.firstName = args[1];
        this.lastName = args[2];
        this.dateOfBirth = LocalDate.parse(args[3], FORMATTER);
        this.dateOfEmployment = LocalDate.parse(args[4], FORMATTER);
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
