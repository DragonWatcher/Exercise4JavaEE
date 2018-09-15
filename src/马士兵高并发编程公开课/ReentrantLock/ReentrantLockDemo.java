package 马士兵高并发编程公开课.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock用于替代synchronized
 * 由于m1锁定this，只有m1执行完毕的时候，m2才能执行
 * 
 * 使用ReentrantLock可以完成同样的功能
 * 需要注意的是，必须要手动释放锁
 * 使用synchronized锁定的话如果遇到异常，jvm会自动释放锁，
 * 但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 * <br>类名：ReentrantLock<br>
 * 作者： mht<br>
 * 日期： 2018年9月2日-下午6:48:30<br>
 */
public class ReentrantLockDemo {
    Lock lock = new ReentrantLock();
    
    void m1() {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();// 比较一下未释放锁前后的执行区别
        }
    }
    
    void m2() {
        lock.lock();
        System.out.println("m2...");
        lock.unlock();
    }
    
    public static void main(String[] args) {
        ReentrantLockDemo r1 = new ReentrantLockDemo();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r1::m2).start();
    }
    // 解析：使用同一把锁，可以让两段加锁的代码互斥。Lock.lock()相当于synchronized(this)
    
}
