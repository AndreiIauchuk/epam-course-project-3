package by.epamtc.iovchuk.task1.wrapper;

import by.epamtc.iovchuk.task1.exception.OutBoundsException;
import by.epamtc.iovchuk.task1.service.ArraySearchService;
import by.epamtc.iovchuk.task1.service.ArraySortService;
import by.epamtc.iovchuk.task1.util.ArrayUtil;
import by.epamtc.iovchuk.task1.validator.ArrayValidator;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

public class IntArrayWrapper implements Serializable {

    private static final int DEFAULT_CAPACITY = 10;

    private int[] intArray;
    private int length;
    private int capacity;

    private final ArrayValidator arrayValidator = new ArrayValidator();

    public IntArrayWrapper() {
        capacity = DEFAULT_CAPACITY;
        intArray = new int[capacity];
    }

    public IntArrayWrapper(int[] array) {
        int length = array.length;
        createWrappedArray(length);

        System.arraycopy(array, 0, this.intArray, 0, length);
    }

    public IntArrayWrapper(Integer[] integers) {
        int length = integers.length;
        createWrappedArray(length);

        for (int i = 0; i < length; i++) {
            intArray[i] = integers[i];
        }
    }

    public IntArrayWrapper(Collection<Integer> intCollection) {
        int length = intCollection.size();
        createWrappedArray(length);

        int i = 0;
        for (Integer integer : intCollection) {
            intArray[i] = integer;
            ++i;
        }
    }

    public IntArrayWrapper(String values) {
        String[] strArray = values.split(", ");

        int length = strArray.length;
        createWrappedArray(length);

        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }

    }

    private void createWrappedArray(int length) {
        calculateCapacity(length);
        this.length = length;
        intArray = new int[capacity];
    }

    private void calculateCapacity(int length) {
        capacity = DEFAULT_CAPACITY;

        while (!validateCapacity(length)) {
            doubleCapacity();
        }
    }

    private boolean validateCapacity(int length) {
        return capacity > length;
    }

    private void doubleCapacity() {
        capacity = capacity * 2;
    }

    /**
     * Добавляет указанное значение в конец массива.
     *
     * @param value значение
     * @return true, если значение было добавлено
     */
    public boolean add(int value) {
        if (!validateCapacity(length + 1)) {
            doubleCapacity();
        }

        intArray[length] = value;
        length++;

        return true;
    }

    /**
     * Добавляет указанное значение в указанную позицию в массиве.
     *
     * @param value значение
     * @param index индекс, в который добавляется значение
     * @return true, если значение было добавлено
     * @throws OutBoundsException если индекс выходит за пределы с
     *                            допустимого диапазона массива
     */
    public boolean add(int value, int index) throws OutBoundsException {
        if (arrayValidator.checkOutOfBounds(intArray, index)) {
            throw new OutBoundsException();
        }

        if (!validateCapacity(length + 1)) {
            doubleCapacity();
        }

        int elemsToCopyCount = length - 1 - index;
        System.arraycopy(intArray, index, intArray, index + 1, elemsToCopyCount);
        intArray[index] = value;
        length++;

        return true;
    }

    /**
     * Удаляет элемент с указанным индексом из массива.
     *
     * @param index индекс удаляемого элемента
     * @return true, если элемент был удален
     * @throws OutBoundsException если индекс выходит за пределы с
     *                            допустимого диапазона массива
     */
    public boolean remove(int index) throws OutBoundsException {
        if (arrayValidator.checkOutOfBounds(intArray, index)) {
            throw new OutBoundsException();
        }

        int elemsToCopyCount = length - 1 - index;
        System.arraycopy(intArray, index + 1, intArray, index, elemsToCopyCount);
        length--;

        return true;
    }

    /**
     * Возвращает значение элемента массива с указанным индексом.
     *
     * @param index индекс элемента
     * @return значение элемента массива
     * @throws OutBoundsException если индекс выходит за пределы с
     *                            допустимого диапазона массива
     */
    public int getElement(int index) throws OutBoundsException {
        if (arrayValidator.checkOutOfBounds(intArray, index)) {
            throw new OutBoundsException();
        }

        return intArray[index];
    }

    /**
     * Устанавливает значение элемента массива с указанным индексом.
     *
     * @param index индекс элемента
     * @throws OutBoundsException если индекс выходит за пределы с
     *                            допустимого диапазона массива
     */
    public void setElement(int index, int value) throws OutBoundsException {
        if (arrayValidator.checkOutOfBounds(intArray, index)) {
            throw new OutBoundsException();
        }

        intArray[index] = value;
    }

    /**
     * "Переворачивает" массив.
     */
    public void invert() {
        if (arrayValidator.checkBlank(intArray)
                || arrayValidator.checkSingleElement(intArray)) {
            return;
        }

        int temp;
        for (int i = 0; i < length / 2; i++) {
            temp = intArray[i];
            intArray[i] = intArray[length - 1 - i];
            intArray[length - 1 - i] = temp;
        }
    }

    /**
     * Сортирует массив по возрастанию.
     */
    public void sort() {
        if (arrayValidator.checkBlank(intArray)
                || arrayValidator.checkSingleElement(intArray)) {
            return;
        }

        int[] tempArray = getIntArray();
        new ArraySortService().quickSort(this);

        int i = 0;
        for (int value : tempArray) {
            intArray[i] = value;
            ++i;
        }
    }

    /**
     * Находит индекс элемента массива с указанным значением.
     *
     * @param value искомое значение элемента массива
     * @return индекс искомого элемента массива
     */
    public int indexOf(int value) {
        int[] tempArray = getIntArray();
        return new ArraySearchService().binarySearch(tempArray, value);
    }

    public int[] getIntArray() {
        int[] tempArray = new int[length];
        if (length >= 0) System.arraycopy(intArray, 0, tempArray, 0, length);
        return tempArray;
    }

    public int getLength() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntArrayWrapper that = (IntArrayWrapper) o;
        return Arrays.equals(intArray, that.intArray);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + capacity;
        hash = 31 * hash + length;
        hash = 31 * hash + Arrays.hashCode(intArray);
        return hash;
    }

    @Override
    public String toString() {
        return getClass() + " {" +
                "intArray=" + ArrayUtil.arrayToString(getIntArray()) +
                ", length=" + length +
                ", capacity=" + capacity +
                '}';
    }
}
