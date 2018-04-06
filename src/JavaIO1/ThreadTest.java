package JavaIO1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

    public static void main(String[] args) {
        threadPool();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("异常！");
        }
        System.err.println("程序的尽头");
        System.err.println("程序的尽头");
        System.err.println("程序的尽头");
        System.err.println("程序的尽头");
        System.err.println("程序的尽头");
        System.err.println("程序的尽头");
        System.err.println("程序的尽头");
        System.err.println("程序的尽头");
        System.err.println("程序的尽头");
        System.err.println("程序的尽头");
        System.err.println("程序的尽头");
        System.err.println("程序的尽头");
        System.err.println("程序的尽头");
    }
    
    public static void threadPool(){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new Runnable() {
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    System.out.println(i + "--RUNNING...");
                }
                subThreadPool();
            }
        });
        try {
            cachedThreadPool.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void subThreadPool(){

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new Runnable() {
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    System.out.println(i + "--subruning...");
                }
            }
        });
    }
}
