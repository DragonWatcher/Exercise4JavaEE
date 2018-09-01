package 马士兵高并发编程公开课.wait_notify_CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 使用wait和notify 完成最终的目标MyContainer2.java最终解决方法
 * 使用wait和notify在线程之间来回等待和叫醒，这样做的确可以完成要求，但是
 * 这样做非常的麻烦
 * 类名：MyContainer2<br>
 * 作者： mht<br>
 * 日期： 2018年9月1日-上午11:04:54<br>
 */
public class MyContainer3 {
    // 如果不加volatile，lists的变化无法及时被其他线程感知，因此可能导致不可见的问题
    volatile List<Object> lists = new ArrayList<>();
    
    public void add(Object o) {
        lists.add(o);
    }
    
    public int size() {
        return lists.size();
    }
    /**
     * 使用wait和notify必须锁定同一个Object，否则将不能使用wait和notify，虽然size=5时线程1发出了notify的命令
     * 唤醒了t2，但是notify不会释放lock，t2依然需要阻塞，等待t1执行完后释放锁后才可以执行。另外sleep()也是不释放锁的。
     */
    public static void main(String[] args) {
        MyContainer3 c = new MyContainer3();
        // 锁对象，可以是任意的一个对象，使用wait和notify必须在同一个对象锁上
        final Object lock = new Object();
        
        new Thread(() -> {
            System.out.println("t2启动");
            synchronized (lock) {
                // 这里判断size是否等于5，如果不满足条件，则t2进入等待状态
                if (c.size() != 5) {
                    try {
                        System.out.println("size = " + c.size() + ",t2 wait...");
                        // wait会让当前线程进入阻塞状态，并释放锁
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2结束");
                // 注意！！wait状态的线程不会因为其他线程的结束而自动执行，必须叫醒线程1
                lock.notify();
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
                        System.out.println("size = 5, 叫醒其他线程！");
                        lock.notify();// notifyAll()可以唤醒全部等待中的线程，随机抢得
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
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
