package by.epamtc.iovchuk.task2.service;

import by.epamtc.iovchuk.task1.validator.JaggedArrayValidator;
import by.epamtc.iovchuk.task2.comparator.ArrayByMaxValueComparator;
import by.epamtc.iovchuk.task2.comparator.ArrayByMinValueComparator;
import by.epamtc.iovchuk.task2.comparator.ArrayByValuesSumComparator;

import java.util.Comparator;

public class JaggedArraySortService {

    private JaggedArrayValidator jaggedArrayValidator = new JaggedArrayValidator();

    /**
     * Сортирует непрямоугольный целочисленный массив
     * по сумме элементов строк пузырьковым методом.
     *
     * @param jaggedArray непрямоугольный массив для сортировки
     */
    public void rowValuesSumSort(int[][] jaggedArray) {
        sort(jaggedArray, new ArrayByValuesSumComparator());
    }

    /**
     * Сортирует непрямоугольный целочисленный массив
     * по максимальному значению элемента строк пузырьковым методом.
     *
     * @param jaggedArray непрямоугольный массив для сортировки
     */
    public void rowMaxValueSort(int[][] jaggedArray) {
        sort(jaggedArray, new ArrayByMaxValueComparator());
    }

    /**
     * Сортирует непрямоугольный целочисленный массив
     * по минимальному значению элемента строк пузырьковым методом.
     *
     * @param jaggedArray непрямоугольный массив для сортировки
     */
    public void rowMinValueSort(int[][] jaggedArray) {
        sort(jaggedArray, new ArrayByMinValueComparator());
    }

    private void sort(int[][] jaggedArray, Comparator<Object> arrayComparator) {
        if (jaggedArrayValidator.checkNull(jaggedArray)
                || jaggedArrayValidator.checkBlank(jaggedArray)
                || jaggedArrayValidator.checkSingleRow(jaggedArray)) {
            return;
        }

        int jaggedArrayLength = jaggedArray.length;

        for (int outIndex = jaggedArrayLength - 1; outIndex > 0; --outIndex) {
            for (int inIndex = 0; inIndex < outIndex; ++inIndex) {

                if (arrayComparator.compare(jaggedArray[inIndex], jaggedArray[inIndex + 1]) == 1) {
                    swapRows(jaggedArray, inIndex, inIndex + 1);
                }
            }
        }

    }

    private void swapRows(int[][] jaggedArray,
                          int firstRowIndex,
                          int secondRowIndex) {

        int[] tempRow = jaggedArray[firstRowIndex];
        jaggedArray[firstRowIndex] = jaggedArray[secondRowIndex];
        jaggedArray[secondRowIndex] = tempRow;
    }

    /**
     * "Переворачивает" непрямоугольный целочисленный массив.
     */
    public void invert(int[][] jaggedArray) {
        if (jaggedArrayValidator.checkNull(jaggedArray)
                || jaggedArrayValidator.checkBlank(jaggedArray)
                || jaggedArrayValidator.checkSingleRow(jaggedArray)) {
            return;
        }

        int jaggedArrayLength = jaggedArray.length;

        int[] tempRow;
        for (int i = 0; i < jaggedArrayLength / 2; i++) {
            tempRow = jaggedArray[i];
            jaggedArray[i] = jaggedArray[jaggedArrayLength - 1 - i];
            jaggedArray[jaggedArrayLength - 1 - i] = tempRow;
        }
    }

}