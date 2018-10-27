package 马士兵高并发编程公开课.并发容器;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T06_ArrayBlockingQueue {
    
    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);
    
    static Random rdm = new Random();
    
    public static void main(String[] args) throws InterruptedException{
        for (int i = 0; i < 10; i++) {
            strs.put("a" + i);
        }
        
//        strs.put("aaa");
//        strs.add("aaa");
        strs.offer("aaa");
//        strs.offer("aaa", 1, TimeUnit.SECONDS);
        
        System.out.println(strs);
    }

}
