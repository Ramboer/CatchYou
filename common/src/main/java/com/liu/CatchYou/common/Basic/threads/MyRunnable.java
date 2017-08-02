package com.liu.CatchYou.common.Basic.threads;

/**
 * Created by dmrj on 2017-06-23.
 */
public class MyRunnable implements Runnable {
    public void run() {
        System.out.println("this is : " +  Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
