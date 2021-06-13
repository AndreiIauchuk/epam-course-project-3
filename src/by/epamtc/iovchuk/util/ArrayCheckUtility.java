package by.epamtc.iovchuk.util;

import by.epamtc.iovchuk.exception.NullException;

public class ArrayCheckUtility {

    private ArrayCheckUtility() {}

    /**
     * Проверяет, указывает ли ссылолчная переменная массива на null.
     *
     * @param array массив для проверки на null
     * @throws NullException если ссылка указывает на null
     */
    static public void checkNull(int[] array) throws NullException {
        if (array == null) {
            throw new NullException("Массив");
        }
    }
}
