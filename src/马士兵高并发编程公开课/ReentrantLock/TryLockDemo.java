package 马士兵高并发编程公开课.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock可以进行"尝试锁定"tryLock，这样无法锁定，
 * 或者在指定时间内无法锁定，线程可以决定是否继续等待。
 * <br>类名：TryLockDemo<br>
 * 作者： mht<br>
 * 日期： 2018年9月15日-下午9:56:10<br>
 */
public class TryLockDemo {

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
            lock.unlock();
        }
    }

    /**
     * 使用tryLock进行尝试锁定，不管锁定与否，方法都将继续执行， 可以根据tryLock的返回值来判断是否锁定，
     * 也可以指定tryLock的时间，由于tryLock(time)抛出异常，所以注意unLock的处理，必须放在finally中。 <br>
     * 作者： mht<br>
     * 时间：2018年9月15日-下午10:07:42<br>
     */
    void m2() {
//        boolean locked = lock.tryLock();
//        System.out.println("m2..." + locked);
//        if (locked) lock.unlock();

        boolean locked = false;
        try {
            locked = lock.tryLock(3, TimeUnit.SECONDS);
            System.out.println("m2 resume...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locked)
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        TryLockDemo r1 = new TryLockDemo();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(r1::m2).start();
    }
}
