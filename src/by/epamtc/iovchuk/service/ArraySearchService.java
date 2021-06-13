package by.epamtc.iovchuk.service;

import by.epamtc.iovchuk.exception.BlankArrayException;
import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.util.ArrayCheckUtility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    public int indexOf(int[] array, int value) throws NullException, BlankArrayException {
        checkNullOrBlankArray(array);
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


    /**
     * Находит индекса элемента с максимальным значением в массиве.
     *
     * @param array массив для поиска элемента
     * @return индекса элемента с максимальным значением
     * @throws NullException если ссылка на массив указывает на null
     */
    public int findMaxValue(int[] array) throws NullException, BlankArrayException {
        checkNullOrBlankArray(array);
        int maxValue = array[0];
        for (int index = 1; index < array.length; index++) {
            if (array[index] > maxValue) {
                maxValue = array[index];
            }
        }
        return maxValue;
    }

    /**
     * Находит индекса элемента с минимальным значением в массиве.
     *
     * @param array массив для поиска элемента
     * @return индекса элемента с минимальным значением
     * @throws NullException если ссылка на массив указывает на null
     */
    public int findMinValue(int[] array) throws NullException, BlankArrayException {
        checkNullOrBlankArray(array);
        int minValue = array[0];
        for (int index = 1; index < array.length; index++) {
            if (array[index] < minValue) {
                minValue = array[index];
            }
        }
        return minValue;
    }

    /**
     * Возвращает массив всех простых чисел в указанном массиве.
     *
     * @param array массив для поиска простых чисел
     * @return массив простых чисел
     */
    public int[] findPrimeNumbers(int[] array) {
        List<Integer> primeNumbersList = new LinkedList<>();
        for (int i : array) {
            if (checkPrimeNumber(i)) {
                primeNumbersList.add(i);
            }
        }

        int primeNumbersListSize = primeNumbersList.size();

        System.out.println("primeNumbersListSize = " + primeNumbersListSize);

        int[] primeNumbers = new int[primeNumbersListSize];

        for (int index = 0; index < primeNumbersListSize; index++) {
            primeNumbers[index] = primeNumbersList.get(index);
        }

        return primeNumbers;
    }

    /**
     * Проверяет, является ли число простым.
     *
     * @param value число
     * @return true, если число является простым
     */
    private boolean checkPrimeNumber(int value) {
        if (value <= 1) {
            return false;
        }

        if (value == 2
                || value == 3
                || value == 5
                || value == 7) {
            return true;
        }

        return value % 2 != 0
                && value % 3 != 0
                && value % 5 != 0
                && value % 7 != 0;
    }

    private void checkNullOrBlankArray(int[] array) throws NullException, BlankArrayException {
        ArrayCheckUtility.checkNull(array);
        ArrayCheckUtility.checkBlank(array);
    }
}
