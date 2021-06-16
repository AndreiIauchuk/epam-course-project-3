package by.epamtc.iovchuk.task1.filler;

import by.epamtc.iovchuk.task1.exception.NullException;
import by.epamtc.iovchuk.task1.util.CheckUtil;

/**
 * Класс для заполнения массива случайными значениями.
 */
public class RandomArrayFiller extends ArrayFiller {

    @Override
    public void fillArray(int[] array) throws NullException {
        CheckUtil.checkNull(array, "Массив");
        int arrayLength = array.length;
        for (int index = 0; index < arrayLength; index++) {
            array[index] = randomizeValue();
        }
    }

    private int randomizeValue() {
        return (int) ((Math.random() * Integer.MAX_VALUE) + Integer.MIN_VALUE / 2);
    }
}
