package by.epamtc.iovchuk.task2.service;

import by.epamtc.iovchuk.task1.exception.NullException;
import by.epamtc.iovchuk.task1.util.CheckUtil;

public class JaggedArraySortService {

    /**
     * Сортирует непрямоугольный целочисленный массив
     * по сумме элементов строк пузырьковым методом.
     *
     * @param jaggedArray непрямоугольный массив для сортировки
     * @throws NullException если ссылка на массив указывает на null
     */
    public void rowValuesSumSort(int[][] jaggedArray) throws NullException {
        sort(jaggedArray, "rowValuesSum");
    }

    /**
     * Сортирует непрямоугольный целочисленный массив
     * по максимальному значению элемента строк пузырьковым методом.
     *
     * @param jaggedArray непрямоугольный массив для сортировки
     * @throws NullException если ссылка на массив указывает на null
     */
    public void rowMaxValueSort(int[][] jaggedArray) throws NullException {
        sort(jaggedArray, "maxValue");
    }

    /**
     * Сортирует непрямоугольный целочисленный массив
     * по минимальному значению элемента строк пузырьковым методом.
     *
     * @param jaggedArray непрямоугольный массив для сортировки
     * @throws NullException если ссылка на массив указывает на null
     */
    public void rowMinValueSort(int[][] jaggedArray) throws NullException {
        sort(jaggedArray, "minValue");
    }

    private void sort(int[][] jaggedArray, String sortBy) throws NullException {
        CheckUtil.checkNull(jaggedArray, "Непрямоугольный массив");
        int jaggedArrayLength = jaggedArray.length;

        if (CheckUtil.checkSmallArrayLength(jaggedArrayLength)) {
            return;
        }

        for (int outIndex = jaggedArrayLength - 1; outIndex > 0; --outIndex) {
            for (int inIndex = 0; inIndex < outIndex; ++inIndex) {
                switch (sortBy) {
                    case "rowValuesSum":
                        if (calcRowValuesSum(jaggedArray[inIndex]) > calcRowValuesSum(jaggedArray[inIndex + 1])) {
                            swapRows(jaggedArray, inIndex, inIndex + 1);
                        }
                        break;

                    case "maxValue":
                        if (defineRowMaxValue(jaggedArray[inIndex]) > defineRowMaxValue(jaggedArray[inIndex + 1])) {
                            swapRows(jaggedArray, inIndex, inIndex + 1);
                        }
                        break;

                    case "minValue":
                        if (defineRowMinValue(jaggedArray[inIndex]) > defineRowMinValue(jaggedArray[inIndex + 1])) {
                            swapRows(jaggedArray, inIndex, inIndex + 1);
                        }
                        break;

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
    public void invert(int[][] jaggedArray) throws NullException {
        CheckUtil.checkNull(jaggedArray, "Непрямоугольный массив");
        int jaggedArrayLength = jaggedArray.length;

        if (CheckUtil.checkSmallArrayLength(jaggedArrayLength)) {
            return;
        }

        int[] tempRow;
        for (int i = 0; i < jaggedArrayLength / 2; i++) {
            tempRow = jaggedArray[i];
            jaggedArray[i] = jaggedArray[jaggedArrayLength - 1 - i];
            jaggedArray[jaggedArrayLength - 1 - i] = tempRow;
        }
    }

    private int calcRowValuesSum(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return sum;
    }

    private int defineRowMaxValue(int[] row) {
        int maxValue = row[0];
        for (int value : row) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    private int defineRowMinValue(int[] row) {
        int minValue = row[0];
        for (int value : row) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

}
