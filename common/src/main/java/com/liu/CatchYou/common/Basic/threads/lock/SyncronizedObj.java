package com.liu.CatchYou.common.Basic.threads.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by simon.liu on 2018/2/5.
 */
public class SyncronizedObj {
   public int count = 0;
   public void increment() {
      synchronized (this) {
         count++;
      }
   }


   public static void main(String[] args) {
      SyncronizedObj obj = new SyncronizedObj();
      ExecutorService executorService = Executors.newFixedThreadPool(1000);
      IntStream.range(0, 100000).forEach(value -> executorService.submit(new Runnable() {
         @Override
         public void run() {
            obj.increment();
         }
      }));

      stop(executorService);

      System.out.println(obj.getCount());
   }

   public static void stop(ExecutorService executorService) {
      executorService.shutdown();
      while (true) {
         if (executorService.isTerminated()) {
            break;
         }
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }

   public int getCount() {
      return count;
   }
}
