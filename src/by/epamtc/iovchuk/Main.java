package by.epamtc.iovchuk;

import by.epamtc.iovchuk.exception.BlankArrayException;
import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.filler.ArrayFiller;
import by.epamtc.iovchuk.filler.ConsoleArrayFiller;
import by.epamtc.iovchuk.filler.FileArrayFiller;
import by.epamtc.iovchuk.filler.RandomArrayFiller;
import by.epamtc.iovchuk.service.ArraySearchService;
import by.epamtc.iovchuk.util.ArrayUtil;
import by.epamtc.iovchuk.wrapper.IntArrayWrapper;

import java.io.FileNotFoundException;

/**
 * Создание типа Array, который является классом оболочкой над массивом целого типа. В данном типе должны быть реализованы конструкторы (позволяющие несколькими способами создавать объекты типа), get-ы, set-ы и переопределенные методы класса Object (toString(), equals(), hasCode()).
 * Программа должна иметь следующие возможности:
 * 1. Сортировать массив тремя способами.
 * 2. Осуществлять поиск элемента массива (использовать алгоритм бинарного поиска).
 * 3. Нахождение максимального и минимального элемента массива.
 * 4. Получить все простые числа находящиеся в массиве.
 * 5. Получить все числа Фибонначчи находящиеся в массиве.
 * 6. Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
 * 7. Заполнения элементов массива и с консоли, и с файла и с помощью генерации случайных чисел.
 *
 * @author Иовчук Андрей
 */
public class Main {

    public static void main(String[] args) {

        String arrayValuesStr = "5, 1, 0, -51, 107, 75, 4, -5, 443, -15, 95, 279, 6, 9";
        IntArrayWrapper intArrayWrapper = new IntArrayWrapper(arrayValuesStr);

        printSortedArray(intArrayWrapper);
        printElementIndex(intArrayWrapper, 75);
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
        try {
            intArrayWrapper.sort();
        } catch (NullException e) {
            e.printStackTrace();
        }

        System.out.println("Отсортированный массив : "
                + ArrayUtil.arrayToString(intArrayWrapper.getArrayCopy()));
    }

    static private void printElementIndex(IntArrayWrapper intArrayWrapper, int value) {
        int foundElement;
        try {
            foundElement = intArrayWrapper.indexOf(75);
        } catch (BlankArrayException e) {
            e.printStackTrace();
            return;
        } catch (NullException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Индекс элемента с указанным значением : " + foundElement);
    }

    static private void printMinValue(IntArrayWrapper intArrayWrapper) {
        ArraySearchService arraySearchService = new ArraySearchService();
        int minValue;
        try {
            minValue = arraySearchService.findMinValue(intArrayWrapper.getArrayCopy());
        } catch (NullException e) {
            e.printStackTrace();
            return;
        } catch (BlankArrayException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Минимальное значение в массиве : " + minValue);
    }

    static private void printMaxValue(IntArrayWrapper intArrayWrapper) {
        ArraySearchService arraySearchService = new ArraySearchService();
        int maxValue;
        try {
            maxValue = arraySearchService.findMaxValue(intArrayWrapper.getArrayCopy());
        } catch (NullException e) {
            e.printStackTrace();
            return;
        } catch (BlankArrayException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Максимальное значение в массиве : " + maxValue);
    }

    static private void printPrimeNumbers(IntArrayWrapper intArrayWrapper) {
        ArraySearchService arraySearchService = new ArraySearchService();
        int[] primeNumbers;
        try {
            primeNumbers = arraySearchService
                    .findPrimeNumbers(intArrayWrapper.getArrayCopy());
        } catch (NullException e) {
            e.printStackTrace();
            return;
        } catch (BlankArrayException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Массив простых чисел : "
                + ArrayUtil.arrayToString(primeNumbers));
    }

    static private void printFibonacciNumbers(IntArrayWrapper intArrayWrapper) {
        ArraySearchService arraySearchService = new ArraySearchService();
        int[] fibonacciNumbers;
        try {
            fibonacciNumbers = arraySearchService
                    .findFibonacciNumbers(intArrayWrapper.getArrayCopy());
        } catch (NullException e) {
            e.printStackTrace();
            return;
        } catch (BlankArrayException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Массив чисел Фибоначчи : "
                + ArrayUtil.arrayToString(fibonacciNumbers));
    }

    static private void printUniqueThreeDigitNumbers(IntArrayWrapper intArrayWrapper) {
        ArraySearchService arraySearchService = new ArraySearchService();
        int[] uniqueThreeDigitNumbers;
        try {
            uniqueThreeDigitNumbers = arraySearchService
                    .findUniqueThreeDigitNumbers(intArrayWrapper.getArrayCopy());
        } catch (NullException e) {
            e.printStackTrace();
            return;
        } catch (BlankArrayException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Массив трехзначных числел, " +
                "в десятичной записи которых нет одинаковых цифр : "
                + ArrayUtil.arrayToString(uniqueThreeDigitNumbers));
    }

    static private void printConsoleFilledArray() {
        ConsoleArrayFiller consoleArrayFiller = new ConsoleArrayFiller();
        printFilledArray(consoleArrayFiller);
    }

    static private void printFileFilledArray() {
        ArrayFiller fileArrayFiller = null;
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
        arrayFiller.fillArray(a);
        System.out.println(ArrayUtil.arrayToString(a));
    }
}
