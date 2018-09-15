package 马士兵高并发编程公开课.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程打断等待
 * 使用ReentrantLock还可以调用lockInterruptibly方法，可以对线程interrupt方法做出响应。
 * 在一个线程等待锁的过程中，可以被打断。
 * <br>类名：InterruptWaitingDemo<br>
 * 作者： mht<br>
 * 日期： 2018年9月15日-下午11:01:49<br>
 */
public class InterruptWaitingDemo {
    
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        
        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                System.out.println("interrupted!");
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        
        
    }
    
    

}
