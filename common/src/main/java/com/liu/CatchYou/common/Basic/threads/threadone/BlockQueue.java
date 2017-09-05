package com.liu.CatchYou.common.Basic.threads.threadone;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by simon.liu on 2017/9/5.
 */
public class BlockQueue {
    private static class Producer implements Runnable{
        private BlockingQueue<Integer> blockQueue;
        private volatile boolean flag = true;
        private Random random;

        public Producer(BlockingQueue<Integer> blockQueue) {
            this.blockQueue = blockQueue;
            this.flag = true;
            this.random = new Random();
        }

        @Override
        public void run() {
            while (flag) {
                int info = random.nextInt(100);
                try {
                    blockQueue.put(info);
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }

    private static class Consumer implements Runnable{
        private BlockingQueue<Integer> blockingQueue;
        private boolean flag;

        public Consumer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
            this.flag = true;
        }

        @Override
        public void run() {
            while (flag) {
                try {
                    int info = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() +  " take info : " + info);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(10);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        for (int i = 0; i < 20; i++) {
            if (i < 5) {
                new Thread(producer, "producer " + i).start();
            } else {
                new Thread(consumer, "consumer" + (i - 5)).start();
            }
        }
    }
}
