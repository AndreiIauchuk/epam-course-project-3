package by.epamtc.iovchuk.service;

import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.util.ArrayCheckUtility;

/**
 * Сервис для поиска значений в массиве.
 */
public class ArraySearchService {

    /**
     * Находит индекс элемента массива с указанным значением.
     *
     * @param array массив для поиска элемента
     * @param value искомое значение элемента массива
     * @return индекс искомого элемента массива
     * @throws NullException если ссылка на массив указывает на null
     */
    public int indexOf(int[] array, int value) throws NullException {
        ArrayCheckUtility.checkNull(array);
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        return binarySearch(array, value, leftIndex, rightIndex);

    }

    /**
     * Реализация бинарного поиска для поиска элемента
     * с указанным значением в указанном диапазоне.
     *
     * @param array      массив для поиска элемента
     * @param value      искомое значение элемента массива
     * @param leftIndex  индекс первого элемента диапазона
     * @param rightIndex индекс последнего элемента диапазона
     * @return индекс искомого элемента массива;
     * -1, если массив не содержит искомого элемента
     */
    private int binarySearch(int[] array, int value, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            if (array[leftIndex] == value) {
                return leftIndex;
            } else {
                return -1;
            }
        }

        int midIndex = (leftIndex + rightIndex) / 2;

        if (array[midIndex] == value) {
            return midIndex;
        } else if (array[midIndex] > value) {
            return binarySearch(array, value, leftIndex, midIndex - 1);
        } else {
            return binarySearch(array, value, midIndex + 1, rightIndex);
        }
    }
}