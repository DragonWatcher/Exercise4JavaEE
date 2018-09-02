package 马士兵高并发编程公开课.wait_notify_CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 通过CountDownLatch模拟网易邮箱请求多线程
 * <br>类名：NtesDemo<br>
 * 作者： mht<br>
 * 日期： 2018年9月2日-下午12:01:36<br>
 */
public class NtesDemo {
    private volatile static Integer apiResult;
    private volatile static Integer mysqlResult;

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        
        new Thread(() -> {
            if (apiResult == null || mysqlResult == null) {
                System.out.println("apiResult = " + apiResult + ", mysqlResult = " + mysqlResult);
                try {
                    latch.await(5, TimeUnit.SECONDS);
                    // 两个结果依然有null值，则提示超时了
                    if (apiResult == null || mysqlResult == null) {
                        System.out.println("超时了");
                    } else {
                        System.out.println("mysqlResult(" + mysqlResult + ") + apiResult(" + apiResult + ") = " + (mysqlResult + apiResult));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        // 数据库查询
        new Thread(() -> {
            int count = 0;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                count++;
            }
            mysqlResult = count;
            latch.countDown();
        }).start();
        // 网易邮箱查询
        new Thread(() -> {
            int count = 0;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                count++;
            }
            apiResult = count;
            latch.countDown();
        }).start();
    }
}
