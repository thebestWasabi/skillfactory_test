package model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import repository.DataSource;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PROTECTED)
@Data
@NoArgsConstructor
public class Person {

    DataSource dataSource;

    Long id;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;

    public Person(Long id, String firstName, String lastName, LocalDate dateOfBirth, DataSource dataSource) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dataSource = dataSource;
    }
}
