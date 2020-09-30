public class Main {

    public static void main(String[] args) {

        DecisionMethod d1 = new Person("Bob1").goShopping;
        DecisionMethod d2 = new Person("Bob2").goShopping;
        DecisionMethod d3 = new Person("Bob3").goShopping;

        Shop shop = new Shop();
        shop.clients.add(d1);
        shop.clients.add(d2);
        shop.clients.add(d3);

        System.out.println(shop.sale("product1", 12));
        System.out.println(shop.sale("product1", 8));
        System.out.println(shop.sale("product1", 11));
    }
}
