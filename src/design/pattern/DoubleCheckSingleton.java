package design.pattern;

/**
 * 双重检查单例模式 使用双重检查同步延迟加载来创建单例的做法是一个非常优秀的做法， 其不但保证了单例（线程安全），而且切实提高了程序的运行效率。 <br>
 * 类名：DoubleCheckSingleton<br>
 * 作者： mht<br>
 * 日期： 2018年3月19日-下午10:04:47<br>
 */
public class DoubleCheckSingleton {
    /**
     * Java语言提供了一种稍弱的同步机制，即volatile变量，用来确保将变量的更新操作通知到其他线程。当把变量声明<br>
     * 为volatile类型后，编译器与运行时都会注意到这个变量是共享的，因此不会将该变量上的操作与其他内存操作一起重排序。<br>
     * volatile变量不会被缓存在寄存器或者对其他处理器不可见的地方，因此在读取volatile类型的变量时总会返回最新写入的值。<br>
     * volatile关键字的具体含义需要另行查询，在此不做过多解释。
     */
    // 使用volatile关键字防止重排序，因为 new Instance()是一个非原子操作。
    private static volatile DoubleCheckSingleton dcs;

    private DoubleCheckSingleton() {

    }

    /**
     * 为了在保证单例的前提下提高运行效率，我们需要对 dcs进行第二次检查，目的是避开过多的<br>
     * 同步（因为这里的同步只需在第一次创建实例时才同步，一旦创建成功，以后获取实例时就不需要同步获取锁了）。<br>
     * 这种做法无疑是优秀的，但是我们必须注意一点：<br>
     * 必须使用volatile关键字修饰单例引用。 <br>
     * 作者： mht<br>
     * 时间：2018年3月19日-下午10:14:37<br>
     */
    public static DoubleCheckSingleton getInstance() {
        // Double-Check idiom
        if (dcs == null) {
            synchronized (DoubleCheckSingleton.class) {
                // 只需在第一次创建实例时才同步
                if (dcs == null) {
                    dcs = new DoubleCheckSingleton();
                }
            }
        }

        return dcs;
    }
}
