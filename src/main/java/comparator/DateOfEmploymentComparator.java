package comparator;

import model.Employee;

import java.text.DateFormat;

public class DateOfEmploymentComparator implements EmployeeComparator {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getDateOfEmployment().compareTo(o2.getDateOfEmployment());
    }
}
