package com.tms.lesson11.prog00Multithreading;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 0. Создать класс поток, который генерирует массив целых чисел из 10 элементов,
 * затем находит максимальный элемент в этом массиве и выводит на экран в формате - имя потока: максимальный элемент.
 */
public class MaxElementRunnable implements Runnable {

    public void run() {
        doInnerLogic();
    }

    private void doInnerLogic() {
        ArrayList<Integer> randomArray = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            randomArray.add((int) (Math.random() * (99 - 2)) + 2); // Диапазон целых чисел [2; 99)(99 не включительно). Формула (Math.random()*(b-a))+a) = [a; b)
        }
//        System.out.println(Thread.currentThread().getName() + ": массив целых чисел " + randomArray);

        Collections.sort(randomArray);
        int lastIndex = randomArray.size() - 1; // Индекс последнего элемента (максимальное значение)
        System.out.println(Thread.currentThread().getName() + ": максимальный элемент " + randomArray.get(lastIndex));
    }
}
