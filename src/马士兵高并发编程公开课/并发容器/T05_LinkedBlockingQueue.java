package 马士兵高并发编程公开课.并发容器;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class T05_LinkedBlockingQueue {

    static BlockingQueue<String> strs = new LinkedBlockingQueue<>();

    static Random rdm = new Random();

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    strs.put("a" + i);
                    TimeUnit.MILLISECONDS.sleep(rdm.nextInt(1000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "p1").start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (;;) {
                    try {
                        System.out.println(Thread.currentThread()
                                                 .getName()
                                + " take " + strs.take());// 如果空了，就会等待
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "c" + i).start();
        }
    }
}
