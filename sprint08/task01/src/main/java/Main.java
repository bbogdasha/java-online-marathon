public class Main {

    public static void main(String[] args) {
        CheckCamelCase.checkAndPrint(Class1.class);
        System.out.println("=====");
        CheckCamelCase.checkAndPrint(Class2.class);
        System.out.println("=====");
        CheckCamelCase.checkAndPrint(ClassForAnnot.class);
    }
}



