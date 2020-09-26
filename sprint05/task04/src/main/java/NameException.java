public class NameException extends RuntimeException {
    public NameException(String message) {
        super("Incorrect value " + message + " for firstName " +
                "(should start from upper case and contains only " +
                "alphabetic characters and -, space symbol;)");
    }
}
