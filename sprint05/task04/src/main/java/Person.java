import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String idCode;

    private final String regexFirstName = "[A-Z][[a-z]*[\\s?][a-z]+[-?][a-z]+]*";
    private final String regexCode = "[0-9]{10}";
    private static String message = "\n";

    public static Person buildPerson(String firstName, String lastName, String idCode) {
        Person person = new Person();
        try {
            person.setFirstName(firstName);
        } catch (NameException e) {
            message += e + "\n";
        }

        try {
            person.setLastName(lastName);
        } catch (NameException e) {
            message += e + "\n";
        }

        try {
            person.setIdCode(idCode);
        } catch (CodeException e) {
            message += e + "\n";
        }

        if (!message.equals("")) {
            throw new IllegalArgumentException(message);
        }
        return person;
    }

    public void setFirstName(String firstName) {
        if (!firstName.matches(regexFirstName)) throw new NameException(firstName);
        else this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (!lastName.matches(regexFirstName)) throw new NameException(lastName);
        else this.lastName = lastName;
    }

    public void setIdCode(String idCode) {
        if (!idCode.matches(regexCode)) throw new CodeException(idCode);
        else this.idCode = idCode;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + idCode;
    }
}

