package by.epamtc.iovchuk.task1.validator;

public class JaggedArrayValidator {

    /**
     * Проверяет, указывает ли ссылка на null.
     *
     * @param array ссылка на непрямоугольный массив для проверки
     * @return, true если ссылка указывает на null
     */
    public boolean checkNull(int[][] jaggedArray) {
        return (jaggedArray == null);
    }

    /**
     * Проверяет, является ли указанный непрямоугольный массив пустым.
     *
     * @param array ссылка на непрямоугольный массив для проверки
     * @return true, если указанный массив пустой
     */
    public boolean checkBlank(int[][] jaggedArray) {
        return (jaggedArray.length == 0);
    }

    /**
     * Проверяет, содержит ли указанный непрямоугольный массив
     * только одну строку.
     *
     * @param array ссылка на непрямоугольный массив для проверки
     * @return true, если указанный массив содержит только один элемент
     */
    public boolean checkSingleRow(int[][] jaggedArray) {
        return (jaggedArray.length == 1);
    }

    /**
     * Проверяет, выходит ли указанный индекс строки за пределы
     * допустимого диапазона непрямоугольный массива.
     *
     * @param array ссылка на непрямоугольный массив для проверки
     * @param index индекс для проверка
     * @return true, если указанный индекс выходит за
     * пределы допустимого диапазона
     */
    public boolean checkOutOfBounds(int[][] array, int index) {
        int length = array.length;
        return (index >= length || index < 0);
    }
}
