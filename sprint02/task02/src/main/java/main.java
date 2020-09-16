import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Water", 100);
        map.put("Arabica", 20);

        Caffee caffee = new Caffee("Ca", 10, map);
        System.out.println(caffee.getName() + " " + caffee.getRating() + " " + caffee.makeDrink());

        Caffee caffee2 = new Caffee("Ca2", 9);
        System.out.println(caffee2.getName() + " " + caffee2.getRating() + " " + caffee2.makeDrink());

        Espresso espresso = new Espresso("Es", 8);
        System.out.println(espresso.getName() + " " + espresso.getRating() + " " + espresso.makeDrink());

        Cappuccino cappuccino = new Cappuccino("Ca", 7);
        System.out.println(cappuccino.getName() + " " + cappuccino.getRating() + " " + cappuccino.makeDrink());

        List<Caffee> coffees = new ArrayList<Caffee>();
        coffees.add(new Espresso("Espresso", 8));
        coffees.add(new Cappuccino("Cappuccino", 10));
        coffees.add(new Espresso("Espresso", 10));
        coffees.add(new Cappuccino("Cappuccino", 6));
        coffees.add(new Caffee("Caffee", 6));

        MyUtils myUtils = new MyUtils();
        System.out.println(myUtils.averageRating(coffees));
    }
}
