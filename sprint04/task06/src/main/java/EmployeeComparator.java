class EmployeeComparator<T extends Employee> extends PersonComparator<T> {

    @Override
    public int compare(Person o1, Person o2) {
        return super.compare(o1, o2) == 0
                ? Double.compare(((Employee) o1).getSalary(), ((Employee) o2).getSalary())
                : super.compare(o1, o2);
    }
}
