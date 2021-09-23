package com.tms.lesson11.prog03Multithreading.IntStoreModel;

import java.util.LinkedList;

/**
 * Склад чисел, которые передаёт производитель
 * Метод produce бесконечно добавляет в список случайные числа. Одновременно на складе может быть не более 10ти чисел
 * Метод consume бесконечно считывает числа. Числа считываются с какой-то случайной задержкой (от 0 до 10 мс)
 *
 * Использовать метод removeFirst у LinkedList для получения элемента.
 */
public class Store {
    // Числа на складе
    LinkedList<Integer> numbersInStore = new LinkedList<>();
    int amountOfNumbers = 0;

    // Добавление случайных чисел в список (на склад)
    public synchronized void produce() {
        while (amountOfNumbers >= 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int randomNumber = (int) (Math.random() * (99 - 2)) + 2; // Диапазон целых чисел [2; 99)(99 не включительно). Формула (Math.random()*(b-a))+a) = [a; b)
        numbersInStore.add(randomNumber);
        amountOfNumbers++;

        System.out.println("Производитель добавил число " + randomNumber);
        System.out.println("Чисел на складе: " + amountOfNumbers + ". Числа на складе: " + numbersInStore);
        System.out.println();

        notify();
    }

    // Получение элементов со склада
    public synchronized void consume() {
        while (amountOfNumbers < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        try {
            numbersInStore.removeFirst();
            amountOfNumbers--;
            Thread.sleep((int) (Math.random() * 11)); // Диапазон целых чисел [0; 11)(11 не включительно). Формула (Math.random()*(b-a))+a) = [a; b)
        } catch(InterruptedException e){
            e.printStackTrace();
        }


        System.out.println("Покупатель ЗАБРАЛ 1 число");
        System.out.println("Чисел на складе: " + amountOfNumbers + ". Числа на складе: " + numbersInStore);
        System.out.println();

        notify();
    }
}
