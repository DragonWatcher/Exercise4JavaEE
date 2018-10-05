package 马士兵高并发编程公开课.ThreadLocal类;

import java.util.concurrent.TimeUnit;

/**
 * 下面的程序p变量应该加上volatile，如果不加，则线程t1有可能读到的是"lisi"也有可能读到的是"zhangsan"。
 * 而加上volatile一定会读到"lisi"。
 * <br>
 * 类名：ThreadLocal_01<br>
 * 作者： mht<br>
 * 日期： 2018年10月5日-下午8:24:40<br>
 */
public class ThreadLocal_01 {
    volatile static Person p = new Person();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + p.name);
        }, "t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            p.name = "lisi";
        }, "t2").start();
    }
}

class Person {
    String name = "zhangsan";
}
