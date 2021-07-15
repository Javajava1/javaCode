package edu.nwpu.zhao.Test;

import java.util.concurrent.*;

/**
 * @author:weilongzhao
 * @time:2021/7/15 16:22
 *
 * 多线程已经有extants Thread 和Runnable 接口，为什么需要Callable 接口
 */
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" come in");
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread());
        new Thread(futureTask,"AA").start();
        System.out.println(Thread.currentThread().getName()+" come in");
        System.out.println(futureTask.get()+100);
    }
}
