package threadsafe;

import java.util.concurrent.atomic.AtomicLong;

public class CountingFactorizer{
    private static final AtomicLong count = new AtomicLong(0);
    
    public long getCount() {
        return count.get();
    }
    
    public static long increase() {
        return count.incrementAndGet();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increase();
                    System.out.println(count.get());
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increase();
                    System.out.println(count.get());
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increase();
                    System.out.println(count.get());
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increase();
                    System.out.println(count.get());
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
