package by.epamtc.iovchuk.task1.util;

import by.epamtc.iovchuk.task1.exception.BlankArrayException;
import by.epamtc.iovchuk.task1.exception.NullException;
import by.epamtc.iovchuk.task1.exception.OutBoundsException;

public class CheckUtil {

    private CheckUtil() {}

    /**
     * Проверяет, указывает ли ссылочная переменная на null.
     *
     * @param obj ссылочная переменная для проверки на null
     * @param name наименование сущности
     * @throws NullException если ссылка указывает на null
     */
    static public void checkNull(Object obj, String name) throws NullException {
        if (obj == null) {
            throw new NullException(name);
        }
    }

    /**
     * Проверяет, является ли указанный массив пустым.
     *
     * @param array массив для проверки на null
     * @throws BlankArrayException если указанный массив пустой
     */
    static public void checkBlankArray(int[] array) throws BlankArrayException {
        if (array.length == 0) {
            throw new BlankArrayException();
        }
    }


    /**
     * Проверяет, равна ли нулю или единице указанная длина массива.
     *
     * @param arrayLength длина массива
     * @return true, если длина массива равна нулю или единице
     */
    static public boolean checkSmallArrayLength(int arrayLength) {
        return arrayLength == 0 || arrayLength == 1;
    }

    static public void checkOutOfBoundsArray( int index, int arrayLength)
            throws OutBoundsException {

        if (index >= arrayLength || index < 0) {
            throw new OutBoundsException();
        }
    }
}
