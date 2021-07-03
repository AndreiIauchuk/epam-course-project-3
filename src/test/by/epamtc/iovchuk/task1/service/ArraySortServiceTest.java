package test.by.epamtc.iovchuk.task1.service;

import by.epamtc.iovchuk.task1.service.ArraySortService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArraySortServiceTest {

    ArraySortService arraySortService = new ArraySortService();
    static int[] unsortedArray;
    static int[] sortedArray;

    @Before
    public void beforeClass() {
        createUnsortedArray();
        createSortedArray();
    }

    private static void createUnsortedArray() {
        unsortedArray = new int[5];
        unsortedArray[0] = 10;
        unsortedArray[1] = -5;
        unsortedArray[2] = 5;
        unsortedArray[3] = -2;
        unsortedArray[4] = 0;
    }

    private static void createSortedArray() {
        sortedArray = new int[5];
        sortedArray[0] = -5;
        sortedArray[1] = -2;
        sortedArray[2] = 0;
        sortedArray[3] = 5;
        sortedArray[4] = 10;
    }

    @Test
    public void testSelectionSortArray() {
        arraySortService.selectionSort(unsortedArray);
        assertArrayEquals(unsortedArray, sortedArray);
    }

    @Test
    public void testBubbleSortArray() {
        arraySortService.bubbleSort(unsortedArray);
        assertArrayEquals(unsortedArray, sortedArray);
    }

    @Test
    public void testQuickSortArray() {
        arraySortService.quickSort(unsortedArray);
        assertArrayEquals(unsortedArray, sortedArray);
    }

}