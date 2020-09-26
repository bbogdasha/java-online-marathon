public class InsufficientAmountException extends Exception {
    private double amount;

    public InsufficientAmountException(double message) {
        super("Sorry, but you are short $" + message);
        this.amount = message;
    }

    public double getAmount() {
        return amount;
    }

    public String getMessage() {
        return "Sorry, but you are short $" + getAmount();
    }
}
