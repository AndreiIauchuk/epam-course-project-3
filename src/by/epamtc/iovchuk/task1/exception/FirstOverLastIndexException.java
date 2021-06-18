package by.epamtc.iovchuk.task1.exception;

public class FirstOverLastIndexException extends Exception {

    public FirstOverLastIndexException() {
        super("Минимальный индекс диапазона больше максимального!");
    }

    public FirstOverLastIndexException(String message) {
        super(message);
    }

    public FirstOverLastIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public FirstOverLastIndexException(Throwable cause) {
        super(cause);
    }
}
