class DeveloperComparator<T extends Developer> extends EmployeeComparator<T> {

    @Override
    public int compare(Person o1, Person o2) {
        return super.compare(o1, o2) == 0
                ? ((Developer) o1).getLevel().compareTo(((Developer) o2).getLevel())
                : super.compare(o1, o2);
    }
}