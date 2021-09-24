package com.tms.lesson11.prog02Multithreading;

/**
 * 2. Создать класс с синхронизированным методом, который выводит на экран имя текущего потока, текущее время и вызывает sleep на 5 секунд.
 * Запустить 10 потоков, которые вызывают этот метод от созданного объекта.
 */
public class Main {
    public static void main(String[] args) {
        SleepRunnable sleepRunnable = new SleepRunnable();

        Thread one = new Thread(sleepRunnable);
        one.setName("Первый поток");
        Thread two = new Thread(sleepRunnable);
        two.setName("Второй поток");
        Thread three = new Thread(sleepRunnable);
        three.setName("Третий поток");
        Thread four = new Thread(sleepRunnable);
        four.setName("Четвертый поток");
        Thread five = new Thread(sleepRunnable);
        five.setName("Пятый поток");
        Thread six = new Thread(sleepRunnable);
        six.setName("Шестой поток");
        Thread seven = new Thread(sleepRunnable);
        seven.setName("Седьмой поток");
        Thread eight = new Thread(sleepRunnable);
        eight.setName("Восьмой поток");
        Thread nine = new Thread(sleepRunnable);
        nine.setName("Девятый поток");
        Thread ten = new Thread(sleepRunnable);
        ten.setName("Десятый поток");

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
