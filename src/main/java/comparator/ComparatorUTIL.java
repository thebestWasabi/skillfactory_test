package comparator;

public class ComparatorUTIL {

    private ComparatorUTIL() {
    }

    public static EmployeeComparator getEmployeeComparator(EmployeeComparatorType type) {
        switch (type) {
            case LAST_NAME -> {
                return new LastNameEmpComparator();
            }
            case DATE_OF_EMPLOYMENT -> {
                return new DateOfEmploymentComparator();
            }
            default -> {
                return new LastNameEmpComparator();
            }
        }
    }
}
