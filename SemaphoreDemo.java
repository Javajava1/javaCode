package edu.nwpu.zhao.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for(int i = 0;i<5;i++){
            final int tmpInt = i;
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(tmpInt+"is in");
                    TimeUnit.SECONDS.sleep(3);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
