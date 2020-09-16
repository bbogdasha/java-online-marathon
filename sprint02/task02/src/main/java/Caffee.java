import java.util.HashMap;
import java.util.Map;

class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    private String name;
    private int rating;
    private Map<String, Integer> ingredients;

    public Caffee(String name, int rating, Map<String, Integer> ingredients) {
        this.name = name;
        this.rating = rating;
        this.ingredients = ingredients;
    }

    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.ingredients = new HashMap<String, Integer>();
        addComponent("Water", 100);
        addComponent("Arabica", 20);
    }

    public String getName() {
        return name;
    }

    public DrinkReceipt addComponent(String componentName, int componentCount) {
        ingredients.put(componentName, componentCount);
        return this;
    }

    public Map<String, Integer> makeDrink() {
        return ingredients;
    }

    public int getRating() {
        return rating;
    }
}