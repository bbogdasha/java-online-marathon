public class Oven {

    public static Pizza cook() {
        return Pizza.base()
                .addCheese("Pecorino cheese")
                .addMushroom("Champignons")
                .addVegetable("Tomato")
                .build();
    }
}
