package com.liu.CatchYou.common.Basic.threads;

/**
 * Created by dmrj on 2017-06-23.
 */
public class MyThreads extends Thread {

    @Override
    public synchronized void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() +  " this is count : " + i );
            }
    }

    public static void main(String[] args) {
        MyThreads myThreads = new MyThreads();
        myThreads.setName("A");
        MyThreads myThreads1 = new MyThreads();
        myThreads1.setName("B");
        myThreads.start();
        myThreads1.start();

    }
}
