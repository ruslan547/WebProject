package by.itClass.model.exceptions;

public class ServiceException extends Exception {
    public ServiceException() {
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
