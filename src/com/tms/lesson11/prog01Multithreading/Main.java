package com.tms.lesson11.prog01Multithreading;

/**
 * 1. Создать класс поток, который создает средствами Java файл и записать в него рандомно сгенерированный массив из 10 целых чисел.
 * Запустить 5 потоков.
 */
public class Main {
    public static void main(String[] args) {
        RandomArrayWriterRunnable randomArrayWriterRunnable = new RandomArrayWriterRunnable();

        Thread one = new Thread(randomArrayWriterRunnable);
        one.setName("Первый поток");
        Thread two = new Thread(randomArrayWriterRunnable);
        two.setName("Второй поток");
        Thread three = new Thread(randomArrayWriterRunnable);
        three.setName("Третий поток");
        Thread four = new Thread(randomArrayWriterRunnable);
        four.setName("Четвертый поток");
        Thread five = new Thread(randomArrayWriterRunnable);
        five.setName("Пятый поток");

        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
    }
}
