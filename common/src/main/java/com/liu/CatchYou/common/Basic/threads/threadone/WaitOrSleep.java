package com.liu.CatchYou.common.Basic.threads.threadone;

/**
 * Created by simon.liu on 2017/9/5.
 */
public class WaitOrSleep {
    private static Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (WaitOrSleep.class) {
            System.out.println("Enter thread one..");
            System.out.println("Thread one wait for notify..");
            try {
                WaitOrSleep.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread one continue run..");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                WaitOrSleep.class.notify();
            System.out.println("Thread one run finish.");
            }
        }
    });

    private static Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (WaitOrSleep.class) {
                System.out.println("Enter thread two..");
                System.out.println("Thread two notify thread one to continue run..");
                System.out.println("Thread two sleep 2 second..");
                WaitOrSleep.class.notify();
                try {
                    WaitOrSleep.class.wait();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread two continue run..");
                System.out.println("Thread two run finish.");
            }
        }
    });

    public static void main(String[] args) {
        thread.start();
        thread1.start();
    }
}
