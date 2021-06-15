package by.epamtc.iovchuk.filler;

import java.io.*;
import java.util.ArrayList;
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
    public void fillArray(int[] array) {

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
