import java.util.ArrayList;
import java.util.List;

class Shop {

    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        return (int) clients.stream()
                .filter(c -> c.decide(product, percent))
                .count();
    }
}