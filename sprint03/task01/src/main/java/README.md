# Task01

Suppose we have the next class:
```java
public class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;

    private Pizza() {
    }
    
    public static PizzaBuilder base() {
        return new PizzaBuilder();
    }
}
```

Create public static inner class named PizzaBuilder inside Pizza class that correspond the next class diagram:
![screenshot](https://github.com/bbogdasha/java-online-marathon/blob/master/sprint03/task01/screenshot/screen.png)

Inside the cook method create and return an instance of Pizza class with your at least three favorite ingredients.
