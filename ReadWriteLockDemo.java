package edu.nwpu.zhao.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    private Map map = new HashMap();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key,Object value){
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t is writing:"+key);
            try{
                TimeUnit.MILLISECONDS.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"writing is over");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }
    public void get(String key){
        rwLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t正在读取");
            try{
                TimeUnit.MILLISECONDS.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t读取完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().lock();
        }
    }

    public void getWithoutLock(String key){
        System.out.println(Thread.currentThread().getName()+"\tis reading");
        try{
            TimeUnit.MILLISECONDS.sleep(300);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Object result = map.get(key);
        System.out.println(Thread.currentThread().getName()+"\treading is over");
    }

    public static void main(String[] args) {
        ReadWriteLockDemo rwLockDemo = new ReadWriteLockDemo();
        for(int i = 0;i<5;i++){
            final int tmpInt = i;
            new Thread(()->{
                rwLockDemo.put("" + tmpInt, tmpInt);
            },String.valueOf(i)).start();
        }
        for(int i = 0;i<5;i++){
            final int tmpInt = i;
            //“使用final方法的原因有两个。第一个原因是把方法锁定，以防任何继承类修改它的含义；第二个原因是效率。在早期的Java实现版本中，会将final
            // 方法转为内嵌调用。但是如果方法过于庞大，可能看不到内嵌调用带来的任何性能提升。在最近的Java版本中，不需要使用final方法进行这些优化了。“
            //对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象
            new Thread(()->{
                rwLockDemo.get(""+tmpInt);
            },String.valueOf(i)).start();
        }
    }
}
