package by.epamtc.iovchuk.task1.exception;

public class NullException extends Exception{

    public NullException() {
        super();
    }

    public NullException(String parameter) {
        super(parameter + " не может иметь значение null!");
    }

    public NullException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullException(Throwable cause) {
        super(cause);
    }
}
