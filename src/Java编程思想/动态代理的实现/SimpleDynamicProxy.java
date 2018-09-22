package Java编程思想.动态代理的实现;

import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonoboo");
    }

    public static void main(String[] args) {
        // 无代理时使用真实对象
        RealObject real = new RealObject();
        consumer(real);
        System.out.println("----------");
        // 创建一个同样继承自封装接口的代理对象，这就意味着代理对象可以表现出和真实对象相同的行为
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[] { Interface.class }, new DynamicProxyHandler(real));

        consumer(proxy);
    }

}
