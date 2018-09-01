package 马士兵高并发编程公开课.wait_notify_CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * 曾经的面试题（淘宝？） 实现一个容器，提供两个方法：add , size 写两个线程，线程1 为容器添加10个元素，线程2实时监控容器中元素的个数，
 * 当个数为5时，线程2给出提示并结束 <br>
 * 
 * 给lists添加volatile之后，t2能够接到通知，但是，t2线程的死循环很浪费cpu，如果不用死循环，该怎么做？
 * 
 * 这里使用wait和notify 做到，wait会释放锁，而notify不会释放锁。
 * 需要注意的是，运用这种方法，必须要保证t2先执行，也就是先让t2监控才可以。
 * 
 * 阅读下面程序，并分析输出结果
 * 可以读到输出结果并不是size==5时t2退出，而是t1结束时t2才接收到通知而退出
 * 想想这是为什么？
 * 
 * 类名：MyContainer2<br>
 * 作者： mht<br>
 * 日期： 2018年9月1日-上午11:04:54<br>
 */
public class MyContainer2 {
    // 如果不加volatile，lists的变化无法及时被其他线程感知，因此可能导致不可见的问题
    volatile List<Object> lists = new ArrayList<>();
    
    public void add(Object o) {
        lists.add(o);
    }
    
    public int size() {
        return lists.size();
    }
    
    public static void main(String[] args) {
        MyContainer2 c = new MyContainer2();
        // 锁对象，可以是任意的一个对象，使用wait和notify必须在同一个对象锁上
        final Object lock = new Object();
        
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2启动");
                // 这里判断size是否等于5，如果不满足条件，则t2进入等待状态
                if (c.size() != 5) {
                    try {
                        System.out.println("t2 wait...");
                        // wait会让当前线程进入阻塞状态，并释放锁
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2结束");
            }
        }).start();
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        new Thread(() -> {
            System.out.println("t1启动");
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    c.add(new Object());
                    System.out.println("add" + i);
                    // t1线程内部发出一个满足条件时的唤醒消息，notify代表唤醒一个线程，这个唤醒是随机的
                    if (c.size() == 5) {
                        lock.notify();// notifyAll()可以唤醒全部等待中的线程，随机抢得
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
