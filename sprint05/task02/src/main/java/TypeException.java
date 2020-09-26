public class TypeException extends Exception {
    public TypeException(String message) {
        super("Invalid value " + message + " for field type");
    }
}
