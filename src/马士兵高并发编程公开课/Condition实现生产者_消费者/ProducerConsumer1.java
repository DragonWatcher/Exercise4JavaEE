package 马士兵高并发编程公开课.Condition实现生产者_消费者;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法 <br>
 * 能够支持2个生产线程以及10个消费者线程的阻塞调用。
 * 
 * 使用wait和notify/notifyAll来实现 <br>
 * 类名：ProducerConsumer1<br>
 * 作者： mht<br>
 * 日期： 2018年10月2日-下午6:21:07<br>
 */
public class ProducerConsumer1<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;// 最多10个元素
    private int count = 0;

    public synchronized void put(T t) {
        while (lists.size() == this.MAX) {// 想想为什么用while而不是if
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        lists.add(t);
        count++;
        this.notifyAll();// 通知消费者线程进行消费
    }

    public synchronized T get() {
        T t = null;

        while (lists.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        t = lists.removeFirst();
        count--;
        this.notifyAll();// 通知生产者进行生产
        return t;
    }

    public static void main(String[] args) {
        ProducerConsumer1<String> c = new ProducerConsumer1<>();
        // 启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(c.get());
                }
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    c.put(Thread.currentThread()
                                .getName()
                            + " " + j);
                }
            }).start();
        }
    }
}
