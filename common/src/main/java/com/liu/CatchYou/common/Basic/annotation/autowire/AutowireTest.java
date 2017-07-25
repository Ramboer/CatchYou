package com.liu.CatchYou.common.Basic.annotation.autowire;

/**
 * Created by simon.liu on 2017/7/25.
 */
public class AutowireTest {
    private static Demo demo = new Demo();
    public static void main(String[] args) {
         Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                demo.say();
            }
        });
        thread.start();
        boolean isInject = MyReflex.injectObject(demo);
        if (isInject) {
            demo.say();
        } else {
            System.out.println("Inject Fail..");
        }
    }
}
