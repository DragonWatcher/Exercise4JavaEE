package 马士兵高并发编程公开课.内部类单例模式;
/**
 * 线程安全的单例 模式
 * <br>类名：Singleton<br>
 * 作者： mht<br>
 * 日期： 2018年9月1日-下午2:53:17<br>
 */
public class Singleton {

    private Singleton() {
        System.out.println("single");
    }
    
    private static class Inner {
        private static Singleton s = new Singleton();
    }
    
    public static Singleton getSingleton() {
        return Inner.s;
    }
}
