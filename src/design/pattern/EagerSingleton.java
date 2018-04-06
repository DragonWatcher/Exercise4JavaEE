package design.pattern;

/**
 * 饿汉单例模式Demo<br>
 * 单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。<br>
 * 这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。<br>
 * 这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。<br>
 * 这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。<br>
 * 
 * 类名：EagerSingleton<br>
 * 作者： mht<br>
 * 微信：baozoutianwa<br>
 * 日期： 2018年3月18日-下午8:41:01<br>
 */
public class EagerSingleton {

    /**
     * 属性私有化
     */
    private static EagerSingleton instance = new EagerSingleton();

    /**
     * 构造器私有化
     */
    private EagerSingleton() {
        System.out.println("这是构造器：LazySingleton()");
    }

    /**
     * 公开获取单例对象 <br>
     * 作者： mht<br>
     * 时间：2018年3月18日-下午8:48:42<br>
     */
    public static EagerSingleton getInstance() {

        return instance;
    }
    
    public void doSomething() {
        System.out.println("EagerSingleton is doing something now ...");
    }
}
