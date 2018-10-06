package 马士兵高并发编程公开课.火车票问题;

import java.util.LinkedList;
import java.util.List;

/**
 * 有N张火车票，每张票都有一个编号 同时有10个窗口对外销售请写一个模拟程序 <br>
 * 使用synchronized进行线程同步，可以有效解决逻辑问题，但是很明显，这种方法的缺点就是效率低下。<br>
 * 类名：TicketSell_03<br>
 * 作者： mht<br>
 * 日期： 2018年10月6日-下午5:16:50<br>
 */
public class TicketSell_03 {
    static List<String> tickets = new LinkedList<>();

    static {
        for (int i = 0; i < 10000; i++)
            tickets.add("票编号： " + i);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (tickets) {
                        if (tickets.size() == 0)
                            break;
                        System.out.println("销售了票--" + tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
