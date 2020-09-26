import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String idCode;

    private static int message;

    static Person buildPerson(String firstName, String lastName, String idCode) {
        Person person = new Person();

        try {
            person.setFirstName(firstName);
        } catch (NameException e) {
            message++;
        }
        try {
            person.setLastName(lastName);
        } catch (NameException e) {
            message++;
        }
        try {
            person.setIdCode(idCode);
        } catch (CodeException e) {
            message++;
        }

        if (person == null) {
            throw new IllegalArgumentException();
        } else if (message == 1) {
            throw new IllegalArgumentException();
        } else if (message >= 2) {
            throw new IllegalArgumentException("Incorrect value " + firstName +
                    " for firstName (should start from upper case and contains " +
                    "only alphabetic characters and symbols -, _); Incorrect " +
                    "value " + idCode + " for code (should contains exactly 10 digits)");
        } else {
            return person;
        }
    }

    public void setFirstName(String firstName) {
        try {
            if (firstName.matches("[A-Z][a-z]*")) {
                this.firstName = firstName;
            } else {
                throw new NameException(firstName);
            }
        } catch (NameException e) {
            throw new NameException(firstName);
        }
    }

    public void setLastName(String lastName) {
        try {
            if (lastName.matches("[A-Z][a-z]*")) {
                this.lastName = lastName;
            } else {
                throw new NameException(lastName);
            }
        } catch (NameException e) {
            throw new NameException(lastName);
        }
    }

    public void setIdCode(String idCode) {
        try {
            if (idCode.matches("[0-9]{10}")) {
                this.idCode = idCode;
            } else {
                throw new CodeException(idCode);
            }
        } catch (CodeException e) {
            throw new CodeException(idCode);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                idCode.equals(person.idCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, idCode);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + idCode;
    }
}

