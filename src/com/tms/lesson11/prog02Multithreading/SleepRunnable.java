package com.tms.lesson11.prog02Multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2. Создать класс с синхронизированным методом, который выводит на экран имя текущего потока, текущее время и вызывает sleep на 5 секунд.
 */
public class SleepRunnable implements Runnable{

    public synchronized void run() {
        doInnerLogic();
    }

    private void doInnerLogic() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("HH:mm:ss");

        System.out.println(Thread.currentThread().getName() + ": текущее время " + dateFormat.format(currentDate));

        try {
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
