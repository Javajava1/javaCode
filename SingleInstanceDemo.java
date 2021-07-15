package edu.nwpu.zhao.Test;

public class SingleInstanceDemo {
    private static SingleInstanceDemo sInstance = null;
    private SingleInstanceDemo (){
        System.out.println("sInstance is created");
    }
    public synchronized static SingleInstanceDemo get(){
        if (sInstance == null){
            sInstance = new SingleInstanceDemo();
        }
        return sInstance;
    }
}
