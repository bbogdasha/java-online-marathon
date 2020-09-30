import java.util.ArrayList;
import java.util.List;

class Shop {

    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        int count = 0;

        for (DecisionMethod dm : clients) {
            if (dm.decide(product, percent)) {
                count++;
            }
        }
        return count;
    }
}