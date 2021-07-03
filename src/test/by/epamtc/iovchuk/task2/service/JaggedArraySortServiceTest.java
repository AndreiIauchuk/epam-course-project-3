package test.by.epamtc.iovchuk.task2.service;

import by.epamtc.iovchuk.task2.service.JaggedArraySortService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class JaggedArraySortServiceTest {

    JaggedArraySortService jaggedArraySortService = new JaggedArraySortService();
    int[][] unsortedJaggedArray;
    static int[][] sortedByRowValuesSumArray;
    static int[][] sortedByRowMaxValueArray;
    static int[][] sortedByRowMinValueArray;
    static int[][] invertedArray;

    @BeforeClass
    public static void beforeClass() {
        createSortedByRowValuesSumArray();
        createSortedByRowMaxValueArray();
        createSortedByRowMinValueArray();
        createInvertedArray();
    }

    private static void createSortedByRowValuesSumArray() {
        sortedByRowValuesSumArray = new int[5][];
        sortedByRowValuesSumArray[0] = new int[]{-5, 0};
        sortedByRowValuesSumArray[1] = new int[]{1, -10, 4, 4};
        sortedByRowValuesSumArray[2] = new int[]{1, 7, -6};
        sortedByRowValuesSumArray[3] = new int[]{3};
        sortedByRowValuesSumArray[4] = new int[]{6, 4, -2};
    }

    private static void createSortedByRowMaxValueArray() {
        sortedByRowMaxValueArray = new int[5][];
        sortedByRowMaxValueArray[0] = new int[]{-5, 0};
        sortedByRowMaxValueArray[1] = new int[]{3};
        sortedByRowMaxValueArray[2] = new int[]{1, -10, 4, 4};
        sortedByRowMaxValueArray[3] = new int[]{6, 4, -2};
        sortedByRowMaxValueArray[4] = new int[]{1, 7, -6};
    }

    private static void createSortedByRowMinValueArray() {
        sortedByRowMinValueArray = new int[5][];
        sortedByRowMinValueArray[0] = new int[]{1, -10, 4, 4};
        sortedByRowMinValueArray[1] = new int[]{1, 7, -6};
        sortedByRowMinValueArray[2] = new int[]{-5, 0};
        sortedByRowMinValueArray[3] = new int[]{6, 4, -2};
        sortedByRowMinValueArray[4] = new int[]{3};
    }

    private static void createInvertedArray() {
        invertedArray = new int[5][];
        invertedArray[0] = new int[]{1, -10, 4, 4};
        invertedArray[1] = new int[]{3};
        invertedArray[2] = new int[]{1, 7, -6};
        invertedArray[3] = new int[]{6, 4, -2};
        invertedArray[4] = new int[]{-5, 0};
    }

    @Before
    public void before() {
        createUnsortedArray();
    }

    private void createUnsortedArray() {
        unsortedJaggedArray = new int[5][];
        unsortedJaggedArray[0] = new int[]{-5, 0};
        unsortedJaggedArray[1] = new int[]{6, 4, -2};
        unsortedJaggedArray[2] = new int[]{1, 7, -6};
        unsortedJaggedArray[3] = new int[]{3};
        unsortedJaggedArray[4] = new int[]{1, -10, 4, 4};
    }

    @Test
    public void testRowValuesSumSort() {
        jaggedArraySortService.rowValuesSumSort(unsortedJaggedArray);
        assertArrayEquals(unsortedJaggedArray, sortedByRowValuesSumArray);
    }

    @Test
    public void testRowMaxValueSort() {
        jaggedArraySortService.rowMaxValueSort(unsortedJaggedArray);
        assertArrayEquals(unsortedJaggedArray, sortedByRowMaxValueArray);
    }

    @Test
    public void testRowMinValueSort() {
        jaggedArraySortService.rowMinValueSort(unsortedJaggedArray);
        assertArrayEquals(unsortedJaggedArray, sortedByRowMinValueArray);
    }

    @Test
    public void testInvert() {
        jaggedArraySortService.invert(unsortedJaggedArray);
        assertArrayEquals(unsortedJaggedArray, invertedArray);
    }

} 
