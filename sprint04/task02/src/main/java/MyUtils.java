import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MyUtils {

    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (this.name == null) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return id == student.id &&
                    name.equals(student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {

        Set<Student> students = new HashSet<>();
        for (Student student1 : list1) {
            for (Student student2 : list2) {
                if (student1.name == null && student2.name == null && student1.id == student2.id) {
                    students.add(student2);
                } else if (student1.name != null && student1.name.equals(student2.name) && student1.id == student2.id) {
                    students.add(student2);
                }
            }
        }
        return students;
    }
}
