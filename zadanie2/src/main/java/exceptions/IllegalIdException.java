package exceptions;

public class IllegalIdException extends Exception {
    public IllegalIdException() {
        super();
    }

    public IllegalIdException(String message) {
        super(message);
    }

    public IllegalIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalIdException(Throwable cause) {
        super(cause);
    }
}
