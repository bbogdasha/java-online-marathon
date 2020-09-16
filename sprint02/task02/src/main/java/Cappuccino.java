import java.util.Map;

class Cappuccino extends Caffee {

    public Cappuccino(String name, int rating) {
        super(name, rating);
        addComponent("Milk", 50);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        return super.makeDrink();
    }
}