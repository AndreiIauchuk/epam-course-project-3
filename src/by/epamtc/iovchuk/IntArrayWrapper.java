package by.epamtc.iovchuk;

import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.exception.OutBoundsException;
import by.epamtc.iovchuk.util.CheckUtil;
import sun.invoke.util.Wrapper;

import javax.swing.text.WrappedPlainView;
import java.util.Arrays;
import java.util.Objects;

public class IntArrayWrapper {

    private static final int DEFAULT_CAPACITY = 10;

    private int[] intArray;
    private int length;
    private int capacity;

    public IntArrayWrapper() {
        capacity = DEFAULT_CAPACITY;
        intArray = new int[capacity];
    }

    public IntArrayWrapper(int[] intArray) throws NullException {
        CheckUtil.checkNull(intArray, "Массив");

        int length = intArray.length;
        calculateCapacity(length);

        this.length = length;
        this.intArray = new int[capacity];

        for (int i = 0; i < length; i++) {
            this.intArray[i] = intArray[i];
        }
    }

    public IntArrayWrapper(Integer[] integers) throws NullException {
        CheckUtil.checkNull(integers, "Массив");

        int length = integers.length;
        calculateCapacity(length);

        this.length = length;
        intArray = new int[capacity];

        for (int i = 0; i < length; i++) {
            intArray[i] = integers[i];
        }
    }

    public IntArrayWrapper(String values) throws NullException {
        CheckUtil.checkNull(values, "Строка");

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
     * @return  значение элемента массива
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
                "intArray=" + wrappedArrayToString() +
                ", length=" + length +
                ", capacity=" + capacity +
                '}';
    }

    private String wrappedArrayToString() {
        if (length == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        for (int i = 0; i < length; i++) {
            stringBuilder
                    .append(intArray[i])
                    .append(", ");
        }
        //Удаляет последнюю запятую
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.append("]").toString();
    }
}