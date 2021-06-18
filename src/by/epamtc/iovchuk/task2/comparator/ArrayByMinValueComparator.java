package by.epamtc.iovchuk.task2.comparator;

import java.util.Comparator;

public class ArrayByMinValueComparator implements Comparator<Object> {

    @Override
    public int compare(Object _array1, Object _array2) {
        if (!(_array1 instanceof int[])
                && !(_array2 instanceof int[])) {
            return -1;
        }

        int[] array1 = (int[]) _array1;
        int[] array2 = (int[]) _array2;

        int result = 0;

        if (defineRowMinValue(array1) > defineRowMinValue(array2)) {
            result = 1;
        } else if (defineRowMinValue(array1) < defineRowMinValue(array2)) {
            result = -1;
        }

        return result;

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
