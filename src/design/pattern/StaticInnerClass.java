package design.pattern;

/**
 * 懒汉饿汉结合的单例模式
 * 是通过私有静态内部类来实现延迟加载的
 * 优点是：不仅可以达到懒汉式的延迟加载，使类的加载速度提升，避免一开始占用过多内存，又具备线程安全性，无需判断，性能上
 * 也会更快一些。
 * <br>类名：StaticInnerClass<br>
 * 作者： mht<br>
 * 日期： 2018年3月19日-下午9:55:52<br>
 */
public class StaticInnerClass {
    // 私有静态内部类，按需加载，用时加载，也就是延迟加载
    private static class Holder{
        private static StaticInnerClass sic = new StaticInnerClass();
        private Holder() {
            System.out.println("这是Holder构造器...");
        }
    }

    private StaticInnerClass() {
        System.out.println("这是StaticInnerClass构造器...");
    }
    
    public static StaticInnerClass getInstance() {
        return Holder.sic;
    }
}
