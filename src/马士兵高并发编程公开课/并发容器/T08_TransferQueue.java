package 马士兵高并发编程公开课.并发容器;

import java.util.concurrent.LinkedTransferQueue;

/**
 * TransferQueue提供了一种特殊的方法叫做transfer()， 这个方法在有消费者等待消费的时候，不会将元素放入队列中，
 * 而是直接传递给消费者。因此这种方法非常适用于高并发的情况下。 但是，当没有消费者的时候，那么transfer就会阻塞，而其他类似的
 * 方法如put()，add()都不会阻塞。在实时消息处理中用到的比较多， 例如Netty <br>
 * 类名：T08_TransferQueue<br>
 * 作者： mht<br>
 * 日期： 2018年11月9日-上午5:21:43<br>
 */
public class T08_TransferQueue {

    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        strs.transfer("aaa");

        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }
}
