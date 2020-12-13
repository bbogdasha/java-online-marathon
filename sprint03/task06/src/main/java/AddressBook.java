import java.util.*;

@SuppressWarnings("unchecked")
public class AddressBook implements Iterable<AddressBook> {
    private NameAddressPair[] addressBook;
    private int counter = 0;

    public AddressBook(int size) {
        addressBook = new NameAddressPair[size];
    }

    public boolean create(String firstname, String lastname, String address) {
        if (counter >= addressBook.length) {
            addressBook = Arrays.copyOf(addressBook, 2 * counter);
        }
        NameAddressPair.Person person = new NameAddressPair.Person(firstname, lastname);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(person)) {
                return false;
            }
        }
        addressBook[counter++] = new NameAddressPair(person, address);
        return true;
    }

    public String read(String firstname, String lastname) {
        NameAddressPair.Person person = new NameAddressPair.Person(firstname, lastname);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(person)) {
                return addressBook[i].address;
            }
        }
        return null;
    }

    public boolean update(String firstname, String lastname, String address) {
        NameAddressPair.Person person = new NameAddressPair.Person(firstname, lastname);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(person)) {
                addressBook[i].address = address;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String firstname, String lastname) {
        NameAddressPair.Person person = new NameAddressPair.Person(firstname, lastname);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(person)) {
                NameAddressPair[] newAddressBook = new NameAddressPair[addressBook.length];
                System.arraycopy(addressBook, 0, newAddressBook, 0, i);
                System.arraycopy(addressBook, i + 1, newAddressBook, i, addressBook.length - i - 1);
                addressBook = newAddressBook;
                counter--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return counter;
    }

    public void sortedBy(SortOrder order) {
        switch (order) {
            case ASC:
                Arrays.sort(addressBook, new Comparator<NameAddressPair>() {
                    @Override
                    public int compare(NameAddressPair o1, NameAddressPair o2) {
                        if (o1 == null || o2 == null) return 0;
                        return o1.person.firstName.equals(o2.person.firstName) ?
                                o1.person.lastName.compareTo(o2.person.lastName) :
                                o1.person.firstName.compareTo(o2.person.firstName);
                    }
                });
            break;
            case DESC:
                Arrays.sort(addressBook, new Comparator<NameAddressPair>() {
                    @Override
                    public int compare(NameAddressPair o1, NameAddressPair o2) {
                        if (o1 == null || o2 == null) return 0;
                        return o1.person.firstName.equals(o2.person.firstName) ?
                                -o1.person.lastName.compareTo(o2.person.lastName) :
                                -o1.person.firstName.compareTo(o2.person.firstName);
                    }
                });
            break;
        }
    }

    @Override
    public Iterator<AddressBook> iterator() {
        return new AddressBookIterator();
    }

    private class AddressBookIterator implements Iterator {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < addressBook.length && addressBook[counter] != null;
        }

        @Override
        public String next() {
            NameAddressPair nameAddressPair = addressBook[counter++];
            return "First name: " + nameAddressPair.person.firstName
                    + ", Last name: " + nameAddressPair.person.lastName
                    + ", Address: " + nameAddressPair.address;
        }
    }

    private static class NameAddressPair {
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        private static class Person {
            private String firstName;
            private String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return firstName.equals(person.firstName) &&
                        lastName.equals(person.lastName);
            }

            @Override
            public int hashCode() {
                return Objects.hash(firstName, lastName);
            }
        }
    }
}