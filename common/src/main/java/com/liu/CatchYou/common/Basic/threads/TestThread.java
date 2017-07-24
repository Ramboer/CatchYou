package com.liu.CatchYou.common.Basic.threads;

/**
 * Created by simon.liu on 2017/7/13.
 */
public class TestThread implements Runnable{
    public void run() {
        try {
            Thread.sleep(7000);
            int i = 10;
            while (i > 0) {
                System.out.println("eat " + i--);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new TestThread());
        thread.start();
        System.out.println("start eating..");
        try {
            Thread.currentThread().sleep(6000);
            System.out.println("main thread :" + thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("123");
    }
}
