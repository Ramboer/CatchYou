package com.liu.CatchYou.common.Basic.threads.threadone;

/**
 * Created by simon.liu on 2017/9/5.
 */
public class PhiEat {
    static class Chopsticks{
        private volatile boolean isHold = false;
        public synchronized void take() {
            if (isHold) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isHold = true;
        }
        synchronized void drop() {
            isHold = false;
            notifyAll();
        }
    }

    static class Thinker implements Runnable {
        static int id;
        int mid = id ++;
        private Chopsticks left;
        private Chopsticks right;
        private Chopsticks tr;
        private volatile  boolean flag;
        public Thinker(Chopsticks left, Chopsticks right, Chopsticks tr) {
            this.left = left;
            this.right = right;
            this.tr = tr;
            flag = true;
        }

        @Override
        public void run() {
            while (flag) {
                System.out.println("哲学家"+mid+"思考");
                left.take();
                right.take();
                tr.take();
                System.out.println("哲学家"+mid+"吃饭-----------------");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                left.drop();
                right.drop();
                tr.drop();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Chopsticks[] cs = new Chopsticks[10];
        for(int i = 0; i < 5; i++){
            cs[i] = new Chopsticks();
        }

        for(int i = 0; i < 5; i++){
            new Thread(new Thinker(cs[i], cs[(i+1)%5], cs[(i+2)%5])).start();
        }
    }


}
