package by.epamtc.iovchuk.task1.service;

import by.epamtc.iovchuk.task1.util.ArrayUtil;
import by.epamtc.iovchuk.task1.validator.ArrayValidator;

import java.util.LinkedList;
import java.util.List;

/**
 * Сервис для поиска значений в массиве.
 */
public class ArraySearchService {

    private final ArrayValidator arrayValidator = new ArrayValidator();

    /**
     * Находит индекс элемента массива с указанным значением
     * методом бинарного поиска.
     *
     * @param array массив для поиска элемента
     * @param value искомое значение элемента массива
     * @return индекс искомого элемента массива,
     * либо -1, если массив не содержит элемент с
     * указанным значением
     */
    public int binarySearch(int[] array, int value) {
        if (arrayValidator.checkNull(array) ||
                arrayValidator.checkBlank(array)) {
            return -1;
        }

        if (arrayValidator.checkSingleElement(array)) {
            return searchInSingleElementArray(array, 0, value);
        }

        int leftIndex = 0;
        int rightIndex = array.length - 1;

        return binarySearch(array, value, leftIndex, rightIndex);
    }

    /**
     * Находит индекс элемента массива с указанным значением
     * методом бинарного поиска в указанном диапазоне.
     *
     * @param array      массив для поиска элемента
     * @param value      искомое значение элемента массива
     * @param leftIndex  индекс первого элемента диапазона
     * @param rightIndex индекс последнего элемента диапазона
     * @return индекс искомого элемента массива,
     * либо -1, если массив не содержит искомого элемента
     */
    public int binarySearch(int[] array, int value, int leftIndex, int rightIndex) {
        if (arrayValidator.checkNull(array) ||
                arrayValidator.checkBlank(array)) {
            return -1;
        }

        if (leftIndex >= rightIndex) {
           return searchInSingleElementArray(array, leftIndex, value);
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

    private int searchInSingleElementArray(int[] array, int index, int value) {
        int resultIndex = -1;

        if (array[index] == value) {
            resultIndex = index;
        }

        return resultIndex;
    }

    /**
     * Находит индекса элемента с максимальным значением в массиве.
     *
     * @param array массив для поиска элемента
     * @return индекса элемента с максимальным значением,
     * либо -1, если ссылка указывает на null или пустой массив
     */
    public int findMaxValue(int[] array) {
        if (arrayValidator.checkNull(array) ||
                arrayValidator.checkBlank(array)) {
            return -1;
        }

        if (arrayValidator.checkSingleElement(array)) {
            return array[0];
        }

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
     * @return индекса элемента с минимальным значением,
     * либо -1, если ссылка указывает на null или пустой массив
     */
    public int findMinValue(int[] array) {
        if (arrayValidator.checkNull(array) ||
                arrayValidator.checkBlank(array)) {
            return -1;
        }

        if (arrayValidator.checkSingleElement(array)) {
            return array[0];
        }

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
     * @return массив простых чисел,
     * либо null, если ссылка указывает на null или пустой массив
     */
    public int[] findPrimeNumbers(int[] array) {
        if (arrayValidator.checkNull(array) ||
                arrayValidator.checkBlank(array)) {
            return null;
        }

        List<Integer> primeNumbersList = new LinkedList<>();

        for (int value : array) {
            if (isPrimeNumber(value)) {
                primeNumbersList.add(value);
            }
        }

        return ArrayUtil.listToArray(primeNumbersList);
    }

    /**
     * Проверяет, является ли число простым.
     *
     * @param value число для проверки
     * @return true, если число является простым
     */
    private boolean isPrimeNumber(int value) {
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

    /**
     * Возвращает массив всех чисел Фибоначчи в указанном массиве.
     *
     * @param array массив для поиска чисел Фибоначчи
     * @return массив простых чисел,
     * либо null, если ссылка указывает на null или пустой массив
     */
    public int[] findFibonacciNumbers(int[] array) {
        if (arrayValidator.checkNull(array) ||
                arrayValidator.checkBlank(array)) {
            return null;
        }

        List<Integer> fibonacciNumbersList = new LinkedList<>();

        for (int value : array) {
            if (isFibonacciNumber(value)) {
                fibonacciNumbersList.add(value);
            }
        }

        return ArrayUtil.listToArray(fibonacciNumbersList);
    }

    /**
     * Проверяет, является ли число числом Фибоначчи.
     *
     * @param value число для проверки
     * @return true, если число является числом Фибоначчи
     */
    private boolean isFibonacciNumber(int value) {
        if (value < 0) {
            return false;
        }

        if (value == 0 || value == 1) {
            return true;
        }

        int prev = 1;
        int current = 2;

        while (current < value) {
            int temp = current;
            current = current + prev;
            prev = temp;
        }

        return current == value;
    }

    /**
     * Возвращает массив всех трехзначных чисел в указанном массиве,
     * в десятичной записи которых нет одинаковых цифр.
     *
     * @param array массив для поиска чисел Фибоначчи
     * @return массив простых чисел,
     * либо null, если ссылка указывает на null или пустой массив
     */
    public int[] findUniqueThreeDigitNumbers(int[] array) {
        if (arrayValidator.checkNull(array) ||
                arrayValidator.checkBlank(array)) {
            return null;
        }

        List<Integer> threeDigitNumbersList = new LinkedList<>();

        for (int value : array) {
            if (isUniqueThreeDigitNumber(value)) {
                threeDigitNumbersList.add(value);
            }
        }

        return ArrayUtil.listToArray(threeDigitNumbersList);

    }

    /**
     * Проверяет, является ли указанное число трехзначным числом,
     * в десятичной записи которого нет одинаковых цифр.
     *
     * @param value число для проверки
     * @return true, если число трехзначное
     */
    private boolean isUniqueThreeDigitNumber(int value) {
        if (isThreeDigitNumber(value)) {
            return checkDigitUniqueness(value);
        }

        return false;
    }

    /**
     * Проверяет, является ли число трехзначным.
     *
     * @param value число для проверки
     * @return true, если число трехзначное
     */
    private boolean isThreeDigitNumber(int value) {
        return (100 <= value) && (value <= 999);
    }

    /**
     * Проверяет указанное число на уникальность цифр.
     *
     * @param value число для проверки
     * @return true, если все цифры числа уникальны
     */
    private boolean checkDigitUniqueness(int value) {
        int firstDigit = value / 100;
        int secondDigit = value / 10 % 10;
        int thirdDigit = value % 10;

        return firstDigit != secondDigit
                && firstDigit != thirdDigit
                && secondDigit != thirdDigit;
    }
}
