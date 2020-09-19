public class Main {

    public static void main(String[] args) {

        System.out.println(ClientType.NEW.discount());
        System.out.println(ClientType.SILVER.discount());
        System.out.println(ClientType.GOLD.discount());
        System.out.println(ClientType.PLATINUM.discount());
    }
}


