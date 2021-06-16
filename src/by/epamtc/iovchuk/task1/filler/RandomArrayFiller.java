package by.epamtc.iovchuk.task1.filler;

/**
 * Класс для заполнения массива случайными значениями.
 */
public class RandomArrayFiller extends ArrayFiller {

    @Override
    public void fillArray(int[] array) {
        int arrayLength = array.length;
        for (int index = 0; index < arrayLength; index++) {
            array[index] = randomizeValue();
        }
    }

    private int randomizeValue() {
        return (int) ((Math.random() * Integer.MAX_VALUE) + Integer.MIN_VALUE / 2);
    }
}
