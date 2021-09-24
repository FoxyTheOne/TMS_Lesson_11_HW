package com.tms.lesson11.prog04MultithreadingTest;

import com.tms.lesson11.prog04MultithreadingTest.IntReaderModelTest.IntProducerRunnable;
import com.tms.lesson11.prog04MultithreadingTest.IntReaderModelTest.SleepConsumerRunnable;
import com.tms.lesson11.prog04MultithreadingTest.IntReaderModelTest.SleepTimeStore;

/**
 * 4. Написать программу, бесконечно считывающую пользовательские числа из консоли.
 * Эти числа представляют собой количество секунд.
 *
 * При каждом вводе числа, должна создаваться задача, которая засыпает на введённое число секунд и затем выводит "Я спал N секунд".
 *
 * Однако нужно сделать так, чтобы все задачи выполнялись в отдельном потоке.
 * При вводе -1 программа должна завершать свою работу.
 */
public class Main {
    public static void main(String[] args) {
        // Создаём объект склада
        SleepTimeStore sleepTimeStore = new SleepTimeStore();

        IntProducerRunnable intProducerRunnable = new IntProducerRunnable(sleepTimeStore);
        SleepConsumerRunnable sleepConsumerRunnable = new SleepConsumerRunnable(sleepTimeStore);

        // Создаём потоки
        Thread one = new Thread(intProducerRunnable);
        Thread two = new Thread(sleepConsumerRunnable);

        // Запускаем
        one.start();
        two.start();
    }
}
