package by.epamtc.iovchuk.task1.util;

import java.util.List;

public class ArrayUtil {

    static public String arrayToString(int[] array) {
        int length = array.length;
        if (length == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        for (int i = 0; i < length; i++) {
            stringBuilder
                    .append(array[i])
                    .append(", ");
        }
        //Удаляет последнюю запятую
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.append("]").toString();
    }

    static public int[] listToArray(List<Integer> list) {
        int listSize = list.size();

        int[] array = new int[listSize];

        for (int index = 0; index < listSize; index++) {
            array[index] = list.get(index);
        }

        return array;
    }
}
