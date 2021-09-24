package com.tms.lesson11.prog04MultithreadingTest.IntReaderModelTest;

/**
 * Задача - бесконечно считывать пользовательские числа из консоли.
 * Эти числа представляют собой количество секунд.
 * При вводе -1 программа должна завершать свою работу.
 *
 * Сделать так, чтобы все задачи выполнялись в отдельном потоке.
 */
public class IntProducerRunnable implements Runnable {

    // Склад, в который будут "складироваться" секунды для сна. Пока он не определен и будет задан через конструктор
    private SleepTimeStore sleepTimeStore;

    // Конструктор производителя секунд для сна
    public IntProducerRunnable(SleepTimeStore sleepTimeStore){
        this.sleepTimeStore = sleepTimeStore;
    }

    @Override
    public void run() {
        doInnerLogic();
    }

    // Метод для добавления секунд для сна на склад
    private void doInnerLogic() {
        while (true) {
            // добавить секунды на склад
            sleepTimeStore.produceSec();
        }
    }

}
