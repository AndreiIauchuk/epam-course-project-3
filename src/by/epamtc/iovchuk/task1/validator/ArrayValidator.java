package by.epamtc.iovchuk.task1.validator;

public class ArrayValidator {

    /**
     * Проверяет, указывает ли ссылка на null.
     *
     * @param array ссылка на массив для проверки
     * @return, true если ссылка указывает на null
     */
    public boolean checkNull(int[] array) {
        return (array == null);
    }

    /**
     * Проверяет, является ли указанный массив пустым.
     *
     * @param array ссылка на массив для проверки
     * @return true, если указанный массив пустой
     */
    public boolean checkBlank(int[] array) {
        return (array.length == 0);
    }

    /**
     * Проверяет, содержит ли указанный массив только один элемент.
     *
     * @param array ссылка на массив для проверки
     * @return true, если указанный массив содержит только один элемент
     */
    public boolean checkSingleElement(int[] array) {
        return (array.length == 1);
    }

    /**
     * Проверяет, выходит ли указанный индекс за пределы
     * допустимого диапазона массива.
     *
     * @param array ссылка на массив для проверки
     * @param index индекс для проверка
     * @return true, если указанный индекс выходит за
     * пределы допустимого диапазона
     */
    public boolean checkOutOfBounds(int[] array, int index) {
        int length = array.length;
        return (index >= length || index < 0);
    }

}