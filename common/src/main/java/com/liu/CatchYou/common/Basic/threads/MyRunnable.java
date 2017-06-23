package com.liu.CatchYou.common.Basic.threads;

/**
 * Created by dmrj on 2017-06-23.
 */
public class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i <10; i++) {
            System.out.println("this is count : " + i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
