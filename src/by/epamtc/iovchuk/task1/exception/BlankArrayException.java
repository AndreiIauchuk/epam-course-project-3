package by.epamtc.iovchuk.task1.exception;

public class BlankArrayException extends Exception{

    public BlankArrayException() {
        super("Указан пустой массив!");
    }

    public BlankArrayException(String parameter) {
        super(parameter);
    }

    public BlankArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlankArrayException(Throwable cause) {
        super(cause);
    }
}
