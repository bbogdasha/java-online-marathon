# Task03

Suppose we have execute method with next signature:
```java
public static void execute(int a, int b, Strategy strategy) {
    double result = strategy.doOperation(a, b);
    System.out.println(result);
}
```

where the Strategy is the next interface :
```java
public interface Strategy {
    double doOperation(int a, int b);
}
```

Using anonymous classes concept, call the execute method 4 times with different strategy (override method doOperation from Strategy interface):

* Add a to b   \\   (a + b)
* Subtract b from a   \\   (a - b)
* Multiply a by b   \\   (a * b)
* Divide a by b   \\   (a / b)
