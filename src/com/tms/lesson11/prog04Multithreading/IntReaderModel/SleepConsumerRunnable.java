package com.tms.lesson11.prog04Multithreading.IntReaderModel;

import com.tms.lesson11.prog03Multithreading.IntStoreModel.Store;

/**
 * Задача - при каждом вводе числа через IntProducerRunnable должна создаваться задача, которая засыпает на введённое число секунд
 * и затем выводит "Я спал N секунд".
 *
 * Сделать так, чтобы все задачи выполнялись в отдельном потоке.
 */
public class SleepConsumerRunnable implements Runnable {

    // Склад, с которого будут считываться секунды для сна. Пока он не определен и будет задан через конструктор
    private SleepTimeStore sleepTimeStore;

    // Конструктор того, кто будет спать
    public SleepConsumerRunnable(SleepTimeStore sleepTimeStore){
        this.sleepTimeStore = sleepTimeStore;
    }

    @Override
    public void run() {
        doInnerLogic();
    }

    // Метод для считывания чисел со склада и засыпания
    private void doInnerLogic() {
        while (true) {
            // забрать (получить) элемент
            sleepTimeStore.getSec();
        }
    }

}
