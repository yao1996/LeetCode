package com.ykqfrost.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ykq
 * @date 2020/10/19
 */
public class PCModeLock {

    private int contains = 0;
    private ReentrantLock lock = new ReentrantLock(false);
    private Condition producerCondition = lock.newCondition();
    private Condition consumerCondition = lock.newCondition();

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
        PCModeLock pcMode = new PCModeLock();
        pcMode.start();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    lock.lock();
                    while (contains == 10) {
                        producerCondition.await();
                    }
                    contains++;
                    System.out.println("produce " + contains);
                    consumerCondition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
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
                try {
                    lock.lock();
                    while (contains == 0) {
                        consumerCondition.wait();
                    }
                    System.out.println("consume " + contains);
                    contains--;
                    producerCondition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }
}
