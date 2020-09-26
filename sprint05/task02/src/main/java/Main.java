public class Main {

    public static void main(String[] args) throws ColorException, TypeException {
        Plant plant = new Plant("Rare", "RED", "MyPlant");
//        Plant plant = new Plant("Unknown type", "Name");
//        Plant plant = new Plant("My plant");
        System.out.println(plant.toString());
    }
}
