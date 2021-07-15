package edu.nwpu.zhao.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SychronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t put a");
                blockingQueue.put("a");
                System.out.println(Thread.currentThread().getName()+"\t put b");
                blockingQueue.put("b");
                System.out.println(Thread.currentThread().getName()+"\t put c");
                blockingQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t get "+blockingQueue.take());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"BBB").start();


    }
}
