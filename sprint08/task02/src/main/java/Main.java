public class Main {

    public static void main(String[] args) {

        Class1 class1 = new Class1();
        Class2 class2 = new Class2();
        Class3 class3 = new Class3();

        Util.review(class1.getClass().getName());
        Util.review(class2.getClass().getName());
        Util.review(class3.getClass().getName());
        Util.review("Classs");
    }
}
