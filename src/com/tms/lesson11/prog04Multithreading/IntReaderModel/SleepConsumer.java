package com.tms.lesson11.prog04Multithreading.IntReaderModel;

/**
 * Задача - при каждом вводе числа через IntProducerRunnable должна создаваться задача, которая засыпает на введённое число секунд
 * и затем выводит "Я спал N секунд".
 *
 * Сделать так, чтобы все задачи выполнялись в отдельном потоке.
 */
public class SleepConsumer implements Runnable {
    private Thread thread;
    private long secondsToSleep;

    public SleepConsumer(long secondsToSleep) {
        System.out.println("Запуск конструктора сновидений...");
        thread = new Thread(this);
        System.out.println("Экземпляр сна создан. Засыпаю");
        this.secondsToSleep = secondsToSleep;
        thread.start();
    }

    public synchronized void run() {
        doInnerLogic();
    }

    private void doInnerLogic() {
        try {
            System.out.println();
            System.out.println("Сплю...");
            Thread.sleep(secondsToSleep * 1000);
            System.out.println("Я спал " + secondsToSleep + " секунд");
            System.out.println();
            System.out.println("Для завершения программы введите -1");
            System.out.print("Введите количество секунд, которые мне можно поспать: ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread.yield();
    }
}
