package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfEmployment;
    private EmployeeType employeeType;

    private List<Employee> employeesList;

    public Employee(String firstName, String lastName, LocalDate dateOfBirth,
                    LocalDate dateOfEmployment, EmployeeType employeeType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfEmployment = dateOfEmployment;
        this.employeeType = employeeType;
        employeesList = new ArrayList<>();
    }



    public void addEmployeeToManager(Employee employee) {
        this.employeesList.add(employee);
    }

    @Override
    public String toString() {
        return "Employee (" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfEmployment=" + dateOfEmployment +
                ", employeeType=" + employeeType +
                ')';
    }
}
