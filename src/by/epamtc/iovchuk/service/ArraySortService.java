package by.epamtc.iovchuk.service;

import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.util.CheckUtil;

/**
 * Сервис для сортировки массива.
 */
public class ArraySortService {

    /**
     * Сортировка массива методом выбора.
     *
     * @param array массив для сортировки
     * @throws NullException если ссылка на массив указывает на null
     */
    public void selectionSort(int[] array) throws NullException {
        CheckUtil.checkNull(array, "Массив");
        int arrayLength = array.length;
        if (CheckUtil.checkSmallArrayLength(arrayLength)) {
            return;
        }

        for (int outIndex = 0; outIndex < arrayLength; outIndex++) {

            int minElement = array[outIndex];
            int minElementIndex = outIndex;

            for (int inIndex = outIndex + 1; inIndex < arrayLength; inIndex++) {
                if (array[inIndex] < minElement) {
                    minElement = array[inIndex];
                    minElementIndex = inIndex;
                }
            }

            if (outIndex != minElementIndex) {
                swap(array, outIndex, minElementIndex);
            }
        }
    }

    /**
     * Сортировка массива методом пузырька.
     *
     * @param array массив для сортировки
     * @throws NullException если ссылка на массив указывает на null
     */
    public void bubbleSort(int[] array) throws NullException {
        CheckUtil.checkNull(array, "Массив");
        int arrayLength = array.length;
        if (CheckUtil.checkSmallArrayLength(arrayLength)) {
            return;
        }

        if (arrayLength == 0) {
            return;
        }

        for (int outIndex = arrayLength - 1; outIndex > 0; --outIndex) {
            for (int inIndex = 0; inIndex < outIndex; ++inIndex) {
                if (array[inIndex] > array[inIndex + 1]) {
                    swap(array, inIndex, inIndex + 1);
                }
            }
        }
    }

    /**
     * Меняет местами указанные элементы массива.
     *
     * @param firstElementIndex  индекс первого элемента
     * @param secondElementIndex индекс второго элемента
     */
    public void swap(int[] array,
                     int firstElementIndex,
                     int secondElementIndex) {

        int temp = array[firstElementIndex];
        array[firstElementIndex] = array[secondElementIndex];
        array[secondElementIndex] = temp;
    }


    /**
     * Сортировка массива методом быстрой сортировки.
     *
     * @param array массив для сортировки
     * @throws NullException если ссылка на массив указывает на null
     */
    public void quickSort(int[] array) throws NullException {
        CheckUtil.checkNull(array, "Массив");
        int arrayLength = array.length;
        if (CheckUtil.checkSmallArrayLength(arrayLength)) {
            return;
        }

        int firstElementIndex = 0;
        int lastElementIndex = array.length - 1;

        quickSortIterate(array, firstElementIndex, lastElementIndex);

    }

    private void quickSortIterate(int[] array,
                                  int firstElementIndex,
                                  int lastElementIndex) {
        int pivotValue = array[firstElementIndex];
        int leftIndex = firstElementIndex;
        int rightIndex = lastElementIndex;

        while (leftIndex < rightIndex) {

            while (array[rightIndex] >= pivotValue
                    && leftIndex < rightIndex) {
                rightIndex--;
            }

            if (leftIndex != rightIndex) {
                array[leftIndex] = array[rightIndex];
                leftIndex++;
            }

            while (array[leftIndex] <= pivotValue
                    && leftIndex < rightIndex) {
                leftIndex++;
            }

            if (leftIndex != rightIndex) {
                array[rightIndex] = array[leftIndex];
                rightIndex--;
            }
        }

        array[leftIndex] = pivotValue;

        if (firstElementIndex < leftIndex) {
            quickSort(array, firstElementIndex, leftIndex - 1);
        }

        if (leftIndex < lastElementIndex) {
            quickSort(array, leftIndex + 1, lastElementIndex);
        }

    }

    /**
     * Сортировка массива методом быстрой сортировки
     * для указанного интервала.
     *
     * @param array             массив для сортировки
     * @param firstElementIndex индекс первого элемента в интервале
     * @param lastElementIndex  индекс второго элемента в интервале
     */
    private void quickSort(int[] array,
                           int firstElementIndex,
                           int lastElementIndex) {

        if (firstElementIndex == lastElementIndex) {
            return;
        }

        quickSortIterate(array, firstElementIndex, lastElementIndex);
    }



}
