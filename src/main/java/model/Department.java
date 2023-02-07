package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Department {

    Manager manager;
    List<Employee> employees;

    public Department(Manager manager, List<Employee> employees) {
        this.manager = manager;
        this.employees = employees;
    }
}
