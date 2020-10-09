import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

class Interactor {

    int x;

    public synchronized void serve(UnaryOperator<Integer> uo, int initializer)throws InterruptedException{
        System.out.println("Serving thread running\nServing thread initializes the key");
        this.x = uo.apply(initializer);
        System.out.println("key = " + x);
        wait();
        System.out.println("Serving thread resumed");
    }

    public synchronized void consume(BinaryOperator<Integer> bo, int operand2)throws InterruptedException{
        wait(3000);
        System.out.println("Consuming thread received the key. key = " + x);
        this.x = bo.apply(x, operand2);
        System.out.println("Consuming thread changed the key. key = " + x);
        notifyAll();
    }
} 