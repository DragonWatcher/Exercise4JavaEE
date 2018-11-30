package 马士兵高并发编程公开课.并发容器;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T06_ArrayBlockingQueue {

    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);

    static Random rdm = new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a" + i);
        }

//         strs.put("aaa");// 线程阻塞，知道有空闲位置
//         strs.add("aaa"); // output:java.lang.IllegalStateException: Queue full
//        strs.offer("aaa"); // output:[a0, a1, a2, a3, a4, a5, a6, a7, a8, a9]
         strs.offer("aaa", 3, TimeUnit.SECONDS);// 阻塞，但可以指定超时时间

        System.out.println(strs);
    }

}
