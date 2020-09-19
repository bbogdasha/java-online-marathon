public class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;

    private Pizza() {

    }

    public String getCheese() {
        return cheese;
    }

    public String getMeat() {
        return meat;
    }

    public String getSeafood() {
        return seafood;
    }

    public String getVegetable() {
        return vegetable;
    }

    public String getMushroom() {
        return mushroom;
    }

    public static PizzaBuilder base() {
        return new PizzaBuilder();
    }

    public static class PizzaBuilder {
        private Pizza newPizza;

        private PizzaBuilder() {
            newPizza = new Pizza();
        }

        public PizzaBuilder addCheese(String cheese) {
            newPizza.cheese = cheese;
            return this;
        }

        public PizzaBuilder addMeat(String meat) {
            newPizza.meat = meat;
            return this;
        }

        public PizzaBuilder addSeafood(String seafood) {
            newPizza.seafood = seafood;
            return this;
        }

        public PizzaBuilder addVegetable(String vegetable) {
            newPizza.vegetable = vegetable;
            return this;
        }

        public PizzaBuilder addMushroom(String mushroom) {
            newPizza.mushroom = mushroom;
            return this;
        }

        public Pizza build() {
            return newPizza;
        }
    }
}
