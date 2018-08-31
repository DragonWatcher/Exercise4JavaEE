package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MonitorThreadPool {
    static ExecutorService pool = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        pool.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("hello world!");
                    System.out.println(pool.toString());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
