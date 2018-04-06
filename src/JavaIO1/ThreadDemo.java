package JavaIO1;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
    static ExecutorService myThread = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        ctrlLight();
//        function();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("-------------------timer running---------------------");
            }
        }, 100);
    
        
    }
    
    static public void ctrlLight(){
        myThread.execute(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("ctrlLight running in here............");
                }
            }
        });
    }
    
    static public void function(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("-------------------timer running---------------------");
            }
        }, 1 * 1000);
    }

}
