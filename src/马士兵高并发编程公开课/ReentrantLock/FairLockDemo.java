package 马士兵高并发编程公开课.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 公平锁实现
 * <br>类名：FairLockDemo<br>
 * 作者： mht<br>
 * 日期： 2018年9月29日-下午12:42:40<br>
 */
public class FairLockDemo extends Thread {
    /** 参数为true为公平锁 */
    private static Lock lock = new ReentrantLock(true);

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLockDemo demo = new FairLockDemo();
        Thread th1 = new Thread(demo);
        Thread th2 = new Thread(demo);
        th1.start();
        th2.start();
    }
}
