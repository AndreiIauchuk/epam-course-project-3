package by.epamtc.iovchuk.task1.service;

import by.epamtc.iovchuk.task1.exception.FirstOverLastIndexException;
import by.epamtc.iovchuk.task1.exception.NullException;
import by.epamtc.iovchuk.task1.exception.OutBoundsException;
import by.epamtc.iovchuk.task1.validator.ArrayValidator;

/**
 * Сервис для сортировки массива.
 */
public class ArraySortService {

    private ArrayValidator arrayValidator = new ArrayValidator();

    /**
     * Сортировка массива методом выбора.
     *
     * @param array массив для сортировки
     */
    public void selectionSort(int[] array) {
        if (arrayValidator.checkNull(array)
                || arrayValidator.checkBlank(array)
                || arrayValidator.checkSingleElement(array)) {
            return;
        }

        int arrayLength = array.length;

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
     */
    public void bubbleSort(int[] array) throws NullException {
        if (arrayValidator.checkNull(array)
                || arrayValidator.checkBlank(array)
                || arrayValidator.checkSingleElement(array)) {
            return;
        }

        int arrayLength = array.length;

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
     */
    public void quickSort(int[] array) {
        if (arrayValidator.checkNull(array)
                || arrayValidator.checkBlank(array)
                || arrayValidator.checkSingleElement(array)) {
            return;
        }

        int arrayLength = array.length;

        int firstElementIndex = 0;
        int lastElementIndex = array.length - 1;

        try {
            quickSortIterate(array, firstElementIndex, lastElementIndex);
        } catch (FirstOverLastIndexException ignored) {
        } catch (OutBoundsException ignored) {
        }

    }

    private void quickSortIterate(int[] array,
                                  int firstElementIndex,
                                  int lastElementIndex)
            throws FirstOverLastIndexException, OutBoundsException {

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
     * @throws OutBoundsException          если один из указанных индексов выходит
     *                                     за пределы допустимого диапазона массива
     * @throws FirstOverLastIndexException если минимальный индекс диапазона
     *                                     больше максимального
     */
    public void quickSort(int[] array,
                          int firstElementIndex,
                          int lastElementIndex)
            throws OutBoundsException, FirstOverLastIndexException {

        if (arrayValidator.checkNull(array)
                || arrayValidator.checkBlank(array)
                || arrayValidator.checkSingleElement(array)) {
            return;
        }

        if (arrayValidator.checkOutOfBounds(array, firstElementIndex)
                || arrayValidator.checkOutOfBounds(array, lastElementIndex)) {
            throw new OutBoundsException();
        }

        if (firstElementIndex > lastElementIndex) {
            throw new FirstOverLastIndexException();
        }

        if (firstElementIndex == lastElementIndex) {
            return;
        }

        quickSortIterate(array, firstElementIndex, lastElementIndex);
    }

}
