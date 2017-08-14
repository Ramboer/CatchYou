package com.liu.CatchYou.common.Basic.threads;

/**
 * Created by dmrj on 2017-06-23.
 */
public class MyRunnable implements Runnable {
    public void run() {
        synchronized (this) {
            for (int i = 0; i <1000; i++) {
                System.out.println(Thread.currentThread().getName() + " this is count : " + i);
            }
        System.out.println("this is : " +  Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable,"A");
        Thread thread1 = new Thread(myRunnable, "B");
        thread.start();
        thread1.start();
    }
}
