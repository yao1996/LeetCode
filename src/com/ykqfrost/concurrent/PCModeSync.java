package com.ykqfrost.concurrent;

/**
 * @author ykq
 * @date 2020/10/19
 */
public class PCModeSync {

    private int contains = 0;
    private int capacity = 10;

    private void start() {
        Thread c1 = new Thread(new Consumer());
        Thread c2 = new Thread(new Consumer());
        Thread c3 = new Thread(new Consumer());
        Thread c4 = new Thread(new Consumer());
        Thread p1 = new Thread(new Producer());
        Thread p2 = new Thread(new Producer());
        Thread p3 = new Thread(new Producer());
        Thread p4 = new Thread(new Producer());
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }

    public static void main(String[] args) {
        PCModeSync pcMode = new PCModeSync();
        pcMode.start();
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (PCModeSync.this) {
                    while (contains == 0) {
                        try {
                            PCModeSync.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("consume " + contains);
                    contains--;
                    PCModeSync.this.notifyAll();
                }
            }


        }
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (PCModeSync.this) {
                    while (contains == 10) {
                        try {
                            PCModeSync.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    contains++;
                    System.out.println("produce " + contains);
                    PCModeSync.this.notifyAll();
                }
            }

        }
    }
}
