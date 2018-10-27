package 马士兵高并发编程公开课.并发容器;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class T02_CopyOnWriteList {

    public static void main(String[] args) {
        // List<String> lists = new ArrayList<>();// 会产生并发问题
        // List<String> lists = new Vector<>();
        List<String> lists = new CopyOnWriteArrayList<>();

        Random rdm = new Random();

        Thread[] ths = new Thread[100];

        for (int i = 0; i < ths.length; i++) {
            Runnable task = () -> {
                for (int j = 0; j < 1000; j++) {
                    lists.add("a" + rdm.nextInt(10000));
                }
            };

            ths[i] = new Thread(task);
        }

        runAndComputeTime(ths);

        System.out.println(lists.size());
    }

    private static void runAndComputeTime(Thread[] ths) {
        long t1 = System.currentTimeMillis();

        Arrays.asList(ths)
              .forEach(t -> t.start());

        Arrays.asList(ths)
              .forEach(t -> {
                  try {
                      t.join();
                  } catch (Exception e) {
                      e.printStackTrace();
                  }
              });

        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
}
