package com.liu.CatchYou.common.Basic.threads;

/**
 * Created by simon.liu on 2017/7/26.
 */
public class Volatile extends Thread{
    public static  volatile boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        new Volatile().start();
        Thread.sleep(100);
        flag = true;
    }

    @Override
    public void run() {
        while (!flag) {
            /*try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            //System.out.println(Thread.currentThread().getName() + " is running.");
            //System.out.println("hh");
        }
        System.out.println("Thread is stop.");
    }
}
