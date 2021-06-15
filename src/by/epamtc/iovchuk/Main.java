package by.epamtc.iovchuk;

import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.exception.OutBoundsException;
import by.epamtc.iovchuk.filler.ArrayFiller;
import by.epamtc.iovchuk.filler.ConsoleArrayFiller;
import by.epamtc.iovchuk.filler.FileArrayFiller;
import by.epamtc.iovchuk.filler.RandomArrayFiller;
import by.epamtc.iovchuk.service.ArraySortService;

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
        //ТЕСТ
        int[] array = new int[]{5, 3, 2, 1, 7, 4, 2, 5, -4, 2, 89, 579, 200, 132, 6765, 6442, -54, 424, 41, 14, 24, 13, 14};
        //int[] array = new int[]{2, 3, 4, 1};
        int[] singleValueArray = new int[]{1};
        int[] nullArray = null;
        int[] blankArray = new int[]{};

        String str = "1, 5, 2, 5, -2, 6, 25, 25, 11, 525, 64, 13, 234, 1, 5, 25, 25, 1, 16, 12, 1, 4";

        IntArrayWrapper intArrayWrapper = null;

        try {
            intArrayWrapper = new IntArrayWrapper(str);
        } catch (NullException e) {
            e.printStackTrace();
            return;
        }

        intArrayWrapper.add(-123456,3);

        int elem = 0;

        try {
            intArrayWrapper.remove(5);
            elem = intArrayWrapper.getElement(5);
            intArrayWrapper.setElement(0, 10000);
        } catch (OutBoundsException e) {
            e.printStackTrace();
            return;
        }

        System.out.println(intArrayWrapper);
        System.out.println("\n " + elem);

        System.out.println("intArrayWrapper.getLength() = " + intArrayWrapper.getLength());
        System.out.println("intArrayWrapper.getCapacity() = " + intArrayWrapper.getCapacity());

        /*testSort(array);

        for (int value : array) {
            System.out.print(value + ", ");
        }
        System.out.println("\n");

      *//*  ArraySearchService arraySearchService = new ArraySearchService();
        try {
            int foundValue =  arraySearchService.indexOf(array, 4);
            int minValue = arraySearchService.findMinValue(array);
            int maxValue = arraySearchService.findMaxValue(array);
            int[] primeNumbers = arraySearchService.findPrimeNumbers(array);
            int[] fibonacciNumbers = arraySearchService.findFibonacciNumbers(array);
            int[] uniqueThreeDigitNumbers = arraySearchService.findUniqueThreeDigitNumbers(array);

            //System.out.println("minValue = " + minValue);
            //System.out.println("maxValue = " + maxValue);

            System.out.println("\n");

            for (int value : uniqueThreeDigitNumbers) {
                System.out.print(value + ", ");
            }
        } catch (NullException | BlankArrayException e) {
            e.printStackTrace();
        }*//*

        int[] a = new int[5];
        ArrayFiller consoleArrayFiller = new FileArrayFiller();
        consoleArrayFiller.fillArray(a);

        for (int value : a) {
            System.out.print(value + ", ");
        }*/
    }

    static private void testSort(int[] array) {
        ArraySortService arraySortService = new ArraySortService();

        try {
            arraySortService.quickSort(array);
        } catch (NullException e) {
            e.printStackTrace();
        }
    }
}
