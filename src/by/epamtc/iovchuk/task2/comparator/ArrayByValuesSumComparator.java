package by.epamtc.iovchuk.task2.comparator;

import java.util.Comparator;

public class ArrayByValuesSumComparator implements Comparator<Object> {

    @Override
    public int compare(Object _array1, Object _array2) {
        if (!(_array1 instanceof int[])
                && !(_array2 instanceof int[])) {
            return -1;
        }

        int[] array1 = (int[]) _array1;
        int[] array2 = (int[]) _array2;

        int result = 0;
        if (calcRowValuesSum(array1) > calcRowValuesSum(array2)) {
            result = 1;
        } else if (calcRowValuesSum(array1) < calcRowValuesSum(array2)) {
            result = -1;
        }

        return result;

    }

    private int calcRowValuesSum(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }

        return sum;
    }
}
