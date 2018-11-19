package 马士兵高并发编程公开课.信号量;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/**
 * 通过信号量改装Set为有界阻塞集合
 * <br>类名：BoundedHashSet<br>
 * 作者： mht<br>
 * 日期： 2018年11月19日-下午8:39:53<br>
 */
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<>());
        this.sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        sem.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if (!wasAdded)
                sem.release();
        }
    }
    
    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved)
            sem.release();
        return wasRemoved;
    }
    
    public void print() {
        System.out.print(Thread.currentThread().getName() + " : ");
        this.set.forEach(o -> System.out.print(o + " "));
    }

    public static void main(String[] args) {
        BoundedHashSet<String> names = new BoundedHashSet<>(5);

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    names.add("name" + i);
                    
                    names.print();
                    System.out.println();
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "TH-ADD").start();
        
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "--------执行清理，删除name" + i);
                names.remove("name" + i);
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"TH-REMOVE").start();
    }
}
