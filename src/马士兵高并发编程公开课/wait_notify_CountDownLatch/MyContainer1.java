package 马士兵高并发编程公开课.wait_notify_CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 曾经的面试题（淘宝？）
 * 实现一个容器，提供两个方法：add , size
 * 写两个线程，线程1 为容器添加10个元素，线程2实时监控容器中元素的个数，
 * 当个数为5时，线程2给出提示并结束
 * 分析下面这个程序，能完成这个功能吗？
 * <br>类名：MyContainer1<br>
 * 作者： mht<br>
 * 日期： 2018年9月1日-上午10:23:45<br>
 */
public class MyContainer1 {
    // 如果不加volatile，lists的变化无法及时被其他线程感知，因此可能导致不可见的问题
    volatile List<Object> lists = new ArrayList<>();
    
    public void add(Object o) {
        lists.add(o);
    }
    
    public int size() {
        return lists.size();
    }
    
    public static void main(String[] args) {
        MyContainer1 c = new MyContainer1();
        
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();
        
        new Thread(() -> {
            /* t2循环检测c中的大小是否已经等于5*/
            while(true) {
                if (c.size() == 5) {
                    break;
                }
            }
            System.out.println("t2 结束");
        }, "t2").start();
    }
}
