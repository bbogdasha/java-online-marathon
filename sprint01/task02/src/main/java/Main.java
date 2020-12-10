public class Main {

    public static void main(String[] args) {

        Employee emp1 = new Employee();
        Employee emp2 = new Employee();

        emp1.fullName = "Emily";
        emp1.salary = 28500.5f;
        emp2.fullName = "Alexander";
        emp2.salary = 33700.8f;

        Employee[] employees = {emp1, emp2};


        //RIGHT SOLUTION
        StringBuilder sb = new StringBuilder();
        for (Employee employee : employees) {
            sb.append("{fullName: \"")
                    .append(employee.fullName)
                    .append("\", salary: ")
                    .append(employee.salary)
                    .append("}, ");
        }

        sb.delete(sb.length() - 2, sb.length());
        String employeesInfo = "[" + sb.toString() + "]";

        System.out.println(employeesInfo);
    }
}