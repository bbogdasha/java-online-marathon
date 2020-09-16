import java.util.Map;

class Espresso extends Caffee {

    public Espresso(String name, int rating) {
        super(name, rating);
        addComponent("Water", 50);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        return super.makeDrink();
    }
}