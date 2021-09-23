package com.tms.lesson11.prog04Multithreading.IntReaderModel;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * "Склад" секунд для сна, которые передаёт консоль.
 * Храниться может только одно число, которое нужно поспать.
 */
public class SleepTimeStore {
    // Числа, хранящиеся на складе
    int amountOfNumbers = 0;
    int secondsToSleep;

    // Добавление секунд для сна
    public synchronized void produceSec() {
        secondsToSleep = 0;

        while (amountOfNumbers == 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Для завершения программы введите -1");
            System.out.print("Введите количество секунд, которые мне можно поспать: ");

            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    secondsToSleep = sc.nextInt();
                    if (secondsToSleep > 0) {
                        System.out.println("Вы ввели число " + secondsToSleep);
                        System.out.println();
                        System.out.println("Засыпаю");
                        System.out.println("Сплю...");
                        System.out.println();
                        amountOfNumbers = 1;
                        break;
                    } else if (secondsToSleep == 0) {
                        System.out.println();
                        System.out.println("Число " + secondsToSleep + " - это мало. Я не спал. Для завершения программы введите -1");
                        System.out.print("Введите количество секунд, которые мне можно поспать: ");
                    } else if (secondsToSleep == -1){
                        Thread.currentThread().interrupt();
                        System.out.println("Заканчиваю работу...");
                    } else {
                        System.out.println();
                        System.out.println("Число " + secondsToSleep + " отрицательное, я не могу столько спать. Для завершения программы введите -1");
                        System.out.print("Введите количество секунд, которые мне можно поспать: ");
                    }
                } else {
                    String str = sc.nextLine();
                    System.out.println();
                    System.out.println("К сожалению, я не знаю такого числа. Для завершения программы введите -1");
                    System.out.print("Введите количество секунд, которые мне можно поспать: ");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        notify();

    }

    // Получение секунд со склада, сон
    public synchronized void getSec() {
        if (secondsToSleep == -1) {
            Thread.currentThread().interrupt();
            System.out.println("Заканчиваю работу...");
        }

        while (amountOfNumbers == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        try {
            Thread.sleep(secondsToSleep * 1000);
            amountOfNumbers = 0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Я спал " + secondsToSleep + " секунд");
        System.out.println();

        notify();
    }
}
