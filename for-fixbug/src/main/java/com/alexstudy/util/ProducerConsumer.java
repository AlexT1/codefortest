package com.alexstudy.util;

/**
 * @author AlexTong
 * @ClassName ConsumerAndProvider
 * @Description TODO()
 * @date 2018/2/7 17:35:54
 */
public class ProducerConsumer {
        public static void main(String[] args) {
            SyncStack ss = new SyncStack();
            Producer p = new Producer(ss);
            Consumer c = new Consumer(ss);
            new Thread(p).start();
            new Thread(p).start();
            new Thread(p).start();
            new Thread(c).start();
        }
    }

    class WoTou {
        int id;
        WoTou(int id) {
            this.id = id;
        }
        public String toString() {
            return "WoTou : " + id;
        }
    }

    class SyncStack {
        int index = 0;
        WoTou[] arrWT = new WoTou[6]; //仓库只能存放6个

        public synchronized void push(WoTou wt) {
            while(index == arrWT.length) { //仓库满时不生产
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.notifyAll();
            arrWT[index] = wt;
            index ++;
        }

        public synchronized WoTou pop() {
            while(index == 0) {//仓库为空时等待，释放对象锁
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.notifyAll();//通知其他等待锁
            index--;
            return arrWT[index];
        }
    }

    class Producer implements Runnable {
        SyncStack ss = null;
        Producer(SyncStack ss) {
            this.ss = ss;
        }

        public void run() {
            for(int i=0; i<20; i++) {
                WoTou wt = new WoTou(i);
                ss.push(wt);
                System.out.println("生产了：" + wt);
                try {
                    Thread.sleep((int)(Math.random() * 200));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        SyncStack ss = null;
        Consumer(SyncStack ss) {
            this.ss = ss;
        }

        public void run() {
            for(int i=0; i<20; i++) {
                WoTou wt = ss.pop();
                System.out.println("消费了: " + wt);
                try {
                    Thread.sleep((int)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
