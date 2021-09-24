package com.tms.lesson11.prog01Multithreading;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. Создать класс поток, который создает средствами Java файл и записать в него рандомно сгенерированный массив из 10 целых чисел.
 */
public class RandomArrayWriterRunnable implements Runnable {
    public void run() {
        doInnerLogic();
    }

    private void doInnerLogic() {
        File myFile = new File("C:\\java\\TeachMeSkills\\TMS_Lesson_11_HW\\randomArray.txt"); // Путь для создания файла

        try {
            boolean isFileCreated = myFile.createNewFile(); // Создаём новый файл по пути, который передан в конструктор

            if(isFileCreated){
                System.out.println();
                System.out.println(Thread.currentThread().getName() + ": file was created");
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String randomArray = createRandomArray(); // Создаём случайный массив, преобразуем в строку

        try(PrintWriter fw = new PrintWriter (new BufferedWriter(new FileWriter (myFile, true)))){
            fw.println(randomArray);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private String createRandomArray() {
        List<Integer> randomArray = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            randomArray.add((int) (Math.random() * (99 - 2)) + 2); // Диапазон целых чисел [2; 99)(99 не включительно). Формула (Math.random()*(b-a))+a) = [a; b)
        }
        System.out.println(Thread.currentThread().getName() + ": массив целых чисел " + randomArray + " записан в файл");

        return String.valueOf(randomArray);
    }
}
