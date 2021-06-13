package by.epamtc.iovchuk.util;

import java.util.List;

public class ArrayUtil {

    public static int[] listToArray(List<Integer> list) {
        int listSize = list.size();

        int[] array = new int[listSize];

        for (int index = 0; index < listSize; index++) {
            array[index] = list.get(index);
        }

        return array;
    }
}
