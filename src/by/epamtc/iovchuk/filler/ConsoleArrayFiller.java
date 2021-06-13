package by.epamtc.iovchuk.filler;

import java.util.Scanner;

/**
 * Класс для заполнения массива значениями,
 * введенными из консоли
 */
public class ConsoleArrayFiller extends ArrayFiller {

    private final Scanner consoleScanner = new Scanner(System.in);

    @Override
    public void fillArray(int[] array) {
        int arrayLength = array.length;
        for (int index = 0; index < arrayLength; index++) {
            array[index] = readIntValue();
        }
    }

    private int readIntValue() {
        System.out.print("Введите число: ");
        while (!consoleScanner.hasNextInt()) {
            System.err.println("Введите целое число!");
            consoleScanner.next();
        }

        return consoleScanner.nextInt();
    }

}
