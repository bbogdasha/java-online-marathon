import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] expected = { "First name: Susan, Last name: Brown, Address: Address # 4",
                "First name: Karen, Last name: Davis, Address: Address #2",
                "First name: John, Last name: Taylor, Address: Address #1",
                "First name: John, Last name: Brown, Address: Address #1" };

        String[] actual = new String[4];

        AddressBook addressBook = new AddressBook(4);
        addressBook.create("John", "Brown", "Address #1");
        addressBook.create("Susan", "Brown", "Address # 4");
        addressBook.create("Karen", "Davis", "Address #2");
        addressBook.create("John", "Taylor", "Address #1");

        addressBook.sortedBy(SortOrder.DESC);

        int counter = 0;
        for (Object record : addressBook) {
            actual[counter++] = record.toString();
        }

        System.out.println(Arrays.toString(actual));
        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.equals(expected, actual));


//        AddressBook addressBook = new AddressBook(3);
//        System.out.println(addressBook.create("Bob", "Boblastname", "Address 1"));
//        System.out.println(addressBook.create("Ann", "Annlastname", "Address 2"));
//        System.out.println(addressBook.create("Ann", "Annlastname", "Address 2"));
//        System.out.println(addressBook.create("Ann", "Annlastname", "Address 2"));
//        System.out.println(addressBook.create("Carl", "Carllastname", "Address 3"));
//        System.out.println(addressBook.create("Emma", "Emmalastname", "Address 4"));
//        System.out.println(addressBook.create("Den", "Denlastname", "Address 5"));

//        System.out.println(addressBook.size());
//
//        System.out.println(addressBook.read("Emma", "Emmalastname"));
//
//        System.out.println(addressBook.toString());
//
//        System.out.println(addressBook.update("Bob", "Boblastname", "Address #10"));
//
//        System.out.println(addressBook.toString());
//
//        System.out.println(addressBook.delete("Carl", "Carllastname"));
//
//        System.out.println(addressBook.toString());

//        addressBook.create("Carl", "Carllastname", "Address 3");
//
//        System.out.println(addressBook.toString());
    }
}
