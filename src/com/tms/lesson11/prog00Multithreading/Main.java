package com.tms.lesson11.prog00Multithreading;

/**
 * 0. Создать класс поток, который генерирует массив целых чисел из 10 элементов,
 * затем находит максимальный элемент в этом массиве и выводит на экран в формате - имя потока: максимальный элемент.
 * Запустить 10 потоков.
 */
public class Main {
    public static void main(String[] args) {
        MaxElementRunnable maxElementRunnable = new MaxElementRunnable();

        // Создаём потоки на основе своего Runnable
        Thread one = new Thread(maxElementRunnable);
        one.setName("Первый поток");
        Thread two = new Thread(maxElementRunnable);
        two.setName("Второй поток");
        Thread three = new Thread(maxElementRunnable);
        three.setName("Третий поток");
        Thread four = new Thread(maxElementRunnable);
        four.setName("Четвертый поток");
        Thread five = new Thread(maxElementRunnable);
        five.setName("Пятый поток");
        Thread six = new Thread(maxElementRunnable);
        six.setName("Шестой поток");
        Thread seven = new Thread(maxElementRunnable);
        seven.setName("Седьмой поток");
        Thread eight = new Thread(maxElementRunnable);
        eight.setName("Восьмой поток");
        Thread nine = new Thread(maxElementRunnable);
        nine.setName("Девятый поток");
        Thread ten = new Thread(maxElementRunnable);
        ten.setName("Десятый поток");

        // Запускаем
        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
        six.start();
        seven.start();
        eight.start();
        nine.start();
        ten.start();
    }
}
