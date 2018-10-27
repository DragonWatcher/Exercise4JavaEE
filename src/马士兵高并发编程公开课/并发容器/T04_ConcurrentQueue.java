package 马士兵高并发编程公开课.并发容器;

import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T04_ConcurrentQueue {

    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedQueue<>();
        Deque<String> names = new ConcurrentLinkedDeque<>();

        for (int i = 0; i < 10; i++) {
            strs.offer("S" + i); // add
            names.offer("N" + i);
        }

        System.out.println("output#1 : " + strs);

        System.out.println("output#2 : " + strs.size());

        System.out.println("output#3 : " + strs.poll()); // FIFO，容器中的删除

        System.out.println("output#4 : " + strs.size());

        System.out.println("output#5 : " + strs.peek()); // 取出，容器中的不删

        System.out.println("output#6 : " + strs.size());
        
        System.out.println("output#7 : " + names);
        
        System.out.println("output#8 : " + names.pollLast()); // LIFO
        
        System.out.println("output#9 : " + names);
        
        System.out.println("output#10 : " + names.peekFirst()); // FIFO
        
        System.out.println("output#11 : " + names);
    }
}
