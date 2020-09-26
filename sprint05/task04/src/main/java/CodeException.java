public class CodeException extends RuntimeException {
    public CodeException(String message) {
        super("Incorrect value " + message + " for code (should contains exactly 10 digits)");
    }
}
