package by.epamtc.iovchuk.task1.filler;

import by.epamtc.iovchuk.task1.exception.NullException;
import by.epamtc.iovchuk.task1.validator.ArrayValidator;

import java.util.Scanner;

/**
 * Класс для заполнения массива значениями,
 * введенными из консоли
 */
public class ConsoleArrayFiller extends ArrayFiller {

    private final Scanner consoleScanner = new Scanner(System.in);

    @Override
    public void fillArray(int[] array) throws NullException {
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
