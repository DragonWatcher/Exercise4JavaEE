package 马士兵高并发编程公开课.ThreadLocal类;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal线程局部变量<br>
 * 
 * ThreadLocal是使用空间换时间，synchronized是使用时间换空间<br>
 * 比如在hibernate中session就存在于ThreadLocal中，避免<br>
 * synchronized的使用。<br>
 * 
 * 运行下面的程序，理解ThreadLocal类 <br>
 * 类名：ThreadLocal_02<br>
 * 作者： mht<br>
 * 日期： 2018年10月5日-下午8:28:26<br>
 */
public class ThreadLocal_02 {
    /*volatile static Person p = new Person();*/
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
            /**
             * 输出为null，因为从ThreadLocal中取出的对象一定是本线程中set的对象，
             * 别的线程无法取出，因为线程自己放入的对象只能自己取得，因此无需进行加锁处理，
             * 执行效率上ThreadLocal比synchronized要高。
             */
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            tl.set(new Person());
        }).start();
    }

    static class Person {
        String name = "zhangsan";
    }
}
