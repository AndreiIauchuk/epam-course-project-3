package test.by.epamtc.iovchuk.task1.service;

import by.epamtc.iovchuk.task1.service.ArraySearchService;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArraySearchServiceTest {

    ArraySearchService arraySearchService = new ArraySearchService();
    static int[] unsortedArray;
    static int[] sortedArray;
    int[] blankArray = new int[0];

    @BeforeClass
    public static void beforeClass() {
        createUnsortedArray();
        createSortedArray();
    }

    private static void createUnsortedArray() {
        unsortedArray = new int[7];
        unsortedArray[0] = 10;
        unsortedArray[1] = -5;
        unsortedArray[2] = 5;
        unsortedArray[3] = 123;
        unsortedArray[4] = -2;
        unsortedArray[5] = 0;
        unsortedArray[6] = 111;
    }

    private static void createSortedArray() {
        sortedArray = new int[7];
        sortedArray[0] = -5;
        sortedArray[1] = -2;
        sortedArray[2] = 0;
        sortedArray[3] = 5;
        sortedArray[4] = 10;
        sortedArray[5] = 111;
        sortedArray[6] = 123;

    }

    @Test
    public void testBinarySearch_whenArrayIsNull() {
        int expected = -1;
        testBinarySearch(expected, null, 5);
    }

    @Test
    public void testBinarySearch_whenArrayIsBlank() {
        int expected = -1;
        testBinarySearch(expected, blankArray, 5);
    }

    @Test
    public void testBinarySearch_whenValueIsNotFound() {
        int expected = -1;
        testBinarySearch(expected, sortedArray, 100);
    }

    @Test
    public void testBinarySearch_whenValueIsFound() {
        int expected = 3;
        testBinarySearch(expected, sortedArray, 5);
    }

    private void testBinarySearch(int expected, int[] array, int value) {
        int actual = arraySearchService.binarySearch(array, value);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMaxValue_whenArrayIsNull() {
        int expected = -1;
        testFindMaxValue(expected, null);
    }

    @Test
    public void testFindMaxValue_whenArrayIsBlank() {
        int expected = -1;
        testFindMaxValue(expected, blankArray);
    }

    @Test
    public void testFindMaxValue() {
        int expected = 123;
        testFindMaxValue(expected, unsortedArray);
    }

    private void testFindMaxValue(int expected, int[] array) {
        int actual = arraySearchService.findMaxValue(array);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMinValue_whenArrayIsNull() {
        int expected = -1;
        testFindMinValue(expected, null);
    }

    @Test
    public void testFindMinValue_whenArrayIsBlank() {
        int expected = -1;
        testFindMinValue(expected, blankArray);
    }

    @Test
    public void testFindMinValue() {
        int expected = -5;
        testFindMinValue(expected, unsortedArray);
    }

    private void testFindMinValue(int expected, int[] array) {
        int actual = arraySearchService.findMinValue(array);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindPrimeNumbers_whenArrayIsNull() {
        int[] expected = null;
        testFindPrimeNumbers_whenValidationFails(expected, null);
    }

    @Test
    public void testFindPrimeNumbers_whenArrayIsBlank() {
        int[] expected = null;
        testFindPrimeNumbers_whenValidationFails(expected, blankArray);
    }

    private void testFindPrimeNumbers_whenValidationFails(int[] expected, int[] array) {
        int[] actual = arraySearchService.findPrimeNumbers(array);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindPrimeNumbers() {
        int[] expected = {5};
        testFindPrimeNumbers(expected, unsortedArray);
    }

    private void testFindPrimeNumbers(int[] expected, int[] array) {
        int[] actual = arraySearchService.findPrimeNumbers(array);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindFibonacciNumbers_whenArrayIsNull() {
        int[] expected = null;
        testFindFibonacciNumbers_whenValidationFails(expected, null);
    }

    @Test
    public void testFindFibonacciNumbers_whenArrayIsBlank() {
        int[] expected = null;
        testFindFibonacciNumbers_whenValidationFails(expected, blankArray);
    }

    private void testFindFibonacciNumbers_whenValidationFails(int[] expected, int[] array) {
        int[] actual = arraySearchService.findFibonacciNumbers(array);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindFibonacciNumbers() {
        int[] expected = {5, 0};
        testFindFibonacciNumbers(expected, unsortedArray);
    }

    private void testFindFibonacciNumbers(int[] expected, int[] array) {
        int[] actual = arraySearchService.findFibonacciNumbers(array);
        assertArrayEquals(expected, actual);
    }


    @Test
    public void testFindUniqueThreeDigitNumbers_whenArrayIsNull() {
        int[] expected = null;
        testFindUniqueThreeDigitNumbers_whenValidationFails(expected, null);
    }

    @Test
    public void testFindUniqueThreeDigitNumbers_whenArrayIsBlank() {
        int[] expected = null;
        testFindUniqueThreeDigitNumbers_whenValidationFails(expected, blankArray);
    }

    private void testFindUniqueThreeDigitNumbers_whenValidationFails(int[] expected, int[] array) {
        int[] actual = arraySearchService.findUniqueThreeDigitNumbers(array);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindUniqueThreeDigitNumbers() {
        int[] expected = {123};
        testFindUniqueThreeDigitNumbers(expected, unsortedArray);
    }

    private void testFindUniqueThreeDigitNumbers(int[] expected, int[] array) {
        int[] actual = arraySearchService.findUniqueThreeDigitNumbers(array);
        assertArrayEquals(expected, actual);
    }

}