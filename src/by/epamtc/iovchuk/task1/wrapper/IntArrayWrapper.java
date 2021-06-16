package by.epamtc.iovchuk.task1.wrapper;

import by.epamtc.iovchuk.task1.exception.BlankArrayException;
import by.epamtc.iovchuk.task1.exception.NullException;
import by.epamtc.iovchuk.task1.exception.OutBoundsException;
import by.epamtc.iovchuk.task1.service.ArraySearchService;
import by.epamtc.iovchuk.task1.service.ArraySortService;
import by.epamtc.iovchuk.task1.util.ArrayUtil;
import by.epamtc.iovchuk.task1.util.CheckUtil;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class IntArrayWrapper implements Serializable {

    private static final int DEFAULT_CAPACITY = 10;

    private int[] intArray;
    private int length;
    private int capacity;

    public IntArrayWrapper() {
        capacity = DEFAULT_CAPACITY;
        intArray = new int[capacity];
    }

    public IntArrayWrapper(int[] intArray) {
        int length = intArray.length;
        calculateCapacity(length);

        this.length = length;
        this.intArray = new int[capacity];

        for (int i = 0; i < length; i++) {
            this.intArray[i] = intArray[i];
        }
    }

    public IntArrayWrapper(Integer[] integers) {
        int length = integers.length;
        calculateCapacity(length);

        this.length = length;
        intArray = new int[capacity];

        for (int i = 0; i < length; i++) {
            intArray[i] = integers[i];
        }
    }

    public IntArrayWrapper(Collection<Integer> intCollection) {
        int length = intCollection.size();
        calculateCapacity(length);

        this.length = length;
        intArray = new int[capacity];

        Iterator<Integer> iterator = intCollection.iterator();

        int i = 0;
        while (iterator.hasNext()) {
            intArray[i] = iterator.next();
            ++i;
        }
    }

    public IntArrayWrapper(String values) {
        String[] strArray = values.split(", ");

        int length = strArray.length;
        calculateCapacity(length);

        this.length = length;
        intArray = new int[capacity];

        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.valueOf(strArray[i]);
        }

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
     */
    public boolean add(int value, int index) {
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
     * @param value значение
     * @return true, если элемент был удален
     */
    public boolean remove(int index) throws OutBoundsException {
        CheckUtil.checkOutOfBoundsArray(index, length);

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
     */
    public int getElement(int index) throws OutBoundsException {
        CheckUtil.checkOutOfBoundsArray(index, length);

        return intArray[index];
    }

    /**
     * Устанавливает значение элемента массива с указанным индексом.
     *
     * @param index индекс элемента
     */
    public void setElement(int index, int value) throws OutBoundsException {
        CheckUtil.checkOutOfBoundsArray(index, length);

        intArray[index] = value;
    }

    /**
     * "Переворачивает" массив.
     */
    public void invert() {
        if (CheckUtil.checkSmallArrayLength(length)) {
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
    public void sort() throws NullException {
        int[] tempArray = getArrayCopy();
        System.arraycopy(intArray, 0, tempArray, 0, length);
        new ArraySortService().quickSort(tempArray);
        System.arraycopy(tempArray, 0, intArray, 0, length);
    }

    /**
     * Находит индекс элемента массива с указанным значением.
     *
     * @param value искомое значение элемента массива
     * @return индекс искомого элемента массива
     * @throws NullException       если ссылка на массив указывает на null
     * @throws BlankArrayException если массив является пустым
     */
    public int indexOf(int value) throws BlankArrayException, NullException {
        int[] tempArray = getArrayCopy();
        return new ArraySearchService().indexOf(tempArray, value);
    }

    public int[] getArrayCopy() {
        int[] tempArray = new int[length];
        System.arraycopy(intArray, 0, tempArray, 0, length);
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
                "intArray=" + ArrayUtil.arrayToString(getArrayCopy()) +
                ", length=" + length +
                ", capacity=" + capacity +
                '}';
    }
}
