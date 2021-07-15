package edu.nwpu.zhao.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class TestMain {
    public static void  main(String arg[]){
//        new Thread(()->{
//            for(int i = 0;i < 10;i++){
//                edu.nwpu.zhao.SingleInstanceDemo sInstance = edu.nwpu.zhao.SingleInstanceDemo.get();
//            }
//        }).start();
        // java.util.concurrentModificationExcetpion
        ArrayList l1 = new ArrayList();
        //Collections.synchronizedList(l1)
//        System.out.println(l1.size());
//            for(int i = 0;i < 20;i++){
//                new Thread(()->{
//                    l1.add(UUID.randomUUID().toString().substring(0,8));
//                    System.out.println(l1);
//                    System.out.println(l1.size());
//                },String.valueOf(i)).start();
//            }
        boolean []FT = new boolean[4];
        for (int i = 0; i < 4; i++) {
            System.out.println(FT[i]);
        }
    }
}
