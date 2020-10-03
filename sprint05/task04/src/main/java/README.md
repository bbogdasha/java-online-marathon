# Task04

Create class Person with private fields firstName,  lastName, idCode. Create two classes inherited from RuntimeException: 

NameException and CodeException. 

1) NameException will be thrown if the first name or last name is invalid (doesn't start from uppercase or contains not only letters and symbols "-" and " "). 

2) CodeException will be thrown if idCode is invalid (valid idCode contains exactly 10 digits). 

In class Person create setters methods that throw NameException or CodeException if appropriate arguments are not valid. Create static method buildPerson(String firstName, String lastName, String idCode) that returns Person if all arguments are valid otherwise it thrown IllegalArgumentException with message about all invalid arguments.  Override method toString() for Person class that returns representation of Person in form: firstName lastName: idCode. Override equals and hashCode methods for Person class.


For example:

Person p = new Person(); 
p.setFirstName("joe") throw NameException with message “Incorrect value joe for firstName (should start from upper case and contains only alphabetic characters and -, _)” 
p.setIdCode("2") throw CodeException with message "Incorrect value 2 for code (should contains exactly 10 digits)"
Person.buildPerson("Joe", "KlarK2", "AS-2") throw IllegalArgumentException with message "Incorrect value KlarK2 for lastName (should start from upper case and contains only alphabetic characters and -, _); Incorrect value AS-2 for code (should contains exactly 10 digits)"
