package by.epamtc.iovchuk;

import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.service.ArraySearchService;
import by.epamtc.iovchuk.service.ArraySortService;
import com.sun.beans.finder.ClassFinder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        int[] array = new int[]{5, 3, 2, 1, 7, 4, 2, 5, -4, 2, -54, 424};
        //int[] array = new int[]{2, 3, 4, 1};
        int[] singleValueArray = new int[]{1};
        int[] nullArray = null;
        int[] blankArray = new int[]{};

        testSort(array);

        for (int value : array) {
            System.out.print(value + ", ");
        }

        ArraySearchService arraySearchService = new ArraySearchService();
        try {
            int index = arraySearchService.indexOf(array, 4244);
            System.out.println("FIND index = " + index);
        } catch (NullException e) {
            e.printStackTrace();
        }

    }

    static private void testSort(int[] array) {

        System.out.print("МАССИВ ИЗНАЧАЛЬНО - ");
        for (int value : array) {
            System.out.print(value + ", ");
        }

        System.out.println("\n");

        ArraySortService arraySortService = new ArraySortService();

        try {
            arraySortService.quickSort(array);
        } catch (NullException e) {
            e.printStackTrace();
            return;
        }
    }
}
