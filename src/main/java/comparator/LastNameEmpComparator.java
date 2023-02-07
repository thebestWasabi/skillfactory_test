package comparator;

import model.Employee;

public class LastNameEmpComparator implements EmployeeComparator {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
