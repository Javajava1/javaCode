package edu.nwpu.zhao.Test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    //前五个线程做完后，主线程才能执行
    //如何保证是期望的线程完成后，（cpu存在很多其它线程），因为在对应的线程结束后调用cdl.countDown();
    //主线程上没有写cdl.await() 会发生什么?->主线程可能先实行
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(5);
        for(int i = 0;i<5;i++){
            final int tmpInt = i;
            new Thread(()->{
                System.out.println(tmpInt+"is over");
                cdl.countDown();
            },String.valueOf(i)).start();
        }
        cdl.await();
        System.out.println("all is over");
    }
}
