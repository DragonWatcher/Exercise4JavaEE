package 马士兵高并发编程公开课.引用指向改变对锁的影响;

import java.util.concurrent.TimeUnit;
/**
 * 锁定某个对象，如果o的属性发生改变，不影响锁的使用，
 * 但是如果o变成另外一个对象，则锁定的对象发生改变
 * 应该避免将锁定对象的引用变成另一个对象
 * <br>类名：T<br>
 * 作者： mht<br>
 * 日期： 2018年9月1日-上午10:06:11<br>
 */
public class T {
    Object o = new Object();

    void m() {
        synchronized (o) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m, "t1").start();// 启动第一个线程

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 创建第二个线程
        Thread t2 = new Thread(t::m, "t2");
        // 锁对象发生改变，所以t2线程得以执行，如果注释掉这句话，t2 将永远得不到执行机会。
        // 这是因为锁定的是堆内存中实际的对象，而不是栈内存中的引用，如果引用指向的对象发生了改变，则新对象不会有锁。
        t.o = new Object();
        t2.start();
    }
}
