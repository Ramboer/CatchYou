package com.liu.CatchYou.common.Basic.threads.threadone;

/**
 * Created by simon.liu on 2017/9/5.
 */
public class ExecuteOneByOne {
    private static Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread one..");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    private static Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread two..");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    private static Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread three..");
        }
    });

    public static void main(String[] args) throws InterruptedException {
     thread.start();
     thread.join();
     thread1.start();
     thread1.join();
     thread2.start();

    }
}
