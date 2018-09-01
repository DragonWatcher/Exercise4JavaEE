package 马士兵高并发编程公开课.wait_notify_CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 曾经的面试题（淘宝？） 实现一个容器，提供两个方法：add , size 写两个线程，线程1 为容器添加10个元素，线程2实时监控容器中元素的个数，
 * 当个数为5时，线程2给出提示并结束 <br>
 * 
 * 给lists添加volatile之后，t2能够接到通知，但是，t2线程的死循环很浪费cpu，如果不用死循环，该怎么做？
 * =======================================================================
 * 使用Latch（门闩） 代替wait notify来进行通知
 * 好处是通信方式简单，同时也可以指定等待时间
 * 使用 await和countdown方法来替代wait 和 notify
 * CountDownLatch不涉及锁定，当count的值为零时当前线程继续执行
 * 当不涉及同步，只是涉及通信的时候，使用synchronized + wait/notify就显得太重了
 * 这时应该考虑CountDownLatch/CyclicBarrier/Semaphore
 * 
 * 类名：MyContainer2<br>
 * 作者： mht<br>
 * 日期： 2018年9月1日-上午11:04:54<br>
 */
public class MyContainer4 {
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
        MyContainer4 c = new MyContainer4();
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 启动");
            if (c.size() != 5) {
                try {
                    latch.await();// 和o.wait()效果类似
                    // 也可以指定时间
                    // latch.await(5, TimeUnit.SECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 结束");
        }).start();
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        new Thread(() -> {
            System.out.println("t1 启动");
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add" + i);
                
                if (c.size() == 5) {
                    // 打开门闩使得t2得以执行
                    latch.countDown();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
