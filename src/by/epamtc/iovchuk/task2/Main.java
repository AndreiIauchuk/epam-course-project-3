package by.epamtc.iovchuk.task2;

import by.epamtc.iovchuk.task1.exception.NullException;
import by.epamtc.iovchuk.task2.service.JaggedArraySortService;

/**
 * Дан непрямоугольный целочисленный массив (jagged array). Реализовать алгоритм
 * "пузырьковой" сортировки, таким образом, чтобы была возможность упорядочить строки
 * матрицы:
 * <p>
 * • в порядке возрастания (убывания) сумм элементов строк матрицы;
 * </p>
 * <p>
 * • в порядке возрастания (убывания) максимальных элементов строк матрицы;
 * </p>
 * <p>
 * • в порядке возрастания (убывания) минимальных элементов строк матрицы.
 * </p>
 *
 * @author Иовчук Андрей
 */
public class Main {

    static private JaggedArraySortService jaggedArraySortService = new JaggedArraySortService();

    public static void main(String[] args) {
        int[][] jaggedArray = new int[5][];

        jaggedArray[0] = new int[]{1, 2, 3, 4, 5};
        jaggedArray[1] = new int[]{1, 7};
        jaggedArray[2] = new int[]{2, 3, 4, 5, 6};
        jaggedArray[3] = new int[]{3, 3};
        jaggedArray[4] = new int[]{10};

        printSortedRowValuesSum(jaggedArray);
        printSortedRowMaxValue(jaggedArray);
        printSortedRowMinValue(jaggedArray);

    }

    static private void printSortedRowValuesSum(int[][] jaggedArray) {
        System.out.println("Непрямоугольный целочисленный массив " +
                "в порядке возрастания сумм элементов строк:");
        try {
            jaggedArraySortService.rowValuesSumSort(jaggedArray);
        } catch (NullException e) {
            e.printStackTrace();
        }

        printJaggedArray(jaggedArray);
    }

    static private void printSortedRowMaxValue(int[][] jaggedArray) {
        System.out.println("Непрямоугольный целочисленный массив " +
                "в порядке возрастания максимальных элементов строк:");
        try {
            jaggedArraySortService.rowMaxValueSort(jaggedArray);
        } catch (NullException e) {
            e.printStackTrace();
        }

        printJaggedArray(jaggedArray);
    }

    static private void printSortedRowMinValue(int[][] jaggedArray) {
        System.out.println("Непрямоугольный целочисленный массив " +
                "в порядке возрастания минимальных элементов строк:");
        try {
            jaggedArraySortService.rowMinValueSort(jaggedArray);
        } catch (NullException e) {
            e.printStackTrace();
        }

        printJaggedArray(jaggedArray);
    }

    static private void printJaggedArray(int[][] jaggedArray) {
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(" " + jaggedArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
