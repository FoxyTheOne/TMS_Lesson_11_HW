package com.tms.lesson11.prog03Multithreading;

import com.tms.lesson11.prog03Multithreading.IntStoreModel.Consumer;
import com.tms.lesson11.prog03Multithreading.IntStoreModel.Producer;
import com.tms.lesson11.prog03Multithreading.IntStoreModel.Store;

/**
 * 3. Задан LinkedList, представляющий собой хранилище целых чисел.
 *
 * Метод produce бесконечно добавляет в этот список случайные числа, однако максимальное количество, которое он может добавить равно 10.
 * Метод consume бесконечно считывает числа с какой-то случайной задержкой (от 0 до 10 мс).
 * Сделать так, чтобы метод produce добавлял числа только тогда, когда не превышен лимит,
 * а метод consume забирал их только тогда, когда в списке что-нибудь есть.
 * При этом методы должны корректно работать в многопоточной среде.
 * Использовать метод removeFirst у LinkedList для получения элемента.
 *
 * Создать и запустить два различных потока, один из которых вызывает produce, а другой - consume.
 * Продемонстрировать корректность работы хранилища с помощью вывода сообщений в консоль о добавлении,
 * получении и текущем размере хранилища на этапах добавления и получения
 */
public class Main {
    public static void main(String[] args) {
        // Создаём объект склада
        Store store = new Store();

        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        // Запускаем потоки
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
