package com.tms.lesson11.prog03Multithreading.IntStoreModel;

/**
 * Производитель, добавляет числа на склад
 * Метод produce бесконечно добавляет в список случайные числа
 */
public class Producer implements Runnable{
    // Склад, в который будут "складироваться" числа. Пока он не определен и будет задан через конструктор
    private Store store;

    // Конструктор производителя
    public Producer(Store store){
        this.store=store;
    }

    @Override
    public void run() {
        doInnerLogic();
    }

    // Метод (бесконечный!) для добавления чисел на склад (в список)
    private void doInnerLogic() {
        while (true) {
            // добавить элемент на склад
            store.produce();
        }
    }
}
