public class Main {

    public static void main(String[] args) {
        Product p1 = new Product("Pen", 2.75);
        Product p2 = new Product();
        Product p3 = new Product("Notebook", 8.25);
        int countOfProduct = Product.count();
        System.out.println(countOfProduct);
    }
}
