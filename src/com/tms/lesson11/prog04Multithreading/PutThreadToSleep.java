package com.tms.lesson11.prog04Multithreading;

import com.tms.lesson11.prog04Multithreading.IntReaderModel.SleepConsumer;

import java.util.Scanner;

/**
 * 4. Написать программу, бесконечно считывающую пользовательские числа из консоли.
 * Эти числа представляют собой количество секунд.
 *
 * При каждом вводе числа, должна создаваться задача, которая засыпает на введённое число секунд и затем выводит "Я спал N секунд".
 *
 * Однако нужно сделать так, чтобы все задачи выполнялись в отдельном потоке.
 * При вводе -1 программа должна завершать свою работу.
 */
public class PutThreadToSleep {
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread(); // получаем главный поток
        System.out.println("Запущен поток " + mainThread.getName() + ". Запущена программа сновидений"); // запущен главный поток - main
        System.out.println();

        putThreadToSleep();

    }

    public static synchronized void putThreadToSleep() {
        int secondsToSleep = 0;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Для завершения программы введите -1");
            System.out.print("Введите количество секунд, которые мне можно поспать: ");

            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    secondsToSleep = sc.nextInt();
                    if (secondsToSleep > 0) {
                        System.out.println("Вы ввели число " + secondsToSleep);
                        System.out.println();

                        new SleepConsumer(secondsToSleep);

                    } else if (secondsToSleep == 0) {
                        System.out.println();
                        System.out.println("Число " + secondsToSleep + " - это мало. Я не спал. Для завершения программы введите -1");
                        System.out.print("Введите количество секунд, которые мне можно поспать: ");
                    } else if (secondsToSleep == -1) {
                        System.out.println();
                        System.out.println("Благодарю за отдых. Программа завершена.");
                        break;
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
    }
}
