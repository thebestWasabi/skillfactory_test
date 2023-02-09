package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
public class Department {

    private long departmentId;
    private Manager manager;
    private List<Employee> employees;

    public Department(long departmentId, Manager manager, List<Employee> employees) {
        this.departmentId = departmentId;
        this.manager = manager;
        this.employees = employees;
    }


}
