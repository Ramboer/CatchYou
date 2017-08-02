package com.liu.CatchYou.common.Basic.annotation.autowire;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by simon.liu on 2017/7/25.
 */
public class AutowireTest {
    private static Demo demo = new Demo();
    public static void main(String[] args) {
         Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                demo.say();
            }
        });
        thread.setName("HH");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(thread);
        executorService.shutdown();
        boolean isInject = MyReflex.injectObject(demo);
        if (isInject) {
            demo.say();
        } else {
            System.out.println("Inject Fail..");
        }
    }
}
