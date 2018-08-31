package call;

public class TestWidget {

    public static void main(String[] args) throws InterruptedException {
        // 创建一个子类对象
        final Child widget = new Child();
        // 定义线程1
        Thread th1 = new Thread("th1") {
            @Override
            public void run() {
                System.out.println(super.getName() + ":start...");
                widget.doMyLike();
            }
        };
        // 定义线程2
        Thread th2 = new Thread("th2") {
            @Override
            public void run() {
                System.out.println(super.getName() + ":start...");
                /**
                 * 下行在th1刚刚调用子类重写的父类加锁方法doSometing()时，
                 * 另一个线程th2直接调用父类的其他加锁方法会出现等待现象，说明th1调用子类中重写的加锁方法会立刻持有父类锁，
                 * 此时不允许调用父类其他的加锁方法
                 */
                 widget.doAnother();
                /**
                 * 下行在th1开始调用子类重写的父类加锁方法后，立刻通过另一个线程th2调用父类的未加锁方法doNother()，
                 * th2会立刻执行完毕，不需要等待，也就 证明了内置锁对那些没有加锁的方法是不起作用的，也就是说这些没有加锁的方法，
                 * 不会因为其他线程持有该类的内置锁就处于等待或阻塞的状态而无法执行
                 */
                // widget.doNother();
                /**
                 * 如果说调用doAnother证明了调用重写的父类加锁方法会直接持有父类锁的话，
                 * 那么下行就证明了调用子类的加锁方法也一定会获得该类的内置锁，就算这个方法已经
                 * 持有了父类锁，也就是说线程th1在执行doSomething()之初就持有了子类锁和父类锁两个锁，
                 */
                // widget.doMyLike();
                /** th2调用doSometing()是需要等待的，并不是继承的关系，不是重入，重入是发生在一个线程中的 */
//                 widget.doSometing();
            }
        };

        th1.start();
        Thread.sleep(100);
        th2.start();
    }
}

class Father {
    /** 唯一被子类Child重写的方法 */
    public void doSometing() {
        System.out.println(Thread.currentThread().getName() + ":Father ... do something...");
    }

    public synchronized void doAnother() {
        System.out.println(Thread.currentThread().getName() + ":Father... do another thing...");
    }

    public void doNother() {
        System.out.println(Thread.currentThread().getName() + ":Father... do Nothing...");
    }
}

class Child extends Father {

    @Override
    public synchronized void doSometing() {
        try {
            System.out.println(Thread.currentThread().getName() + ":Child do something...");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + ":end Child do something...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.doSometing();
    }

    public synchronized void doMyLike() {
        try {
            System.out.println(Thread.currentThread().getName() + ":Child do my like...");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + ":end Child my like...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
