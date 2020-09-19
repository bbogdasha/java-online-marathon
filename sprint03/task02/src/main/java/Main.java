public class Main {

    public static void main(String[] args) {

        NameList nameList = new NameList();
        NameList.Iterator it = nameList.getIterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
