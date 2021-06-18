package by.epamtc.iovchuk.task2.comparator;

import java.util.Comparator;

public class ArrayByMaxValueComparator implements Comparator<Object> {

    @Override
    public int compare(Object _array1, Object _array2) {
        if (!(_array1 instanceof int[])
                && !(_array2 instanceof int[])) {
            return -1;
        }

        int[] array1 = (int[]) _array1;
        int[] array2 = (int[]) _array2;

        int result = 0;
        if (defineRowMaxValue(array1) > defineRowMaxValue(array2)) {
            result = 1;
        } else if (defineRowMaxValue(array1) < defineRowMaxValue(array2)) {
            result = -1;
        }

        return result;

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
}
