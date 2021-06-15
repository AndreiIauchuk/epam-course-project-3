package by.epamtc.iovchuk.exception;

public class OutBoundsException extends Exception {

    public OutBoundsException() {
        super("Индекс вне допустимого диапазона!");
    }

    public OutBoundsException(String message) {
        super(message);
    }

    public OutBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutBoundsException(Throwable cause) {
        super(cause);
    }
}
