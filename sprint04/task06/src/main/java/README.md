# Task06

Suppose we have the next class hierarchy:

![screenshot](https://github.com/bbogdasha/java-online-marathon/blob/master/sprint04/task06/screenshot/task06.png)

Create classes with name PersonComparator, EmployeeComparator, DeveloperComparator that implenent the Comparator<Type> generic interface.

In the Utility class create public static method named sortPeople(...) that takes an array of Person type and derivative from it types, and comparator as input, and returns the value of void type.

Also, as second argument the method sortPeople(...) can takes generic comparator for elements of Object type.

The sortPeople(...) method should sorted records by ascending. At first by name, then by age, then by salary, and then by Level (JUNIOR < MIDDLE < SENIOR)
