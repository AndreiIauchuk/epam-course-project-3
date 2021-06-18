package by.epamtc.iovchuk.task1;

import by.epamtc.iovchuk.task1.exception.NullException;
import by.epamtc.iovchuk.task1.filler.ArrayFiller;
import by.epamtc.iovchuk.task1.filler.ConsoleArrayFiller;
import by.epamtc.iovchuk.task1.filler.FileArrayFiller;
import by.epamtc.iovchuk.task1.filler.RandomArrayFiller;
import by.epamtc.iovchuk.task1.service.ArraySearchService;
import by.epamtc.iovchuk.task1.util.ArrayUtil;
import by.epamtc.iovchuk.task1.wrapper.IntArrayWrapper;

import java.io.FileNotFoundException;

/**
 * Создание типа Array, который является классом оболочкой над массивом целого типа. В данном типе должны быть реализованы конструкторы (позволяющие несколькими способами создавать объекты типа), get-ы, set-ы и переопределенные методы класса Object (toString(), equals(), hasCode()).
 * Программа должна иметь следующие возможности:
 * <p>
 * 1. Сортировать массив тремя способами.
 * </p>
 * <p>
 * 2. Осуществлять поиск элемента массива (использовать алгоритм бинарного поиска).
 * </p>
 * <p>
 * 3. Нахождение максимального и минимального элемента массива.
 * </p>
 * <p>
 * 4. Получить все простые числа находящиеся в массиве.
 * </p>
 * <p>
 * 5. Получить все числа Фибонначчи находящиеся в массиве.
 * </p>
 * <p>
 * 6. Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
 * </p>
 * <p>
 * 7. Заполнения элементов массива и с консоли, и с файла и с помощью генерации случайных чисел.
 * </p>
 *
 * @author Иовчук Андрей
 */
public class Main {

    static private ArraySearchService arraySearchService = new ArraySearchService();

    public static void main(String[] args) {

        String arrayValuesStr = "5, 1, 0, -51, 107, 75, 4, -5, 443, -15, 95, 279, 6, 9";

        IntArrayWrapper intArrayWrapper = new IntArrayWrapper(arrayValuesStr);

        printSortedArray(intArrayWrapper);
        printElementIndex(intArrayWrapper, 107);
        printMinValue(intArrayWrapper);
        printMaxValue(intArrayWrapper);
        printPrimeNumbers(intArrayWrapper);
        printFibonacciNumbers(intArrayWrapper);
        printUniqueThreeDigitNumbers(intArrayWrapper);

        System.out.println("\n");

        printConsoleFilledArray();
        printFileFilledArray();
        printRandomFilledArray();
    }

    static private void printSortedArray(IntArrayWrapper intArrayWrapper) {
        intArrayWrapper.sort();

        System.out.println("Отсортированный массив : "
                + ArrayUtil.arrayToString(intArrayWrapper.getIntArray()));
    }

    static private void printElementIndex(IntArrayWrapper intArrayWrapper, int value) {
        int foundElement;
        foundElement = intArrayWrapper.indexOf(value);

        System.out.println("Индекс элемента с указанным значением : " + foundElement);
    }

    static private void printMinValue(IntArrayWrapper intArrayWrapper) {
        int minValue;
        minValue = arraySearchService.findMinValue(intArrayWrapper.getIntArray());

        System.out.println("Минимальное значение в массиве : " + minValue);
    }

    static private void printMaxValue(IntArrayWrapper intArrayWrapper) {
        int maxValue;
        maxValue = arraySearchService.findMaxValue(intArrayWrapper.getIntArray());

        System.out.println("Максимальное значение в массиве : " + maxValue);
    }

    static private void printPrimeNumbers(IntArrayWrapper intArrayWrapper) {
        int[] primeNumbers;
        primeNumbers = arraySearchService
                .findPrimeNumbers(intArrayWrapper.getIntArray());

        System.out.println("Массив простых чисел : "
                + ArrayUtil.arrayToString(primeNumbers));
    }

    static private void printFibonacciNumbers(IntArrayWrapper intArrayWrapper) {
        int[] fibonacciNumbers;
        fibonacciNumbers = arraySearchService
                .findFibonacciNumbers(intArrayWrapper.getIntArray());

        System.out.println("Массив чисел Фибоначчи : "
                + ArrayUtil.arrayToString(fibonacciNumbers));
    }

    static private void printUniqueThreeDigitNumbers(IntArrayWrapper intArrayWrapper) {
        int[] uniqueThreeDigitNumbers;
        uniqueThreeDigitNumbers = arraySearchService
                .findUniqueThreeDigitNumbers(intArrayWrapper.getIntArray());

        System.out.println("Массив трехзначных числел, " +
                "в десятичной записи которых нет одинаковых цифр : "
                + ArrayUtil.arrayToString(uniqueThreeDigitNumbers));
    }

    static private void printConsoleFilledArray() {
        ConsoleArrayFiller consoleArrayFiller = new ConsoleArrayFiller();
        printFilledArray(consoleArrayFiller);
    }

    static private void printFileFilledArray() {
        ArrayFiller fileArrayFiller;
        try {
            fileArrayFiller = new FileArrayFiller("D:\\ArrayValues.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        printFilledArray(fileArrayFiller);
    }

    static private void printRandomFilledArray() {
        ArrayFiller randomArrayFiller = new RandomArrayFiller();
        printFilledArray(randomArrayFiller);
    }

    static private void printFilledArray(ArrayFiller arrayFiller) {
        int[] a = new int[5];
        try {
            arrayFiller.fillArray(a);
        } catch (NullException e) {
            e.printStackTrace();
        }
        System.out.println(ArrayUtil.arrayToString(a));
    }
}
