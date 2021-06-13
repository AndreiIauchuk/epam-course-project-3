package by.epamtc.iovchuk.util;

import by.epamtc.iovchuk.exception.BlankArrayException;
import by.epamtc.iovchuk.exception.NullException;

public class ArrayCheckUtil {

    private ArrayCheckUtil() {}

    /**
     * Проверяет, указывает ли ссылочная переменная массива на null.
     *
     * @param array массив для проверки на null
     * @throws NullException если ссылка указывает на null
     */
    static public void checkNull(int[] array) throws NullException {
        if (array == null) {
            throw new NullException("Массив");
        }
    }

    /**
     * Проверяет, является ли указанный массив пустым.
     *
     * @param array массив для проверки на null
     * @throws BlankArrayException если указанный массив пустой
     */
    static public void checkBlank(int[] array) throws BlankArrayException {
        if (array.length == 0) {
            throw new BlankArrayException();
        }
    }
}
