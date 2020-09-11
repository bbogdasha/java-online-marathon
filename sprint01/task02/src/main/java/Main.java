public class Main {

    public static void main(String[] args) {

        Employee emp1 = new Employee();
        Employee emp2 = new Employee();

        emp1.fullName = "Emily";
        emp1.salary = 28500.5f;
        emp2.fullName = "Alexander";
        emp2.salary = 33700.8f;

        Employee[] employees = {emp1, emp2};

        String employeesInfo = "";

        for (Employee employee : employees) {
            employeesInfo += "{fullName: \"" + employee.fullName + "\", " + "salary: " + employee.salary + "}, ";
        }

        employeesInfo = employeesInfo.substring(0, employeesInfo.length() - 2);
        employeesInfo = "[" + employeesInfo + "]";

        System.out.println(employeesInfo);
    }
}