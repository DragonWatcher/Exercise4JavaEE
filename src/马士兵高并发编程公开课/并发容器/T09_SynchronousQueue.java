package 马士兵高并发编程公开课.并发容器;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 同步队列 SynchronousQueue是一种特殊的TransferQueue。 它的容量为0，是没有容量的队列，在消费者正在等待的时候，
 * 必须使用put（实际上内部使用的是transfer），放入的任何元素 都必须直接交给消费者，而不能放入容器中。 <br>
 * 类名：T09_SynchronusQueue<br>
 * 作者： mht<br>
 * 日期： 2018年11月9日-上午5:31:35<br>
 */
public class T09_SynchronousQueue { // 容量为0
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        // strs.put("aaa"); // 阻塞等待消费者消费
        strs.add("aaa");

        System.out.println(strs.size());
    }

}
