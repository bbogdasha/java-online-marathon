public class ColorException extends Exception {
    public ColorException(String message) {
        super("Invalid value " + message + " for field color");
    }
}