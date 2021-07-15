package edu.nwpu.zhao.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference();
    public void mylock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"\t come in");
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void myunlock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"\t come out");
        atomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args){
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.mylock();
            try{
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            spinLockDemo.myunlock();
        },"AA").start();
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(()->{
            spinLockDemo.mylock();
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            spinLockDemo.myunlock();
        },"BB").start();
    }
}
