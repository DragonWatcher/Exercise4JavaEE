package 马士兵高并发编程公开课.火车票问题;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 有N张火车票，每张票都有一个编号 同时有10个窗口对外销售请写一个模拟程序 <br>
 * 类名：TicketSell_01<br>
 * 作者： mht<br>
 * 日期： 2018年10月6日-下午5:16:50<br>
 */
public class TicketSell_04 {
    static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 10000; i++)
            tickets.add("票编号： " + i);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String s = tickets.poll();
                    if (s == null)
                        break;
                    else
                        System.out.println("销售了--" + s);
                }
            }).start();
        }
    }
}
