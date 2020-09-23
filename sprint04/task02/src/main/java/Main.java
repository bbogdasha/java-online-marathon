import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<MyUtils.Student> list1 = new ArrayList<MyUtils.Student>();
        list1.add(new MyUtils.Student(1, null));
        list1.add(new MyUtils.Student(2, null));

        List<MyUtils.Student> list2 = new ArrayList<MyUtils.Student>();
        list2.add(new MyUtils.Student(1, null));
        list2.add(new MyUtils.Student(2, null));

        MyUtils myUtils = new MyUtils();
        myUtils.commonStudents(list1, list2);
    }
}
