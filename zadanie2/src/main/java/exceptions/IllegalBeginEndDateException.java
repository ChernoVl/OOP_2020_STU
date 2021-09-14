package exceptions;

public class IllegalBeginEndDateException extends Exception {
    public IllegalBeginEndDateException() {
        super();
    }

    public IllegalBeginEndDateException(String message) {
        super(message);
    }

    public IllegalBeginEndDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalBeginEndDateException(Throwable cause) {
        super(cause);
    }
}
