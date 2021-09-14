package exceptions;

public class IllegalNatalNumberException extends Exception {
    public IllegalNatalNumberException() {
        super();
    }

    public IllegalNatalNumberException(String message) {
        super(message);
    }

    public IllegalNatalNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalNatalNumberException(Throwable cause) {
        super(cause);
    }
}
