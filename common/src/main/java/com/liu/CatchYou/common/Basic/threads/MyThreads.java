package com.liu.CatchYou.common.Basic.threads;

/**
 * Created by dmrj on 2017-06-23.
 */
public class MyThreads extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("this is count : " + i );
        }
    }

    public static void main(String[] args) {
        MyThreads myThreads = new MyThreads();
        myThreads.start();
    }
}
