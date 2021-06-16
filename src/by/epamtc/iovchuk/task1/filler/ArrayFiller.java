package by.epamtc.iovchuk.task1.filler;

import by.epamtc.iovchuk.task1.exception.NullException;

/**
 * Абстрактный класс для заполнения массива значениями.
 */
public abstract class ArrayFiller {

    abstract public void fillArray(int[] array) throws NullException;
}
