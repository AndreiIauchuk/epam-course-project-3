package by.epamtc.iovchuk.task1.filler;

import by.epamtc.iovchuk.task1.exception.NullException;
import by.epamtc.iovchuk.task1.util.CheckUtil;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс для заполнения массива значениями,
 * считанных из файла.
 */
public class FileArrayFiller extends ArrayFiller {

    private Scanner scanner;
    private String filePath;

    public FileArrayFiller(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        createConsoleScanner();
    }

    private void createConsoleScanner() throws FileNotFoundException {
        scanner = new Scanner(new File(filePath));
        scanner.useDelimiter(", ");
    }

    @Override
    public void fillArray(int[] array) throws NullException {
        CheckUtil.checkNull(array, "Массив");
        int arrayLength = array.length;

        List<Integer> fileArrayList = parseFile();

        if (arrayLength > fileArrayList.size()) {
            arrayLength = fileArrayList.size();
        }

        for (int index = 0; index < arrayLength; index++) {
            array[index] = fileArrayList.get(index);
        }

    }

    private List<Integer> parseFile() {
        List<Integer> fileArrayList = new LinkedList<>();
        while(scanner.hasNextInt()){
            fileArrayList.add(scanner.nextInt());
        }

        return fileArrayList;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
