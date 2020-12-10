# Task06

Create a Product class with fields name of type String and price of type double.
The Product class must meet the following principles:

1. All class fields must be private.
2. Get and set methods must be used to access the class fields.
3. The class must have a constructors with and without parameters.

In the Product class write count() static method that returns count of created objects of Product type.
For example, next fragment of code:

```java
Product pl = new Product("Pen", 2.75);
Product p2 = new Product();
Product p3 = new Product("Notebook", 8.25);

int countOfProducns = Product.count();
System.out.println(“Was created “ + countOfProducns + " new products!");
```

Will be print to console:

Was created 3 new products!