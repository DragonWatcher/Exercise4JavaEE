package thinging.in.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author mht
 *
 */
public class SleepingTask extends LiftOff{
    @Override
    public void run() {
        try {
            while(countDown-- > 0){
                System.out.println(status());
                //Old-style:
                //Thread.sleep(100);
                //Java 5/6-style
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
    
    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exe.execute(new SleepingTask());
        }
        exe.shutdown();
    }
}
