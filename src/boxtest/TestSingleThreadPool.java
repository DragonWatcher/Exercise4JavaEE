package boxtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingleThreadPool {
    private static ExecutorService singleThreadEtr = Executors.newSingleThreadExecutor();
    

    public static void main(String[] args) {

    }
    
    
    public static void simpleSingleThreadPool() {
        singleThreadEtr.execute(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("first---SingleExecutor");
                }
            }
        });
        System.out.println();
        
    }

}
