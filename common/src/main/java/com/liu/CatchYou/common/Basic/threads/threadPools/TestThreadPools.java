package com.liu.CatchYou.common.Basic.threads.threadPools;

import com.liu.CatchYou.common.Basic.threads.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dmrj on 2017/8/2.
 */
public class TestThreadPools {
    public static void main(String[] args) throws Exception{
        MyRunnable task = new MyRunnable();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
       // executorService1.execute(task);

        Thread.sleep(1000);

        System.out.println("\n");
        ExecutorService executorService2 = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 12; i++) {
            executorService2.execute(task);
        }

//        Thread.sleep(1000);
//
//        System.out.println("\n");
//        ExecutorService executorService3 = Executors.newCachedThreadPool();
//
//        for (int j = 0; j < 10; j++) {
//            executorService3.execute(task);
//        }

    }
}
