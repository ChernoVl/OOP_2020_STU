package exceptions;

public class IllegalNameSurnameException extends Exception {
    public IllegalNameSurnameException() {
        super();
    }

    public IllegalNameSurnameException(String message) {
        super(message);
    }

    public IllegalNameSurnameException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalNameSurnameException(Throwable cause) {
        super(cause);
    }
}
