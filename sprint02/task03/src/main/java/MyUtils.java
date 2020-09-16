import java.util.*;

public class MyUtils {
    public List<Person> maxDuration(List<Person> persons) {

        if (persons.isEmpty()) {
            return persons;
        }
        if (persons.size() == 1 && persons instanceof Person) {
            return Collections.emptyList();
        }
        for (Person person : persons) {
            if(person == null){
                return persons;
            }
        }

        List<Person> result = new ArrayList<>();

        List<Worker> workers = new ArrayList<>();
        Worker worker;
        List<Student> students = new ArrayList<>();
        Student student;

        for (Person p : persons) {
            if (p instanceof Student) {
                student = (Student) p;
                students.add(student);
            } else if (p instanceof Worker) {
                worker = (Worker) p;
                workers.add(worker);
            }
        }

        Student studentMax =  Collections.max(students, Comparator.comparing(Student::getStudyYears));
        Worker workerMax =  Collections.max(workers, Comparator.comparing(Worker::getExperienceYears));

        result.add(workerMax);
        result.add(studentMax);

        for (Student s : students) {
            if (studentMax.getStudyYears() == s.getStudyYears() && s != studentMax) {
                result.add(s);
            }
        }
        for (Worker w : workers) {
            if (workerMax.getExperienceYears() == w.getExperienceYears() && w != workerMax) {
                result.add(w);
            }
        }
        return result;
    }
}
