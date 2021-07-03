package by.epamtc.iovchuk.task1.filler;

import by.epamtc.iovchuk.task1.exception.NullException;
import by.epamtc.iovchuk.task1.validator.ArrayValidator;

/**
 * Абстрактный класс для заполнения массива значениями.
 */
public abstract class ArrayFiller {

    private final ArrayValidator arrayValidator = new ArrayValidator();

    abstract public void fillArray(int[] array) throws NullException;

    public void checkNull(int[] array) throws NullException {
        if (arrayValidator.checkNull(array)) {
            throw new NullException("Массив");
        }
    }
}
