package com.tms.lesson11.prog03Multithreading.IntStoreModel;

/**
 * Потребитель, который будет забирать числа со склада
 * Метод consume бесконечно считывает числа
 */
public class Consumer implements Runnable{
    // Склад, с которого будут считываться числа. Пока он не определен и будет задан через конструктор
    private Store store;

    // Конструктор потребителя
    public Consumer(Store store){
        this.store=store;
    }

    @Override
    public void run() {
        doInnerLogic();
    }

    // Метод (бесконечный!) для считывания чисел со склада
    private void doInnerLogic() {
        while (true) {
            // забрать (получить) элемент
            store.consume();
        }
    }
}
