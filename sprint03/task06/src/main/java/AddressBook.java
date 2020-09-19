import java.util.*;

@SuppressWarnings("unchecked")
public class AddressBook implements Iterable<AddressBook> {
    private NameAddressPair[] addressBook;
    private int counter = 0;

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstname, String lastname, String address) {
        boolean check = false;
        if (counter >= addressBook.length) {
            NameAddressPair[] newAddressBook = new NameAddressPair[addressBook.length * 2];
            System.arraycopy(addressBook, 0, newAddressBook, 0, counter);
            addressBook = newAddressBook;
        }
        if (counter == 0) {
            addressBook[counter] = new NameAddressPair(new NameAddressPair.Person(firstname, lastname), address);
            counter++;
            check = true;
        } else if (!addressBook[counter - 1].getPerson().getFirstName().equals(firstname) && addressBook[counter - 1].getPerson().getLastName().equals(lastname)
                || addressBook[counter - 1].getPerson().getFirstName().equals(firstname) && !addressBook[counter - 1].getPerson().getLastName().equals(lastname)
                || !addressBook[counter - 1].getPerson().getFirstName().equals(firstname) && !addressBook[counter - 1].getPerson().getLastName().equals(lastname)) {
            addressBook[counter] = new NameAddressPair(new NameAddressPair.Person(firstname, lastname), address);
            counter++;
            check = true;
        }
        return check;
    }

    public String read(String firstname, String lastname) {
        String result = "";
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].getPerson().getFirstName().equals(firstname) && addressBook[i].getPerson().getLastName().equals(lastname)) {
                result = addressBook[i].getAddress();
                break;
            } else {
                result = null;
            }
        }
        return result;
    }

    public boolean update(String firstname, String lastname, String address) {
        boolean check = false;
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].getPerson().getFirstName().equals(firstname) && addressBook[i].getPerson().getLastName().equals(lastname)) {
                addressBook[i].setAddress(address);
                check = true;
            }
        }
        return check;
    }

    public boolean delete(String firstname, String lastname) {
        boolean check = false;
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].getPerson().getFirstName().equals(firstname) && addressBook[i].getPerson().getLastName().equals(lastname)) {
                System.arraycopy(addressBook, i + 1, addressBook, i, addressBook.length - i - 1);
                NameAddressPair[] newAddressBook = new NameAddressPair[addressBook.length - 1];
                if (addressBook.length - 1 >= 0)
                    System.arraycopy(addressBook, 0, newAddressBook, 0, addressBook.length - 1);
                addressBook = new NameAddressPair[addressBook.length - 1];
                System.arraycopy(newAddressBook, 0, addressBook, 0, addressBook.length);
                counter--;
                check = true;
                break;
            }
        }
        return check;
    }

    public int size() {
        return counter;
    }

    public void sortedBy(SortOrder order) {
        switch (order) {
            case ASC: Arrays.sort(addressBook, (p1, p2) -> {
                int res =  p1.getPerson().getFirstName().compareToIgnoreCase(p2.getPerson().getFirstName());
                if (res != 0)
                    return res;
                return p1.getPerson().getLastName().compareToIgnoreCase(p2.getPerson().getLastName());
            });
            break;
            case DESC: Arrays.sort(addressBook, (p1, p2) -> {
                int res =  p2.getPerson().getFirstName().compareToIgnoreCase(p1.getPerson().getFirstName());
                if (res != 0)
                    return res;
                return p2.getPerson().getLastName().compareToIgnoreCase(p1.getPerson().getLastName());
            });
            break;
        }
    }

    @Override
    public Iterator<AddressBook> iterator() {
        return new AddressBookIterator();
    }

    @SuppressWarnings("unchecked")
    private class AddressBookIterator implements Iterator {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < addressBook.length && addressBook[counter] != null;
        }

        @Override
        public String next() {
            return "First name: " + addressBook[counter].getPerson().getFirstName() + ", Last name: " +
                    addressBook[counter].getPerson().getLastName() + ", Address: " + addressBook[counter++].getAddress();
        }
    }

    private static class NameAddressPair {
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        public Person getPerson() {
            return person;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        private static class Person {
            private String firstName;
            private String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            public String getFirstName() {
                return firstName;
            }

            public String getLastName() {
                return lastName;
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
