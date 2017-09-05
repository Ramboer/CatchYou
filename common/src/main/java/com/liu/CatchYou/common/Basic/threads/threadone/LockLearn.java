package com.liu.CatchYou.common.Basic.threads.threadone;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by simon.liu on 2017/9/5.
 */
public class LockLearn {
    public void test() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println("do something safety.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new LockLearn().test();
    }
}
